package com.hk.blog.security;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hk.blog.model.User;
import com.hk.blog.repository.UserRepository;


@Service
public class CustomUserService implements UserDetailsService {
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User user=repository.findByEmail(username);
		 if(Objects.isNull(user))
			 throw new UsernameNotFoundException("invalid username");
		return new CustomConfig(user);
	}

}
