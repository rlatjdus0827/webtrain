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

/**
 * Servlet implementation class MemLoginServlet
 */
@WebServlet("/mem/memlogin")
public class MemLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		MemService mservice = new MemService();
//		HttpSession session = request.getSession();
//		
//		String memid = request.getParameter("id");
//		if(memid == null) return;
//		MemDTO mem = mservice.memInfo(memid);
//		System.out.println(mem);
//		
//		session.setAttribute("memInfo", mem);
//		
		RequestDispatcher rd = request.getRequestDispatcher("../auth/login.jsp");
		rd.forward(request,response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemService service = new MemService();
		String id = request.getParameter("id");
		String pass = request.getParameter("pwd");
		MemDTO mem = service.loginChk(id,pass);
		
		if(mem == null || mem.getMem_id() == "-1") {
			request.setAttribute("message", "존재하지 않는 아이디");
		} else if(mem.getMem_id() == "-2"){
			request.setAttribute("message", "비밀번호 오류");
		} else {
			ServletContext app = getServletContext();
			HttpSession session = request.getSession();
			MemDTO mem2 = service.memInfo(id);
			session.setAttribute("memInfo", mem2);
			response.sendRedirect("/webtrain/mem/memhome.do");
			return;
		}
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}

}
