package peak.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import peak.app.common.AuthenticationFacade;
import peak.app.model.User;
import peak.app.service.UserService;
import peak.app.view.ProfileView;

@Controller
public class ProfileController {

    private final Logger logger = LoggerFactory.getLogger(ProfileController.class);

    @Autowired
    private AuthenticationFacade authenticationFacade;

    @Autowired
    private UserService userService;

    @RequestMapping("/profile")
    public String profile(@RequestParam(value = "username") String userName, Model model) {
        User user = userService.getUserByUserName(userName);
        ProfileView profileView = new ProfileView();
        profileView.setUserName(user.getUserName());
        profileView.setFirstName(user.getFirstName());
        profileView.setEmail(user.getEmail());
        profileView.setLastName(user.getLastName());
        profileView.setProfileImage("/images/icons/green-question.png");
        model.addAttribute("profile", profileView);
        return "profile";
    }

}
