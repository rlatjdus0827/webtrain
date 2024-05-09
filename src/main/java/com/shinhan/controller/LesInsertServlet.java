package com.shinhan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.dao.MemService;
import com.shinhan.dto.LesDTO;
import com.shinhan.dto.TrainDTO;
import com.shinhan.util.DateUtil;

/**
 * Servlet implementation class LesInsertServlet
 */
@WebServlet("/les/lesinsert.do")
public class LesInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("lesinsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		MemService service = new MemService();
		TrainDTO trn = (TrainDTO) session.getAttribute("trnInfo"); 
		String trnid = trn.getTrn_id();
		System.out.println(trnid);
		LesDTO les = new LesDTO();
		les.setLes_code("0");
		les.setTrn_id(trnid);
		les.setLes_machine(request.getParameter("les_machine"));
		les.setLes_date( DateUtil.getSQLDate(request.getParameter("les_date")));
		les.setLes_start_time(request.getParameter("les_start_time"));
		les.setLes_end_time(request.getParameter("les_end_time"));
		les.setLes_available_cnt(Integer.parseInt(request.getParameter("les_available_cnt")));
		les.setLes_porg(request.getParameter("les_porg"));
		
		int result = service.lesInsert(les, trnid);
		System.out.println(result+"건 입력");
		response.sendRedirect("../train/trainhome.do");
	}

}
