package peak.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import peak.app.model.Mountain;
import peak.app.service.MountainService;
import peak.app.view.MountainView;

@Controller
public class MountainController {
	
	@Autowired
	MountainService mountainService;

    private final Logger logger = LoggerFactory.getLogger(MountainController.class);

    @RequestMapping("/mountains")
    public String mountains(Model model)
    {
        logger.info("Handling a request to go to the mountains page.");
        List<Mountain> mountains = mountainService.getAllMountains();
        ArrayList<MountainView> mountainViews = new ArrayList<MountainView>();
        for(Mountain mountain : mountains)
        {
        	mountainViews.add(new MountainView(mountain.getName(), mountain.getElevation(), mountain.getState()));
        }
        logger.info("Going to mountains page with " + mountainViews.size() + " mountains.");
        model.addAttribute("mountains", mountainViews);
        return "mountains";
    }
    
    @RequestMapping("/mountain")
    public String mountain(@RequestParam(value = "name", required = true) String name , Model model)
    {
    	logger.info("Handling a request for mountain page: " + name);
    	 model.addAttribute("name", name);
    	return "mountain";
    }
}
