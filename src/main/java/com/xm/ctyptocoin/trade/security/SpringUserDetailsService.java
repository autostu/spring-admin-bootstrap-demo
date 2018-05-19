package com.xm.ctyptocoin.trade.security;

import com.xm.ctyptocoin.trade.dao.SysUserDao;
import com.xm.ctyptocoin.trade.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by xxz on 2018/5/19.
 */
@Component
public class SpringUserDetailsService implements UserDetailsService {

    @Autowired
    SysUserDao sysUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        CustomUserDetails userDetails = new CustomUserDetails(user);
        if (userDetails == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return userDetails;
    }
}
