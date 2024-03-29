package com.example.security1.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.security1.config.auth.simpleway.SecurityUser;
import com.example.security1.model.User;
import com.example.security1.repository.UserRepository;

@Service
public class PrincipalDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userEntity = userRepository.findByUsername(username);
		if(userEntity != null) {
//			return new PrincipalDetails(userEntity);
			return new SecurityUser(userEntity);
		}
		return null;
	}

}
