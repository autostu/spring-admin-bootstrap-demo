package com.xm.ctyptocoin.trade.security;

import com.xm.ctyptocoin.trade.entity.SysRole;
import com.xm.ctyptocoin.trade.entity.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by xxz on 2018/5/19.
 */
public class CustomUserDetails implements UserDetails {

    private SysUser sysUser;

    public CustomUserDetails(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<>();
        List<SysRole> roles = sysUser.getRoles();
        if (roles != null) {
            for (SysRole role : roles) {
                auths.add(new SimpleGrantedAuthority(role.getName()));
            }
        }

        return auths;
    }

    @Override
    public String getPassword() {
        return sysUser.getPassword();
    }

    @Override
    public String getUsername() {
        return sysUser.getUsername();
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
