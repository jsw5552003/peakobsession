package peak.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasicController {
    
    private final Logger logger = LoggerFactory.getLogger(BasicController.class);
    
    @RequestMapping("/login")
    public String login() {
        logger.debug("Handling a request to login.");
        return "login";
    }
}
