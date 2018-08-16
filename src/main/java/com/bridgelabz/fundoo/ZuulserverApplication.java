package com.bridgelabz.fundoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.bridgelabz.fundoo.zuulserver.filters.TokenParserPreFilter;

@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class ZuulserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulserverApplication.class, args);
	}
	
	@Bean
	public TokenParserPreFilter filter() {
		return new TokenParserPreFilter();
	}
	
}
