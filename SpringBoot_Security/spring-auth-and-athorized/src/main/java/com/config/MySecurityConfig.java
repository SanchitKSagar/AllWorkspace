package com.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {

	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		
		return httpSecurity.authorizeHttpRequests(http-> {
			http.requestMatchers("/public/**").permitAll();				// any request come with public no authentication required
			http.requestMatchers("/admin/**").hasAnyRole("ADMIN");
			http.requestMatchers("/user/**").hasAnyRole("USER");
		}).	
			formLogin(form->form.permitAll()).// open login page to send user name and password pre defined forms open to pass information 
		build();						// open default pre defined login page 
									// with action as login, with method as post and which pass csrf token

	}
	
	@Bean				// it can in memory or can in db. 
	public UserDetailsService userDetailsService() {
		List<UserDetails> listOfUser = new ArrayList<UserDetails>();
		
		String user1EncodedPassword = encodedPassword().encode("akash123");
		String adminEncodedPassword = encodedPassword().encode("admin123");
		
		listOfUser.add(User.withUsername("akash").password(user1EncodedPassword). roles("USER").build());
		listOfUser.add(User.withUsername("admin").password(adminEncodedPassword).roles("ADMIN","USER").build());
		return new InMemoryUserDetailsManager(listOfUser);
	}
	
	@Bean
	public BCryptPasswordEncoder encodedPassword() {
		return new BCryptPasswordEncoder();
	}
}
