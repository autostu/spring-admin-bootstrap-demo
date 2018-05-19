package com.xm.ctyptocoin.trade;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by xxz on 2018/5/19.
 */
public class Tests {
    @Test
    public void bCryptPasswordEncoder(){
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
}
