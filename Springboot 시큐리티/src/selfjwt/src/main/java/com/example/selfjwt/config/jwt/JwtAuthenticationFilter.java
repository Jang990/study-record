package com.example.selfjwt.config.jwt;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.selfjwt.config.auth.userDetails;
import com.example.selfjwt.model.UserModel;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

// '/login' 때만 동작
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	private final AuthenticationManager authenticationManager; 
	
	// '/login'으로 로그인을 시도하는 사용자 검사
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		System.out.println("===============>"+"1번 JWT 필터");
		ObjectMapper om = new ObjectMapper();
		try {
			UserModel user = om.readValue(request.getInputStream(), UserModel.class);
			UsernamePasswordAuthenticationToken userToken = 
					new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
			Authentication authentication = authenticationManager.authenticate(userToken);
			return authentication;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	// '/login'으로 인증된 사용자를 위한 토큰만들기
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		userDetails ud = (userDetails) authResult.getPrincipal();
		
		String jwtToken = JWT.create()
				.withSubject(ud.getUser().getUsername())
				.withExpiresAt(
						new Date(System.currentTimeMillis() + 1000 * 60 * 10)
						)
				.withClaim("id", ud.getUser().getId())
				.withClaim("username", ud.getUser().getUsername())
				.sign(Algorithm.HMAC512("cos"));
				
		response.addHeader("Authorization", "Bearer "+ jwtToken);
	}
}
