package com.address.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.address.security.JWTAuthenticationEntryPoint;
import com.address.security.JwtAuthenticationFilter;

@Configuration
public class SecurityConfig {

	
	@Autowired
	private JWTAuthenticationEntryPoint  jwtAuthenticationEntryPoint;
	
	@Autowired
	private JwtAuthenticationFilter  jwtAuthenticationFilter;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		//configuration
		http.csrf(csrf->csrf.disable())
		.cors(cors->cors.disable())
		.authorizeHttpRequests(
				auth->auth.requestMatchers("/address/**")
				.authenticated().requestMatchers("/auth/login").permitAll()
				.anyRequest().authenticated()
				).exceptionHandling(ex->ex.authenticationEntryPoint(jwtAuthenticationEntryPoint))
		.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		http.addFilterBefore(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class);
		return http.build();
		}
	
}
