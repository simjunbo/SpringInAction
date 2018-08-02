package com.sjb.chapter17.web;

import com.sjb.chapter17.alerts.AlertService;
import com.sjb.chapter17.data.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/spittles")
public class SpittleController {
    @Autowired
    private AlertService service;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public void send() {
        Spittle spittle = new Spittle();
        service.sendSpittleAlert(spittle);
    }

    @RequestMapping(value = "/receive", method = RequestMethod.GET)
    public Spittle receive() {
        return service.receiveSpittleAlert();
    }
}
