package com.shinhan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.dao.MemService;
import com.shinhan.dto.MemDTO;
import com.shinhan.dto.TrainDTO;

/**
 * Servlet implementation class TrainLoginServlet
 */
@WebServlet("/train/trainlogin")
public class TrainLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("../auth/login.jsp");
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemService service = new MemService();
		String id = request.getParameter("id");
		String pass = request.getParameter("pwd");
		TrainDTO trn = service.loginChk2(id, pass);
		if(trn == null || trn.getTrn_id() == "-1") {
			request.setAttribute("message", "존재하지 않는 아이디");
		} else if(trn.getTrn_id() == "-2"){
			request.setAttribute("message", "비밀번호 오류");
		} else {
			ServletContext app = getServletContext();
			HttpSession session = request.getSession();
			TrainDTO trn2 = service.trnInfo(id);
			session.setAttribute("trnInfo", trn2);
			response.sendRedirect("/webtrain/train/trainhome.do");
			return;
		}
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
		
	}

}
