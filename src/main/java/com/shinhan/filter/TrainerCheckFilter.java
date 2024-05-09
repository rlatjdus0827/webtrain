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
//@WebFilter("/train/*")
public class TrainerCheckFilter extends HttpFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse rep = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		
		TrainDTO trn = (TrainDTO) session.getAttribute("trnInfo");
		
		String lastReq = (String) session.getAttribute("lastRequest");
		
		System.out.println("lastReq: " + lastReq);
		System.out.println(trn);
		if(!req.getRequestURI().endsWith("trainlogin")) {
			if(trn == null ) { 
				String path = req.getServletContext().getContextPath();				
				rep.sendRedirect(lastReq);
				return;
			}
		}
		chain.doFilter(request, response);
	}
		


}
