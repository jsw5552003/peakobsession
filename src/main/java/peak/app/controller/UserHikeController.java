package peak.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import peak.app.model.UserHike;
import peak.app.service.UserHikeService;
import peak.app.view.HikeView;

@Controller
public class UserHikeController {

    private final Logger logger = LoggerFactory.getLogger(UserHikeController.class);
    
    @Autowired
    UserHikeService hikeService;
    
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
        //get data from service
        List<UserHike> hikeList = hikeService.getAllHikes();
        logger.debug("Retrieved all hikes, total: " + (hikeList.isEmpty() ? "0." : hikeList.size()));
        //create array to send to template
        HikeView[] hikes = new HikeView[hikeList.size()];
        //convert backend data to view object and put in array
        for(int i = 0; i < hikes.length; i++)
        {
            HikeView hikeView = new HikeView();
            hikeView.setDate(hikeList.get(i).getDate().toString());
            hikeView.setMiles("" + hikeList.get(i).getMileage());
            hikeView.setElevation("" + hikeList.get(i).getElevation());
            hikes[i] = hikeView;
            logger.debug("     Hike: " + hikeView.getDate() + " " + hikeView.getMiles() + " miles " + 
            		hikeView.getElevation() + " feet elevation.");
        }
        model.addAttribute("hikes", hikes);
        return "myHikes";
    }
    
    @RequestMapping("/myhikes/addhike")
    public String addHike(Model model)
    {
    	logger.info("Handling a request to add a hike.");
    	return "addHike";
    }
}
