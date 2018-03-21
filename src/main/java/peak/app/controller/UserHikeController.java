package peak.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserHikeController {

    private final Logger logger = LoggerFactory.getLogger(UserHikeController.class);
    
    @RequestMapping({"/"})
    public String redirect(Model model)
    {
        return "redirect:/home";
    }
    
    @RequestMapping("/home")
    public String home(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model)
    {
        logger.info("Handling a request to go to home page");
        model.addAttribute("name", name);
        return "home";
    }
    
    @RequestMapping("/myhikes")
    public String showAllHIkes(Model model)
    {     
        logger.info("Handling a request to show all user's hikes");
        //model.addAttribute("hikes", hikes);
        return "myHikes";
    }
}
