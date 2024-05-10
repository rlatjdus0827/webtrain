package com.shinhan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dao.MemService;
import com.shinhan.dto.MemDTO;
import com.shinhan.dto.TrainDTO;

/**
 * Servlet implementation class TrainInsertServlet
 */
@WebServlet("/train/traininsert.do")
public class TrainInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("traininsert.jsp");
		rd.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("trn_id");
		MemService service = new MemService();
		
		if(service.alreadyMember2(id) != 0) {
			request.setAttribute("message", "이미 존재하는 아이디 입니다.");
			
		} else {
			TrainDTO trn = makeTrn(request);
			int result = service.trainInsert(trn);
			System.out.println(result+"건 입력(insert)");
			request.setAttribute("message", "회원가입 성공");
			response.sendRedirect("trainlogin");
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}
	
	private TrainDTO makeTrn(HttpServletRequest request) {
		TrainDTO trn = new TrainDTO();
		String id = request.getParameter("trn_id"); 
		String pw = request.getParameter("trn_pw"); 
		String name = request.getParameter("trn_name"); 
		String email = request.getParameter("trn_email"); 
		String phone = request.getParameter("trn_phone"); 
		
		trn.setTrn_id(id);
		trn.setTrn_pw(pw);
		trn.setTrn_name(name);
		trn.setTrn_email(email);
		trn.setTrn_phone(phone);
		System.out.println(trn);
		return trn;
	}

}
