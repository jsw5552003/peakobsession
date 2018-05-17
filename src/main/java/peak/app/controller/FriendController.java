package peak.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import peak.app.common.AuthenticationFacade;
import peak.app.repository.UserRepository;

@Controller
public class FriendController {

    private final Logger logger = LoggerFactory.getLogger(FriendController.class);

    @Autowired
    private AuthenticationFacade authenticationFacade;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/friends")
    public String friends(Model model)
    {
        logger.info("Handling a request to go to the friends page.");
        return "friends";
    }
}
