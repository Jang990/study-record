package com.example.selfPrj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;

import com.example.selfPrj.config.auth.LoginFailHandler;
import com.example.selfPrj.filter.MyFilter1;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable(); 
		
		http.authorizeHttpRequests()
			.antMatchers("/user/**").authenticated()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.anyRequest().permitAll();
		
		http.formLogin()
			.loginPage("/loginForm")
			.loginProcessingUrl("/login")
			.failureHandler(loginFailHandler())
			.defaultSuccessUrl("/user/index");
		
		http.addFilterBefore(new MyFilter1(), SecurityContextPersistenceFilter.class);
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public LoginFailHandler loginFailHandler() {
		return new LoginFailHandler();
	}
	
}
