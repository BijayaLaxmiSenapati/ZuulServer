package com.bridgelabz.fundoo.zuulserver.utility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class TokenProvider {

	@Value("${jwt.key}")
	private String key;
	
	public String parseToken(String token) {
		Claims claim = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
		return claim.getId();
	}
}
