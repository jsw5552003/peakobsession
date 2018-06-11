package peak.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import peak.app.model.Friend;
import peak.app.model.User;
import peak.app.repository.FriendRepository;
import peak.app.repository.UserRepository;

@Service
public class FriendService {

    private static final Logger logger = LoggerFactory.getLogger(FriendService.class);

    @Autowired
    FriendRepository friendRepository;

    @Autowired
    UserRepository userRepository;

    public List<Friend> getAllFriends(String userString)
    {
        logger.debug("Get all friends for user: " + userString);
        User user = userRepository.findByEmail(userString);
        return friendRepository.findByUser(user);
    }

}
