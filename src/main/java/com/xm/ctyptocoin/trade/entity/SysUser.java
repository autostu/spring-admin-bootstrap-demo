package com.xm.ctyptocoin.trade.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by xxz on 2018/5/19.
 */
@Entity
@Data
public class SysUser {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;

    //FetchType.EAGER：急加载。在加载一个实体的时候，其中定义是急加载的的属性(property)和字段(field)会立即从数据库中加载
    //CascadeType:级联更新
    @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private List<SysRole> roles;
}
