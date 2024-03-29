package com.example.inflearnJWT.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public class SecurityUtil {

	private static final Logger logger = LoggerFactory.getLogger(SecurityUtil.class);

	private SecurityUtil() {
	}

	// Security Context의 Authentication 객체를 이용해 username을 리턴해주는 간단한 유틸성 메소드
	public static Optional<String> getCurrentUsername() {
		//Authentication이 저장되는 시점은 JwtFilter 필터를 탈때 저장된다. 그때 저장된 객체가 꺼내지게 되는 것이다.
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication == null) {
			logger.debug("Security Context에 인증 정보가 없습니다.");
			return Optional.empty();
		}

		String username = null;
		if (authentication.getPrincipal() instanceof UserDetails) {
			UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
			username = springSecurityUser.getUsername();
		} else if (authentication.getPrincipal() instanceof String) {
			username = (String) authentication.getPrincipal();
		}

		return Optional.ofNullable(username);
	}
}