package com.sjb.api.home.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/home")
public class HomeController {

    @RequestMapping(value="/hello")
    public ModelAndView helloWorld() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        return mv;
    }
}
