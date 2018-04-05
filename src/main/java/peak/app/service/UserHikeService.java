package peak.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    public void addHike(UserHike hike, String userString)
    {
    	logger.info("Add a hike for user: " + userString);
    	User user = userRepository.findByEmail(userString);
    	hike.setUser(user);
    	hikeRepository.save(hike);
    }

    public Set<Mountain> getMountainsHiked(String userString)
    {
        List<UserHike> hikeList = getAllHikes(userString);
        // hikeList.stream().
    }

}
