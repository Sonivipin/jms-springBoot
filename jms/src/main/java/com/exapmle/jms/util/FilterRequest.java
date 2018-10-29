package com.exapmle.jms.util;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.jms.auth.AuthorizeApi;
import com.example.jms.security.LoggedinUser;

public class FilterRequest extends OncePerRequestFilter implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(FilterRequest.class);

	@Autowired
	private AuthorizeApi authorizeApi;

	@Override
	public void destroy() {
	}

	@Override
	protected void doFilterInternal(HttpServletRequest httpRequest, HttpServletResponse httpResponse, FilterChain chain)
			throws ServletException, IOException {
		try {
			Enumeration<String> enums = httpRequest.getHeaderNames();
			while (enums.hasMoreElements()) {
				String str = enums.nextElement();
				if (logger.isInfoEnabled()) {
					logger.info(str + "   value    ---" + httpRequest.getHeader(str));
				}
			}

			if (logger.isInfoEnabled()) {
				logger.info("token------------------" + httpRequest.getHeader("token"));
			}
			System.out.println(httpRequest.getRequestURL());
			LoggedinUser loggedinUser = authorizeApi.isValidToken(httpRequest.getHeader("token"),
					httpRequest.getRequestURL().toString());
			httpRequest.setAttribute("accountId", loggedinUser.getAccountId());
			httpRequest.setAttribute("user", loggedinUser.getEmail());
			chain.doFilter(httpRequest, httpResponse);
		} catch (Exception e) {
			logger.error("Not Acceptable...", e);
			httpResponse.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, e.getMessage());
			return;
		}
	}
}