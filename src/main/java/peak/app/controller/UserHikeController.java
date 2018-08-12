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

import peak.app.Constants;
import peak.app.common.AuthenticationFacade;
import peak.app.model.Friend;
import peak.app.model.Mountain;
import peak.app.model.UserHike;
import peak.app.service.FriendService;
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
    
    @Autowired
    FriendService friendService;

    @Autowired
    private AuthenticationFacade authenticationFacade;
    
    @RequestMapping("/myhikes")
    public String showAllHikes(Model model)
    {   
        String userName = authenticationFacade.getAuthentication().getName();
        logger.info("Handling a request to show all user's hikes for " + userName);
        //get data from service
        List<UserHike> hikeList = hikeService.getAllHikes(userName);
        logger.debug("Retrieved all hikes, total: " + (hikeList.isEmpty() ? "0." : hikeList.size()));
        //create array to send to template
        HikeView[] hikes = new HikeView[hikeList.size()];
        //convert backend data to view object and put in array
        for(int i = 0; i < hikes.length; i++)
        {
            
            hikes[i] = getHikeView(hikeList.get(i));
            
        }
        model.addAttribute("hikes", hikes);
        return "myHikes";
    }
    
    @RequestMapping("/myhikes/addhike")
    public String addHike(Model model)
    {
    	logger.info("Handling a request to add a hike.");
        String userName = authenticationFacade.getAuthentication().getName();
        commonAddHike(model, userName);
    	return "addHike";
    }
    
    @RequestMapping(value = "/myhikes/addhike", method = RequestMethod.POST)
    public String addHike(@RequestParam(value="date")@DateTimeFormat(iso = ISO.DATE)LocalDate date,
                          @RequestParam(value="miles")double miles, @RequestParam(value="elevation")int elevation,
            @RequestParam(value = "mountain", required = false) List<String> mountains,
            @RequestParam(value = "friend", required = false) List<String> friends, Model model)
    {
        logger.debug("Handling a request to add a hike with date: " + date.toString() + " miles: " + miles + 
                " elevation: " + elevation);
        logger.debug("                Mountains: " + (mountains == null ? "None" : mountains.size()));
        logger.debug("                Friends: " + (friends == null ? "None" : friends.size()));
        String userName = authenticationFacade.getAuthentication().getName();
        logger.debug("User: " + userName);
        commonAddHike(model, userName);
        UserHike hike = getUserHike(date, miles, elevation, mountains, friends);
        hikeService.addHike(hike, userName);
        StatusMessage status = new StatusMessage("Hike successfully added for date: " + date.toString() + ".", true);
        model.addAttribute("status", status);
        return "addHike";
    }
    
    @RequestMapping(value = "/myhikes/edithike", method = RequestMethod.GET)
    public String editHike(@RequestParam(value = "id") long hikeId, Model model) {
    	logger.debug("Handling a request to edit a hike id: " + hikeId);
    	String userName = authenticationFacade.getAuthentication().getName();
    	logger.debug("User: " + userName);
    	//get hike
    	UserHike userHike = hikeService.getHike(hikeId);
    	HikeView hikeView = getHikeView(userHike);
    	//date needs to be in yyyy-mm-dd format for edit page to pre-fill date field
    	hikeView.setDate(userHike.getDate().format(Constants.date_format_yyymmdd));
    	model.addAttribute("hike", hikeView);
    	commonAddHike(model, userName);
    	return "editHike";
    }
    
    @RequestMapping(value = "/myhikes/edithike", method = RequestMethod.POST)
    public String editHike(@RequestParam(value="date")@DateTimeFormat(iso = ISO.DATE)LocalDate date,
                          @RequestParam(value="miles")double miles, @RequestParam(value="elevation")int elevation,
            @RequestParam(value = "mountain", required = false) List<String> mountains,
            @RequestParam(value = "friend", required = false) List<String> friends,
            @RequestParam(value = "id") long hikeId, Model model)
    {
        logger.debug("Handling a request to edit a hike with date: " + date.toString() + " miles: " + miles + 
                " elevation: " + elevation + " id: " + hikeId);
        logger.debug("                Mountains: " + (mountains == null ? "None" : mountains.size()));
        logger.debug("                Friends: " + (friends == null ? "None" : friends.size()));
        String userName = authenticationFacade.getAuthentication().getName();
        logger.debug("User: " + userName);
        UserHike hike = getUserHike(date, miles, elevation, mountains, friends);
        hike.setId(hikeId);
        hikeService.editHike(hike, userName);
        
        return showAllHikes(model);
    }
    
    @RequestMapping(value = "/myhikes/deletehike", method = RequestMethod.POST)
    public String deleteHike(@RequestParam(value = "id") long hikeId, Model model) {
    	logger.debug("Handling a request to delete a hike id: " + hikeId);
    	hikeService.deleteHike(hikeId);
        return showAllHikes(model);
    }

    private void commonAddHike(Model model, String userName)
    {
        LocalDate local = LocalDate.now();
        model.addAttribute("today", local.toString());
        model.addAttribute("mountains", mountainService.getAllMountains());
        model.addAttribute("friends", friendService.getAllFriends(userName));
    }
    
    private HikeView getHikeView(UserHike userHike)
    {
    	HikeView hikeView = new HikeView();
        hikeView.setId(userHike.getId());
        hikeView.setDate(userHike.getDate().toString());
        hikeView.setMiles("" + userHike.getMileage());
        hikeView.setElevation("" + userHike.getElevation());
        logger.debug("     Hike: " + hikeView.getDate() + " " + hikeView.getMiles() + " miles " + 
        		hikeView.getElevation() + " feet elevation.");
        if(userHike.getMountains() != null)
        {
        	for(Mountain mountain : userHike.getMountains())
        	{
        		hikeView.addMountain(mountain.getName());
        		logger.debug("     Mountain: " + mountain.getName());
        	}
        }
        if (userHike.getFriends() != null) {
            for (Friend friend : userHike.getFriends()) {
                hikeView.addFriend(friend.getName());
                logger.debug("     Friend: " + friend.getName());
            }
        }
        return hikeView;
    }
    
    private UserHike getUserHike(LocalDate date, double miles, int elevation, List<String> mountains, List<String> friends)
    {
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
         if (friends != null) {
             for (String id : friends) {
                 logger.debug("                 Friend ID: " + id);
                 Friend friend = new Friend(Long.parseLong(id));
                 hike.addFriend(friend);
             }
         }
         return hike;
    }
}
