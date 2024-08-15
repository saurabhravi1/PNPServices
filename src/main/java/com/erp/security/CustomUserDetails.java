package com.erp.security;

import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.erp.dao.UserDAO;
import com.erp.entities.UserDTO;
import com.erp.model.UserModel;

public class CustomUserDetails implements UserDetails {

	private UserModel user;
	
	public CustomUserDetails(UserModel user) {
		this.user=user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority s = new SimpleGrantedAuthority(user.getRole());
		return List.of(s);
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return !(user.isExpired());
	}

	@Override
	public boolean isAccountNonLocked() {
		return !user.isLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !user.isCredentialExpired();
	}

	@Override
	public boolean isEnabled() {
		return user.isEnable();
	}
	
	public String getRole() {
		return user.getRole();
	}

}
