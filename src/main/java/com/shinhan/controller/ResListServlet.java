package com.shinhan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.dao.MemService;
import com.shinhan.dto.LesDetailDTO;
import com.shinhan.dto.MemDTO;

/**
 * Servlet implementation class ResListServlet
 */
@WebServlet("/res/reslist.do")
public class ResListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemService service = new MemService();
		HttpSession session = request.getSession();
		
		MemDTO mem = (MemDTO) session.getAttribute("memInfo");
		String memid = mem.getMem_id();
		List<LesDetailDTO> ldlist = service.resInfo2(memid);
		System.out.println(ldlist.size()+"건 조회");
		request.setAttribute("ldlist", ldlist);
		RequestDispatcher rd = request.getRequestDispatcher("reslist.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
