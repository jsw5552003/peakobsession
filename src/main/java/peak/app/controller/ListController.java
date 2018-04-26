package peak.app.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import peak.app.view.UserMountainGridView;
import peak.app.view.UserMountainListView;
import peak.app.view.UserMountainView;

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
            UserMountainListView returnList = new UserMountainListView();
            returnList.setDescription(mList.getDescription());
            returnList.setName(mList.getName());
            returnList.setType(Constants.LIST_TYPE_MOUNTAIN);
            Map<Mountain, LocalDate> mountainMap = hikeService.getMountainsHiked(userName);
            checkList(mountainMap, mList, returnList);
            logger.info("Adding a list of size: "
                    + (returnList.getMountains() == null ? 0 : returnList.getMountains().size()));
            model.addAttribute("list", returnList);
        }
        return "mylist";
    }

    @RequestMapping("/list/grid/user")
    public String showUserGrid(@RequestParam(value = "name") String name, @RequestParam(value = "type") String type,
            Model model)
    {
        logger.info("Handling a request to show user grid: " + name + " type: " + type);
        String userName = authenticationFacade.getAuthentication().getName();
        UserMountainListView[] viewArray = new UserMountainListView[12];
        if (Constants.LIST_TYPE_MOUNTAIN.equals(type))
        {
            Map<Mountain, LocalDate>[] hikesByMonth = hikeService.getMountainsHikedByMonth(userName);
            MountainList mList = listService.getMountainList(name);
            for (int i = 0; i < viewArray.length; i++)
            {
            	viewArray[i] = new UserMountainListView();
                checkList(hikesByMonth[i], mList, viewArray[i]);
            }
            viewArray[0].setName(mList.getName());
            viewArray[0].setDescription(mList.getDescription());
            viewArray[0].setType(type);
        }
        for (int i = 0; i < viewArray.length; i++)
        {
          
            if(viewArray[i].getMountains() != null)
            {
                logger.info("Number of Mountians in grid view " + i + " :" + viewArray[i].getMountains().size());
                for (UserMountainView mView : viewArray[i].getMountains())
                {
                    if (mView.isCompleted())
                        logger.info("Completed: " + mView.getName() + "Year: " + mView.getYear());
                }
            }
        }
        UserMountainGridView gridView = new UserMountainGridView(viewArray);
        model.addAttribute("grid", gridView);
        return "mygrid";
    }

    private void checkList(Map<Mountain, LocalDate> mountainMap, MountainList mList, UserMountainListView checkList)
    {
        for (Mountain mountain : mList.getMountains())
        {
            if (mountainMap.containsKey(mountain))
            {
                checkList.addMountain(new UserMountainView(mountain.getName(), mountain.getElevation(),
                        mountainMap.get(mountain).toString(), true));
            } else
            {
                checkList.addMountain(new UserMountainView(mountain.getName(), mountain.getElevation(), null, false));
            }
        }
    }
}
