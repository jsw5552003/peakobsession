package peak.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import peak.app.model.HikeList;

@Service
public class ListService {
    
    private final Logger logger = LoggerFactory.getLogger(ListService.class);
    
    public List<HikeList> getAllLists()
    {
        return null;
    }

}
