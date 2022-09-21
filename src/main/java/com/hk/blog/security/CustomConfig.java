package com.hk.blog.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hk.blog.model.User;

public class CustomConfig implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	private User user;

	 public CustomConfig(User user) {
		this.user=user;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 List<GrantedAuthority>authorities=new ArrayList<>();
		 user.getListOfRoles().forEach(r->authorities.add(new SimpleGrantedAuthority("ROLE_"+r)));

		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
	
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		return user.isEnable();
	}

}
