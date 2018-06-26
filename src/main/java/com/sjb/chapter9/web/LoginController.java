package com.sjb.chapter9.web;

import com.sjb.chapter9.Spittle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by simjunbo on 2018-06-26.
 */

@Controller
@RequestMapping("/logins")
public class LoginController {
    @RequestMapping(method = RequestMethod.POST)
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password) {
        return "home";
    }
}
