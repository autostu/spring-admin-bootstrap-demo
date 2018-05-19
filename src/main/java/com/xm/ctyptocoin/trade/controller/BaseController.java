package com.xm.ctyptocoin.trade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xxz on 2018/5/19.
 */
@Controller
public class BaseController {
    @RequestMapping("/index")
    public String indexPage(Model mode) {
        return "index";
    }
}
