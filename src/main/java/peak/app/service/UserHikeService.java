package peak.app.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import peak.app.model.Mountain;
import peak.app.model.User;
import peak.app.model.UserHike;
import peak.app.repository.MountainRepository;
import peak.app.repository.UserHikeRepository;
import peak.app.repository.UserRepository;

@Service
public class UserHikeService {
    
    @Autowired
    UserHikeRepository hikeRepository;
    
    @Autowired
    MountainRepository mountainRepository;
    
    @Autowired
    UserRepository userRepository;
    
    private static final Logger logger = LoggerFactory.getLogger(UserHikeService.class);
    
    @Transactional
    public List<UserHike> getAllHikes(String userString)
    {
        logger.info("Get all hikes for user: " + userString);
        User user = userRepository.findByEmail(userString);
        ArrayList<UserHike> hikeList = new ArrayList<>();
        Iterable<UserHike> iterable = hikeRepository.findByUser(user);
        iterable.forEach(hikeList::add);
        return hikeList;
    }
    
    @Transactional
    public List<UserHike> getAllHikes() {
        logger.info("Get all hikes.");
        ArrayList<UserHike> hikeList = new ArrayList<>();
        Iterable<UserHike> iterable = hikeRepository.findAll();
        iterable.forEach(hikeList::add);
        return hikeList;
    }

    @Transactional
    public void addHike(UserHike hike, String userString)
    {
    	logger.info("Add a hike for user: " + userString);
    	User user = userRepository.findByEmail(userString);
    	hike.setUser(user);
    	hikeRepository.save(hike);
    }

    public Map<Mountain, LocalDate> getMountainsHiked(String userString)
    {
        logger.info("Get mountains hiked for user: " + userString);
        List<UserHike> hikeList = getAllHikes(userString);
        HashMap<Mountain, LocalDate> mountainsHiked = new HashMap<>();
        for (UserHike hike : hikeList)
        {
            for (Mountain mountain : hike.getMountains())
            {
                if (!mountainsHiked.containsKey(mountain))
                {
                    mountainsHiked.put(mountain, hike.getDate());
                }
                else
                {
                    if (mountainsHiked.get(mountain).isAfter(hike.getDate()))
                    {
                        mountainsHiked.put(mountain, hike.getDate());
                    }
                }
            }
        }
        logger.info("Found mountains: " + mountainsHiked.size());

        return mountainsHiked;
    }

    public Map<Mountain, LocalDate>[] getMountainsHikedByMonth(String userString)
    {
        logger.info("Get mountains hiked by month for user: " + userString);
        Map<Mountain, LocalDate>[] returnArray = new HashMap[12];
        for (int i = 0; i < returnArray.length; i++)
            returnArray[i] = new HashMap<Mountain, LocalDate>();

        List<UserHike> hikeList = getAllHikes(userString);
        for (UserHike hike : hikeList)
        {
            int hikeMonth = hike.getDate().getMonthValue() - 1;
            for (Mountain mountain : hike.getMountains())
            {
                if (!returnArray[hikeMonth].containsKey(mountain))
                {
                    returnArray[hikeMonth].put(mountain, hike.getDate());
                }
            }
        }
        return returnArray;
    }

}
