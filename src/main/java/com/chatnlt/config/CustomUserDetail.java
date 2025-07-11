package com.chatnlt.config;


import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.chatnlt.entities.User;

public class CustomUserDetail implements UserDetails{

	
	public CustomUserDetail(User user) {
		super();
		this.user = user;
	}

	private User user;
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		
		SimpleGrantedAuthority simpleGrantedAuthority =new SimpleGrantedAuthority("ROLE_"+ user.getRole());
		
		
		
		
		return List.of(simpleGrantedAuthority);
	}

	@Override
	public String getPassword() {
		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		
		return user.getEmail();
	}

}
