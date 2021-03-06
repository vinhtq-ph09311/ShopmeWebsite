package poly.shopme.admin.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import poly.shopme.common.entity.Role;
import poly.shopme.common.entity.User;

public class ShopmeUserDetails implements UserDetails {

	private User user;
	
	public ShopmeUserDetails(User user) {
		this.user = user;
	}
	
	// assign by Spring security to get the list of assign role from this user
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Role> roles = user.getRoles();
		
		List<SimpleGrantedAuthority> authories = new ArrayList<>();
		
		for (Role role : roles) {
			authories.add(new SimpleGrantedAuthority(role.getName()));
		}
		
		return authories;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// kiểm tra trạng thái kích hoạt
	@Override
	public boolean isEnabled() {
		return user.isEnabled();
	}

	public String getFirstname() {
		return this.user.getFirstName();
	}
	
	public void setFirstName(String firstName) {
		this.user.setFirstName(firstName);
	}	

}
