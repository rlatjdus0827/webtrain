package com.shinhan.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.dto.MemDTO;
import com.shinhan.dto.TrainDTO;


/**
 * Servlet Filter implementation class LoginCheckFilter
 */
@WebFilter("*.do")
public class LoginCheckFilter extends HttpFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//로그인하지 않으면 업무로직 수행 못함
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse rep = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		
		
		if(!req.getRequestURI().endsWith("memlogin") || !req.getRequestURI().endsWith("trainlogin")) {
			session.setAttribute("lastRequest", req.getRequestURI());
			MemDTO mem = (MemDTO) session.getAttribute("memInfo");
			TrainDTO trn = (TrainDTO) session.getAttribute("trnInfo");

			if(mem == null && trn == null) { //로그인 되어있지 않으면 브라우저로 내려가서 로그인창으로 재요청
				String path = req.getServletContext().getContextPath();				
				rep.sendRedirect(path + "/mem/memlogin");
				return;
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
