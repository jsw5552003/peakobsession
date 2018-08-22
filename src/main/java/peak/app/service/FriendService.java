package peak.app.service;

import java.util.ArrayList;
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
        User user = userRepository.findByUserName(userString);
        List<Friend> friends = friendRepository.findByUser(user);
        if (friends != null)
            logger.debug("Found " + friends.size() + " friends.");
        else
            logger.debug("Found 0 friends.");
        return friends;
    }

    public void addFriend(Friend friend) {
        logger.debug("Add Friend with name: " + friend.getName() + " for user: " + friend.getUser().toString());
        friendRepository.save(friend);
    }

    public List<Friend> getAllFriends() {
        logger.debug("Get all friends in the whoooollleee database: ");
        Iterable<Friend> friendIter = friendRepository.findAll();
        List<Friend> friendList = new ArrayList<>();
        friendIter.forEach(friendList::add);
        logger.debug("Found this many friends: " + (friendList != null ? friendList.size() : 0));
        return friendList;
    }

}
