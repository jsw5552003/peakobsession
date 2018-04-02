package peak.app.controller;

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
            @RequestParam(value="cpassword")String confirmPassword, Model model)
    {
        StatusMessage status;
        User user = new User(email, firstName, lastName, userName, password);
        try
        {
            userService.createNewUser(user);
            status = new StatusMessage("User successfully created.", true);
        }
        catch(AuthenticationException e)
        {
            status = new StatusMessage(e.getMessage(), false);
            model.addAttribute("status", status);
        }
        return "login";
    }
}
