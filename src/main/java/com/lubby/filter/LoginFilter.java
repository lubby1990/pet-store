package com.lubby.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lubby.bean.User;

public class LoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) req;
		if (httpReq.getRequestURI().contains("login")) {
			filterChain.doFilter(req, resp);
			return ;
		}
		

		User user = (User) httpReq.getSession().getAttribute("currentUser");
		if (user == null) {
			((HttpServletResponse) resp).sendRedirect(httpReq.getContextPath()+ "/login");
			return;
		}
			filterChain.doFilter(req, resp);
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("filter....");

	}

}
