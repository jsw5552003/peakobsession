package peak.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListController {

    private final Logger logger = LoggerFactory.getLogger(ListController.class);
    
    @RequestMapping("/lists")
    public String showAllHikes(Model model)
    {   
        logger.info("Handling a request to show lists");
        return "lists";
    }
}
