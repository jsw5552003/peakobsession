package peak.app.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import peak.app.Constants;
import peak.app.model.Mountain;
import peak.app.model.UserHike;
import peak.app.service.UserHikeService;
import peak.app.view.LeaderBoardEntryView;
import peak.app.view.LeaderBoardView;

@Controller
public class LeaderBoardController {

    @Autowired
    UserHikeService hikeService;

    @RequestMapping("/leaderboard")
    public String friends(Model model) {
        List<UserHike> allHikes = hikeService.getAllHikes();
        HashMap<String, LeaderBoardEntryView> leaderMap = new HashMap<>();
        // go through the hikes and arrange data by user
        for (UserHike hike : allHikes) {
            String user = hike.getUser().getUserName();
            LeaderBoardEntryView entry = leaderMap.get(user);
            if (entry == null) {
                entry = new LeaderBoardEntryView();
                entry.setUsername(user);
                leaderMap.put(user, entry);
            }
            entry.addMiles((float)hike.getMileage());
            entry.incrementHikes();
            List<Mountain> mountains = hike.getMountains();
            for(Mountain mountain : mountains)
            {
                if(mountain.getElevation() >= Constants.FOUR_K_FEET)
                {
                    entry.incrementFourKMountains();
                }
                entry.incrementTotalMountains();
            }
        }
        // move the data from map to list
        List<LeaderBoardEntryView> leaderList = new ArrayList<LeaderBoardEntryView>(leaderMap.values());
        Collections.sort(leaderList, Comparator.comparing(LeaderBoardEntryView::getFourKMountains));
        LeaderBoardView leaderBoard = new LeaderBoardView();
        leaderBoard.setAllTimeLeaders(leaderList.subList(0, 19));
        model.addAttribute("leaderboard", leaderBoard);
        return "leaderboard";
    }

}
