package peak.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import peak.app.model.Mountain;
import peak.app.model.UserHike;
import peak.app.repository.MountainRepository;
import peak.app.repository.UserHikeRepository;

@Service
public class UserHikeService {
    
    @Autowired
    UserHikeRepository hikeRepository;
    
    @Autowired
    MountainRepository mountainRepository;
    
    private static final Logger logger = LoggerFactory.getLogger(UserHikeService.class);
    
    @Transactional
    public List<UserHike> getAllHikes()
    {
        logger.info("Get all hikes.");
        ArrayList<UserHike> hikeList = new ArrayList<>();
        Iterable<UserHike> iterable = hikeRepository.findAll();
        iterable.forEach(hikeList::add);
        return hikeList;
    }
    
    @Transactional
    public void addHike(UserHike hike)
    {
    	logger.info("Add a hike.");
    	hikeRepository.save(hike);
    }

}