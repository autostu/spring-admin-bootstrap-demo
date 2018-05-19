package com.xm.ctyptocoin.trade.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by xxz on 2018/5/19.
 */
//@Entity
@Deprecated
public class SysUserRole {
    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private String roleId;
}
