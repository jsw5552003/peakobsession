package peak.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MountainController {

    private final Logger logger = LoggerFactory.getLogger(MountainController.class);

    @RequestMapping("/mountains")
    public String friends(Model model)
    {
        logger.info("Handling a request to go to the mountains page.");
        return "mountains";
    }
}
