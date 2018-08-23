package com.bridgelabz.fundoo.zuulserver.filters;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.bridgelabz.fundoo.zuulserver.utility.TokenProvider;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class TokenParserPreFilter extends ZuulFilter {

	@Autowired
	private TokenProvider tokenProvider;

	@Override
	public Object run() throws ZuulException {

		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		String token = request.getHeader("token");

		String userId = tokenProvider.parseToken(token);

		ctx.addZuulRequestHeader("userId", userId);

		return null;
	}

	@Override
	public boolean shouldFilter() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		if (request.getRequestURI().startsWith("/note/")) 
			return true;
		return false;
		
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
