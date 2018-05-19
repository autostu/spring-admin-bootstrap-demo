package com.xm.ctyptocoin.trade.dao;

import com.xm.ctyptocoin.trade.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xxz on 2018/5/19.
 */
public interface SysUserDao extends JpaRepository<SysUser, Long> {
    SysUser findByUsername(String username);
}
