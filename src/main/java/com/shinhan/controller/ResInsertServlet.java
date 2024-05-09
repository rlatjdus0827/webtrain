package com.shinhan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.dao.MemService;
import com.shinhan.dto.MemDTO;
import com.shinhan.dto.ResDTO;

/**
 * Servlet implementation class ResInsertServlet
 */
@WebServlet("/res/resinsert.do")
public class ResInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		MemService service = new MemService();
		
		String lescode = request.getParameter("les_code");
		if(service.zeroCnt(lescode) != 0) {
			System.out.println("예약 실패 ( 수강 가능 인원 0 )");
			request.setAttribute("message", "예약 실패 ( 수강 가능 인원 0 )");
			response.sendRedirect("result.jsp");
		}else {
			MemDTO mem = (MemDTO) session.getAttribute("memInfo");
			String memid = mem.getMem_id();
			System.out.println(memid);
			ResDTO res = new ResDTO();
			res.setRes_code("0");
			res.setMem_id(memid);
			res.setLes_code(lescode);
			
			int result = service.resInsert(res);
			System.out.println(result+"건 입력(예약)");
			request.setAttribute("message", "예약 성공");
			response.sendRedirect("../mem/memhome.do");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
