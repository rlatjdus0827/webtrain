package com.shinhan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dao.MemService;

/**
 * Servlet implementation class ResDeleteServlet
 */
@WebServlet("/res/resdelete.do")
public class ResDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rescode = request.getParameter("res_code");
		int result = new MemService().resDelete(rescode);
		System.out.println(result + "건 삭제됨");
		response.sendRedirect("../mem/memhome.do");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
