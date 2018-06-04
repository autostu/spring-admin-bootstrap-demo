package com.xm.ctyptocoin.trade.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by xxz on 2018/5/19.
 */
@Entity
@Data
public class SysRole implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
}
