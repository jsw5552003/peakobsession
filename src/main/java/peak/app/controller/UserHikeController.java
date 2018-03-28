package peak.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import peak.app.model.Mountain;
import peak.app.model.UserHike;
import peak.app.service.MountainService;
import peak.app.service.UserHikeService;
import peak.app.view.HikeView;
import peak.app.view.StatusMessage;

@Controller
public class UserHikeController {

    private final Logger logger = LoggerFactory.getLogger(UserHikeController.class);
    
    @Autowired
    UserHikeService hikeService;
    
    @Autowired
    MountainService mountainService;
    
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
    public String showAllHikes(Model model)
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
            logger.debug("     Hike: " + hikeView.getDate() + " " + hikeView.getMiles() + " miles " + 
            		hikeView.getElevation() + " feet elevation.");
            if(hikeList.get(i).getMountains() != null)
            {
            	for(Mountain mountain : hikeList.get(i).getMountains())
            	{
            		hikeView.addMountain(mountain.getName());
            		logger.debug("     Mountain: " + mountain.getName());
            	}
            }
            hikes[i] = hikeView;
            
        }
        for(int i = 0; i < hikes.length; i++)
        {
            logger.debug("HERE IT IS" + hikes[i].getMountains().toString());
        }
        model.addAttribute("hikes", hikes);
        return "myHikes";
    }
    
    @RequestMapping("/myhikes/addhike")
    public String addHike(Model model)
    {
    	logger.info("Handling a request to add a hike.");
    	commonAddHike(model);
    	return "addHike";
    }
    
    @RequestMapping(value = "/myhikes/addhike", method = RequestMethod.POST)
    public String addHike(@RequestParam(value="date")@DateTimeFormat(iso = ISO.DATE)LocalDate date,
                          @RequestParam(value="miles")double miles, @RequestParam(value="elevation")int elevation,
                          @RequestParam(value="mountain", required = false)List<String> mountains, Model model)
    {
        logger.debug("Handling a request to add a hike with date: " + date.toString() + " miles: " + miles + 
                " elevation: " + elevation);
        logger.debug("                Mountains: " + (mountains == null ? "None" : mountains.size()));
        commonAddHike(model);
        UserHike hike = new UserHike(date, miles, elevation);
        if(mountains != null)
        {
            for(String id : mountains)
            {
                logger.debug("                 Mountain ID: " + id);
                Mountain mountain = new Mountain(Long.parseLong(id));
                hike.addMountain(mountain);
            }
        }
        hikeService.addHike(hike);
        StatusMessage status = new StatusMessage("Hike successfully added for date: " + date.toString() + ".", true);
        model.addAttribute("status", status);
        return "addHike";
    }
    
    private void commonAddHike(Model model)
    {
        LocalDate local = LocalDate.now();
        model.addAttribute("today", local.toString());
        model.addAttribute("mountains", mountainService.getAllMountains());
    }
}
