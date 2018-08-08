package com.sjb.chapter18.stomp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

/**
 * Created by simjunbo on 2018-08-07.
 */
@Controller
public class MarcoController {

    private static final Logger logger =
            LoggerFactory.getLogger(MarcoController.class);

    @MessageMapping("/marco")
    @SendTo("/topic/shout")
    public Shout handleShout(Shout incoming) {
        logger.info("Received message: " + incoming.getMessage());

        Shout outgoing = new Shout();
        outgoing.setMessage("Polo!");
        return outgoing;
    }

    @SubscribeMapping({"/marco"})
    public Shout handleSubscription() {
        Shout outgoing = new Shout();
        outgoing.setMessage("Polo!");
        return outgoing;
    }

}
