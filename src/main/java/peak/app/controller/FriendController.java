package peak.app.controller;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import peak.app.common.AuthenticationFacade;
import peak.app.model.Friend;
import peak.app.model.User;
import peak.app.service.FriendService;
import peak.app.service.UserService;
import peak.app.view.StatusMessage;

@Controller
public class FriendController {

    private final Logger logger = LoggerFactory.getLogger(FriendController.class);

    @Autowired
    private AuthenticationFacade authenticationFacade;

    @Autowired
    UserService userService;

    @Autowired
    FriendService friendService;

    @RequestMapping("/friends")
    public String friends(Model model)
    {
        String userName = authenticationFacade.getAuthentication().getName();
        logger.info("Handling a request to go to the friends page for " + userName);
        List<Friend> friendList = friendService.getAllFriends(userName);
        logger.info("Retrieved friends: " + (friendList == null ? 0 : friendList.size()));
        // get only users that are not already friends and are not current user
        List<User> userList = userService.getAllUsersExcept(getUserNamesFromFriends(friendList), userName);
        logger.info("Retrieved users: " + (userList == null ? 0 : userList.size()));
        model.addAttribute("users", userList);
        model.addAttribute("friends", friendList);
        return "friends";
    }

    @RequestMapping("/friends/addfriend")
    public String addFriend(@RequestParam(value = "name") String name, @RequestParam(value = "user") String userString,
            Model model) {
        String userName = authenticationFacade.getAuthentication().getName();
        logger.info("Add friend for user " + userName + " with name: " + name + " and user: " + userString);
        User user = userService.getUserByUserName(userName);
        Friend friend = new Friend(name, user);
        if (StringUtils.isNotEmpty(userString) && StringUtils.isNumeric(userString)) {
            long userId = Long.parseLong(userString);
            User friendUser = userService.getUserById(userId);
            friend.setFriendUser(friendUser);
        }
        friendService.addFriend(friend);
        StatusMessage status = new StatusMessage("Friend with name: " + name + " successfully added.", true);
        model.addAttribute("status", status);
        logger.info("GET FRIENDS BY USER " + userName);
        List<Friend> friendList = friendService.getAllFriends(userName);
        friendList.forEach(fr -> logger.debug(fr.toString()));
        logger.info("Retrieved friends: " + (friendList == null ? 0 : friendList.size()));
        // get only users that are not already friends and are not current user
        List<User> userList = userService.getAllUsersExcept(getUserNamesFromFriends(friendList), userName);
        logger.info("Retrieved users: " + (userList == null ? 0 : userList.size()));
        model.addAttribute("users", userList);
        model.addAttribute("friends", friendList);
        return "friends";
    }

    private List<String> getUserNamesFromFriends(List<Friend> friendsList) {
        return friendsList.stream().map(Friend::getFriendUser).filter(Objects::nonNull).map(User::getUserName)
                .collect(Collectors.toList());
    }
}
