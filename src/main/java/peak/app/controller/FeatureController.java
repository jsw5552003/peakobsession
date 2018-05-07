package peak.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import peak.app.model.Feature;
import peak.app.service.FeatureService;

@Controller
public class FeatureController {

    private final Logger logger = LoggerFactory.getLogger(FeatureController.class);

    @Autowired
    FeatureService featureService;

    @RequestMapping("/features")
    public String features(Model model)
    {
        logger.info("Handling a request to go to features page.");
        model.addAttribute("features", featureService.getAllFeatures());
        return "features";
    }

    @RequestMapping("/features/addfeature")
    public String addFeature(Model model)
    {
        logger.info("Handling a request to go to add feature page.");
        return "addfeature";
    }

    @RequestMapping(value = "/features/addfeature", method = RequestMethod.POST)
    public String addFeature(@RequestParam(value = "name") String name,
            @RequestParam(value = "description") String description, Model model)
    {
        logger.info("Handling a request to add a feature.");
        Feature feature = new Feature(name, description);
        featureService.addFeature(feature);
        return "features";
    }
}
