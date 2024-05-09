package com.shinhan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.dao.MemService;
import com.shinhan.dto.LesDTO;
import com.shinhan.dto.TrainDTO;

/**
 * Servlet implementation class MyLesServlet
 */
@WebServlet("/les/myles.do")
public class MyLesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		MemService service = new MemService();
		TrainDTO trn = (TrainDTO) session.getAttribute("trnInfo"); 
		String trnid = trn.getTrn_id();
		List<LesDTO> trnleslist = service.lesInfo(trnid);
		System.out.println(trnleslist.size() +"건 조회");
		request.setAttribute("trnleslist", trnleslist);
		request.getRequestDispatcher("myles.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
