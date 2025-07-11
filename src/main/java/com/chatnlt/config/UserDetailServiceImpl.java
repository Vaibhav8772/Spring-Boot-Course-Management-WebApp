package com.chatnlt.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.chatnlt.entities.User;
import com.chatnlt.repository.UserRepository;

public class UserDetailServiceImpl implements UserDetailsService{

	
	
	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user=userRepository.getUserByUserName(username);
		
		if(user==null) {
			throw new UsernameNotFoundException("User Not Found");
			
		}
		CustomUserDetail customUserDetail = new CustomUserDetail(user);
		return customUserDetail;
	}

}
