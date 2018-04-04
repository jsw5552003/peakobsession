package peak.app.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import peak.app.model.HikeList;
import peak.app.model.MountainList;
import peak.app.repository.MountainListRepository;

@Service
public class ListService {
    
    @Autowired
    MountainListRepository mountainListRep;
    
    private final Logger logger = LoggerFactory.getLogger(ListService.class);
    
    public List<HikeList> getAllLists()
    {
        logger.debug("Handling a request for get all lists.");
        Iterable<MountainList> mountainIter = mountainListRep.findAll();
        ArrayList<HikeList> hikeList = new ArrayList<>();
        mountainIter.forEach(hikeList::add);
        return hikeList;
    }
    
    public MountainList getMountainList(String name)
    {
        logger.debug("Handling a request for get mountain list: " + name);
        return mountainListRep.findByName(name);
    }

}
