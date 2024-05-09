package com.shinhan.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dao.MemService;
import com.shinhan.dto.LesDTO;
import com.shinhan.util.DateUtil;

/**
 * Servlet implementation class LesListServlet
 */
@WebServlet("/les/leslist.do")
public class LesListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemService service = new MemService();
		List<LesDTO> leslist = service.selectLesAll2();
		System.out.println(leslist.size()+"건 조회");
		request.setAttribute("leslist", leslist);
		RequestDispatcher rd = request.getRequestDispatcher("leslist.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemService service = new MemService();
		
		Date lesdate = null;
		String lesmach = null;
		if(request.getParameter("les_date") != null) {
			lesdate = DateUtil.getSQLDate(request.getParameter("les_date"));
			List<LesDTO> lesdatelist = service.selectLesDate2(lesdate);
			
			request.setAttribute("lesdatelist", lesdatelist);
			RequestDispatcher rd = request.getRequestDispatcher("lesdatelist.jsp");
			rd.forward(request, response);
			
		} else if (request.getParameter("les_machine") != null) {
			lesmach = request.getParameter("les_machine");
			List<LesDTO> lesmachlist = service.selectLesMachine2(lesmach);
			
			request.setAttribute("lesmachlist", lesmachlist);
			RequestDispatcher rd = request.getRequestDispatcher("lesmachlist.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("message","정확한 정보를 입력하세요");
			RequestDispatcher rd = request.getRequestDispatcher("webtrain/mem/memhome.do");
			rd.forward(request, response);
		}
		
	}

}
