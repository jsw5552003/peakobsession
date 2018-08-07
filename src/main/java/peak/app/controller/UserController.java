package peak.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import peak.app.model.User;
import peak.app.service.UserService;
import peak.app.view.StatusMessage;

@Controller
public class UserController {
    
    @Autowired
    UserService userService;
    
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping({"/user/create"})
    public String createUser(Model model)
    {
        return "newUser";
    }
    
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String createUser(@RequestParam(value="firstname")String firstName,
            @RequestParam(value="lastname")String lastName, 
            @RequestParam(value="username")String userName,
            @RequestParam(value="email")String email,
            @RequestParam(value="password")String password,
            Model model)
    {
        logger.debug("Handling a request to create user with first name " + 
                       firstName + " last name: " + lastName + " user name: " +
                        userName + " email: " + email);
        StatusMessage status;
        User user = new User(email, firstName, lastName, userName, password);
        try
        {
            userService.createNewUser(user);
            status = new StatusMessage("User successfully created. Please log in.", true);
            model.addAttribute("status", status);
            logger.debug("Successfully created new user.");
        }
        catch(AuthenticationException e)
        {
            status = new StatusMessage(e.getMessage(), false);
            model.addAttribute("status", status);
            model.addAttribute("failedUser", user);
            logger.debug("Caught authentication exception, send back to create user page");
            return "newUser";
        }
        return "login";
    }
}
