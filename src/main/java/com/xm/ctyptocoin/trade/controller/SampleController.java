package com.xm.ctyptocoin.trade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by xxz on 2018/5/18.
 */
@Controller
public class SampleController {

    @RequestMapping("/hello")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/tpldemoTpl")
    public String helloHtml(Map<String, Object> map) {
        map.put("hello", "from TemplateController.helloHtml");
        return "demo";
    }

    @RequestMapping("/tpldemoTpl1")
    public String helloHtml(Model mode) {
        mode.addAttribute("hello", "from TemplateController.helloHtml");
        return "tpldemo";
    }

    @RequestMapping("/testerror")
    public String testError(Model mode) {
        int i = 1/0;
        mode.addAttribute("hello", "from TemplateController.helloHtml");
        return "tpldemo";
    }

}
