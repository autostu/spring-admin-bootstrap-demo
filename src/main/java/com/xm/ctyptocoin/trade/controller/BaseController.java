package com.xm.ctyptocoin.trade.controller;

import org.springframework.stereotype.Controller;

/**
 * Created by xxz on 2018/5/19.
 */
@Controller
public class BaseController {

    // 移至 WebMvcConfig
//    @RequestMapping("/index")
//    public String indexPage(Model mode) {
//        return "index";
//    }

     //直接用默认退出
//    @RequestMapping(value="/logout", method = RequestMethod.GET)
//    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null){
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return "redirect:/login?logout";
//    }
}
