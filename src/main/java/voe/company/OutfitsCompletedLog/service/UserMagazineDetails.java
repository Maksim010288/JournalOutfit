package voe.company.OutfitsCompletedLog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import voe.company.OutfitsCompletedLog.entity.UsersEntity;

import java.util.Collection;
import java.util.Collections;

public class UserMagazineDetails implements UserDetails {

    private UsersEntity users;

    @Autowired
    public UserMagazineDetails(UsersEntity users) {
        super();
        this.users = users;
    }

    public UserMagazineDetails(){}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(users.getRole()));
    }

    @Override
    public String getPassword() {
        return users.getPassword();
    }

    @Override
    public String getUsername() {
        return users.getEmail();
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

    @Override
    public boolean isEnabled() {
        return true;
    }
}
