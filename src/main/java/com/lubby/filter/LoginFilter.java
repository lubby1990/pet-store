package com.lubby.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
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

		if (httpReq.getRequestURI().contains("login")
				|| httpReq.getRequestURI().contains("jquery")
				|| httpReq.getRequestURI().contains("user")) {
			filterChain.doFilter(req, resp);
			return;
		}

		User user = (User) httpReq.getSession().getAttribute("currentUser");
		if (user == null) {
			((HttpServletResponse) resp).sendRedirect(httpReq.getContextPath()
					+ "/login");
			return;
		}

		// check the cookie if not add the cookie
		Cookie[] cookies = httpReq.getCookies();
		boolean haveCookie = false;
		for (Cookie k : cookies) {
			System.out.println(k);
			if (k.getValue().split("-")[0].equals(user.getUserName())) {

				Cookie cookie = new Cookie("userMessage", user.getUserName()
						+ "-"
						+ (Integer.valueOf(k.getValue().split("-")[1]) + 1));
				cookie.setComment("user_name");
				cookie.setMaxAge(60 * 60 * 24 * 7);
				((HttpServletResponse) resp).addCookie(cookie);

				haveCookie = true;

				break;
			}
		}
		if (!haveCookie) {
			Cookie cookie = new Cookie("userMessage", user.getUserName() + "-"
					+ 0);
			cookie.setComment("user_name");
			cookie.setMaxAge(60 * 60 * 24 * 7);
			((HttpServletResponse) resp).addCookie(cookie);
		}
		filterChain.doFilter(req, resp);
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("filter....");

	}

}
