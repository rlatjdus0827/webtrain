package com.shinhan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dao.MemService;
import com.shinhan.dto.TrainDTO;

/**
 * Servlet implementation class TrainUpdateServlet
 */
@WebServlet("/train/trainupdate.do")
public class TrainUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		request.setAttribute("traindetail",new MemService().trnInfo(id));
		request.getRequestDispatcher("trainupdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("trn_id");
		String pw = request.getParameter("trn_pw");
		String name = request.getParameter("trn_name");
		String email = request.getParameter("trn_email");
		String phone = request.getParameter("trn_phone");
		TrainDTO trn = new TrainDTO(id,pw,name,email,phone);
		int result = new MemService().trnUpdate(trn);
		System.out.println(result+"건 수정(update)");
		response.sendRedirect("trainlogin");
	}

}
