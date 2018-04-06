package peak.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import peak.app.Constants;
import peak.app.common.AuthenticationFacade;
import peak.app.model.HikeList;
import peak.app.model.Mountain;
import peak.app.model.MountainList;
import peak.app.service.ListService;
import peak.app.service.UserHikeService;
import peak.app.view.ListView;
import peak.app.view.MountainListView;
import peak.app.view.MountainView;

@Controller
public class ListController {
    
    @Autowired
    ListService listService;

    @Autowired
    UserHikeService hikeService;

    @Autowired
    private AuthenticationFacade authenticationFacade;

    private final Logger logger = LoggerFactory.getLogger(ListController.class);
    
    @RequestMapping("/lists")
    public String showAllLists(Model model)
    {   
        logger.info("Handling a request to show lists");
        List<HikeList> hikeList = listService.getAllLists();
        ArrayList<ListView> listViews = new ArrayList<>();
        for(HikeList hike : hikeList)
        {
            listViews.add(new ListView(hike.getName()));
        }
        model.addAttribute("lists", listViews);
        return "lists";
    }
    
    @RequestMapping("/list")
    public String showList(@RequestParam(value="name")String name,
                            @RequestParam(value="type")String type,
                             Model model)
    {
        logger.info("Handling a request to show list: " + name + " type: " + type);
        if(Constants.LIST_TYPE_MOUNTAIN.equals(type))
        {
            MountainList mList = listService.getMountainList(name);
            MountainListView mListView = new MountainListView();
            mListView.setName(mList.getName());
            mListView.setDescription(mList.getDescription());
            for(Mountain mountain : mList.getMountains())
            {
                mListView.addMountain(new MountainView(mountain.getName(),
                        mountain.getElevation()));
            }
            model.addAttribute("list", mListView);
        }
        
        return "list";
    }

    @RequestMapping("/list/user")
    public String showUserList(@RequestParam(value = "name") String name, @RequestParam(value = "type") String type,
            Model model)
    {
        logger.info("Handling a request to show user list: " + name + " type: " + type);
        String userName = authenticationFacade.getAuthentication().getName();
        if (Constants.LIST_TYPE_MOUNTAIN.equals(type))
        {
            MountainList mList = listService.getMountainList(name);
            Set<Mountain> mountainSet = hikeService.getMountainsHiked(userName);
            for (Mountain mountain : mList.getMountains())
            {
                if (mountainSet.contains(mountain))
                {

                }
            }
        }
        return "mylist";
    }
}
