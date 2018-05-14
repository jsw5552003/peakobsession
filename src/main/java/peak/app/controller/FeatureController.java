package peak.app.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import peak.app.common.AuthenticationFacade;
import peak.app.model.Feature;
import peak.app.model.User;
import peak.app.repository.UserRepository;
import peak.app.service.FeatureService;
import peak.app.view.FeatureView;
import peak.app.view.StatusMessage;

@Controller
public class FeatureController {

    private final Logger logger = LoggerFactory.getLogger(FeatureController.class);

    @Autowired
    FeatureService featureService;

    @Autowired
    private AuthenticationFacade authenticationFacade;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/features")
    public String features(Model model)
    {
        logger.info("Handling a request to go to features page.");
        List<Feature> features = featureService.getAllFeatures();
        String userName = authenticationFacade.getAuthentication().getName();
        User user = userRepository.findByUserName(userName);
        List<FeatureView> suggested = new ArrayList<>();
        List<FeatureView> accepted = new ArrayList<>();
        List<FeatureView> completed = new ArrayList<>();
        for (Feature feature : features)
        {
            logger.info("FEATURE: " + feature.toString());
            FeatureView featureView = new FeatureView();
            featureView.setName(feature.getName());
            featureView.setDescription(feature.getDescription());
            featureView.setNumVotes(feature.getNumberVotes());
            featureView.setUserVoted(feature.hasUserVoted(user));
            featureView.setCreatedDate(feature.getDateEntered().toString());
            featureView.setUsername(feature.getUser().getUserName());
            featureView.setId(feature.getId());
            featureView.setAccepted(feature.isAccepted());
            featureView.setCompleted(feature.isComplete());
            if (feature.isComplete())
            {
                completed.add(featureView);
            } else if (feature.isAccepted())
            {
                accepted.add(featureView);
            } else
            {
                suggested.add(featureView);
            }
        }
        model.addAttribute("suggested", suggested);
        model.addAttribute("accepted", accepted);
        model.addAttribute("completed", completed);
        model.addAttribute("admin", user.isAdmin());
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
        String userName = authenticationFacade.getAuthentication().getName();
        logger.info("Adding a feature for user: " + userName);
        User user = userRepository.findByUserName(userName);
        feature.setUser(user);
        featureService.addFeature(feature);
        StatusMessage status = new StatusMessage("Your feature has been successfully added.", true);
        model.addAttribute("status", status);
        return "redirect:/features";
    }

    @RequestMapping(value = "/features/vote", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String voteFeature(@RequestBody String feature)
    {
        logger.info("Handling a request to vote for a feature.");
        long featureId = Long.parseLong(feature);
        String userName = authenticationFacade.getAuthentication().getName();
        User user = userRepository.findByUserName(userName);
        logger.info("Voting for a feature for user: " + userName + " and feature:" + featureId);
        featureService.voteForFeature(user.getId(), featureId);
        return "Votes: " + featureService.getNumberFeatureVotes(featureId);
    }

    @RequestMapping(value = "/features/status/accept")
    public String acceptFeature(@RequestParam(value = "feature") String featureInput)
    {
        logger.info("Handling a request to move feature status to accepted.");
        long featureId = Long.parseLong(featureInput);
        Feature feature = featureService.getFeature(featureId);
        feature.setDateAccepted(LocalDate.now());
        feature.setAccepted(true);
        feature.setComplete(false);
        featureService.saveFeature(feature);
        return "redirect:/features";
    }

    @RequestMapping(value = "/features/status/complete")
    public String completeFeature(@RequestParam(value = "feature") String featureInput)
    {
        logger.info("Handling a request move feature status to complete.");
        long featureId = Long.parseLong(featureInput);
        Feature feature = featureService.getFeature(featureId);
        feature.setDateCompleted(LocalDate.now());
        feature.setComplete(true);
        featureService.saveFeature(feature);
        return "redirect:/features";
    }

    @RequestMapping(value = "/features/status/suggest")
    public String suggestFeature(@RequestParam(value = "feature") String featureInput)
    {
        logger.info("Handling a request to move feature status to suggest.");
        long featureId = Long.parseLong(featureInput);
        Feature feature = featureService.getFeature(featureId);
        feature.setAccepted(false);
        feature.setComplete(false);
        featureService.saveFeature(feature);
        return "redirect:/features";
    }

}
