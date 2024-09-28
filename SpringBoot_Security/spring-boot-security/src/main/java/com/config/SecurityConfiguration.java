package com.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	
	@Bean
	public UserDetailsService userDetailsService() {
		List<UserDetails> listOfUser = new ArrayList<UserDetails>();
		
		// default encoder 
//		listOfUser.add(User.withDefaultPasswordEncoder().username("akash").password("123456").roles("USER_ROLE").build());
//		listOfUser.add(User.withDefaultPasswordEncoder().username("vikash").password("2468").roles("USER_ROLE").build());
//		listOfUser.add(User.withDefaultPasswordEncoder().username("prakash").password("1357").build());
		
		// without encoder then password must be provide with prefix {noop}
		
//		listOfUser.add(User.withUsername("akash").password("{noop}1234").build());
//		listOfUser.add(User.withUsername("vikash").password("{noop}2468").build());
//		listOfUser.add(User.withUsername("prakash").password("{noop}1357").build());
		
		// with custom encoder password 
		
		String user1EncodedPassword = encodedPassword().encode("1234");
		System.out.println("User Password "+user1EncodedPassword);
		listOfUser.add(User.withUsername("akash").password(user1EncodedPassword).build());
		
		return new InMemoryUserDetailsManager(listOfUser);
	}
	
	@Bean
	public BCryptPasswordEncoder encodedPassword() {
		return new BCryptPasswordEncoder();
	}
}
