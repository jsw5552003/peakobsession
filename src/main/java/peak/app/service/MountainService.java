package peak.app.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import peak.app.model.Mountain;
import peak.app.repository.MountainRepository;

@Service
public class MountainService {
    
    @Autowired
    MountainRepository mountainRepository;
    
    private static final Logger logger = LoggerFactory.getLogger(MountainService.class);

    public List<Mountain> getAllMountains()
    {
        logger.info("Get all mountains");
        ArrayList<Mountain> mountainList = new ArrayList<>();
        Iterable<Mountain> mountains = mountainRepository.findAll();
        mountains.forEach(mountainList::add);
        return mountainList;
    }
    
    public String[] getAllMountainNames()
    {
        List<Mountain> mountainList = getAllMountains();
        String[] names = new String[mountainList.size()];
        for(int i = 0; i < names.length; i++)
        {
            names[i] = mountainList.get(i).getName();
        }
        return names;
    }
}
