package com.shinhan.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Filter:요청 filter , 응답 filter
 * 공통적으로 여러 서블릿에 적용하기 위한 코드들을 작성한다. 
 */
@WebFilter("*.do")
public class EncodingFilter extends HttpFilter implements Filter {
       
    
    public EncodingFilter() {
       
    }


	public void destroy() {
		
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		long startTime = System.nanoTime();
		
		String path = ((HttpServletRequest)request).getContextPath();
		String uri = ((HttpServletRequest)request).getRequestURI();
		String realPath = request.getRealPath(".");
		System.out.println("path: "+path);
		System.out.println("uri: "+uri);
		System.out.println("realPath: "+realPath);
		
		
		request.setCharacterEncoding("utf-8");
		
	
		
		chain.doFilter(request, response);
		
		long endTime = System.nanoTime();
		System.out.println("해당업무를 수행하는데 걸리는 시간 : " + (endTime-startTime) + "ns");
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
