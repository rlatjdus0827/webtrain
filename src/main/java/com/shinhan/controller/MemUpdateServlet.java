package com.shinhan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dao.MemService;
import com.shinhan.dto.MemDTO;

/**
 * Servlet implementation class MemUpdateServlet
 */
@WebServlet("/mem/memupdate.do")
public class MemUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		request.setAttribute("memdetail",new MemService().memInfo(id));
		request.getRequestDispatcher("memupdate.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("mem_id");
		String pw = request.getParameter("mem_pw");
		String name = request.getParameter("mem_name");
		String email = request.getParameter("mem_email");
		String phone = request.getParameter("mem_phone");
		int cnt = Integer.parseInt(request.getParameter("mem_lesson_cnt"));
		MemDTO mem = new MemDTO(id,pw,name,email,phone,cnt);
		int result = new MemService().memUpdate(mem);
		System.out.println(result+"건 수정(update)");
		response.sendRedirect("memlogin");
	}

}
