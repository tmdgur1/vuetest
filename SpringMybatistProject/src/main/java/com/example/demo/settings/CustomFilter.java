package com.example.demo.settings;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * 주의!! 현장에서 적용되지 않음
 * @author bpn
 *
 */
@WebFilter
public class CustomFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletResponse res = (HttpServletResponse) response;
	    res.setHeader("Access-Control-Allow-Origin", "*");
	    res.setHeader("Access-Control-Allow-Methods",
	            "POST, GET, OPTIONS, DELETE");
	    res.setHeader("Access-Control-Max-Age", "3600");
	    res.setHeader("Access-Control-Allow-Headers", "x-requested-with");
	    chain.doFilter(request, res);
	}

}
