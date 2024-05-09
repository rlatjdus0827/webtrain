package com.shinhan.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.dao.MemService;
import com.shinhan.dto.MemDTO;

/**
 * Servlet implementation class MemInsertServlet
 */
@WebServlet("/mem/meminsert.do")
public class MemInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher rd = request.getRequestDispatcher("meminsert.jsp");
		rd.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("mem_id");
		MemService service = new MemService();
		if(service.alreadyMember(id) != 0) {
			request.setAttribute("message", "이미 존재하는 아이디 입니다.");
			
		}else {
			MemDTO mem = makeMem(request);
			int result = service.memInsert(mem);
			System.out.println(result+"건 입력(insert)");
			request.setAttribute("message", "회원가입 성공");
//			response.sendRedirect("memlogin.do");
//			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}
	private MemDTO makeMem(HttpServletRequest request) {
//		Enumeration<String> colnames = request.getParameterNames();
//		while(colnames.hasMoreElements()) {
//			String col = colnames.nextElement();
//			System.out.println(col + "=>" + request.getParameter(col));
//		}
		MemDTO mem = new MemDTO();
		String id = request.getParameter("mem_id");
		String pw = request.getParameter("mem_pw");
		String name = request.getParameter("mem_name");
		String email = request.getParameter("mem_email");
		String phone = request.getParameter("mem_phone");
		
		mem.setMem_id(id);
		mem.setMem_pw(pw);
		mem.setMem_name(name);
		mem.setMem_email(email);
		mem.setMem_phone(phone);
		mem.setMem_lesson_cnt(16);
		System.out.println(mem);
		return mem;
	}

}
