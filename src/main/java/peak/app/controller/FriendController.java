package peak.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import peak.app.common.AuthenticationFacade;
import peak.app.model.Friend;
import peak.app.model.User;
import peak.app.service.FriendService;
import peak.app.service.UserService;

@Controller
public class FriendController {

    private final Logger logger = LoggerFactory.getLogger(FriendController.class);

    @Autowired
    private AuthenticationFacade authenticationFacade;

    @Autowired
    UserService userService;

    @Autowired
    FriendService friendService;

    @RequestMapping("/friends")
    public String friends(Model model)
    {
        String userName = authenticationFacade.getAuthentication().getName();
        logger.info("Handling a request to go to the friends page for " + userName);
        List<Friend> friendList = friendService.getAllFriends(userName);
        List<User> userList = userService.getAllUsers();
        return "friends";
    }
}
