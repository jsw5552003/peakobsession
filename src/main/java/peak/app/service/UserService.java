package peak.app.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import peak.app.model.Role;
import peak.app.model.User;
import peak.app.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException
    {
        User user = userRepository.findByUserName(userName);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }
    
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
    
    public void createNewUser(User user) throws AuthenticationException
    {
        logger.debug("Create New User check to see if email and user name exist.");
        if(userRepository.findByEmail(user.getEmail()) != null)
            throw new UsernameNotFoundException("That email is already in use.");
        logger.debug("Email is unique.");
        if(userRepository.findByUserName(user.getUserName()) != null)
            throw new UsernameNotFoundException("That username is already in use.");
        logger.debug("User name is unique. Go ahead and create user.");
        userRepository.save(user);
        logger.debug("New user created.");
    }

    public List<User> getAllUsers()
    {
        logger.debug("Get all users");
        return userRepository.findAll();
    }

    public List<User> getAllUsersExcept(String userName) {
        logger.debug("Get all users except for user: " + userName);
        return userRepository.findByUserNameNot(userName);
    }

    public List<User> getAllUsersExcept(List<String> userNames, String userName) {
        if (userNames == null)
            userNames = Collections.emptyList();
        userNames.add(userName);
        logger.debug("Get all users except for users: " + userNames.toString());
        return userRepository.findByUserNameNotIn(userNames);
    }

    public User getUserById(Long id) {
        logger.debug("Get user by ID: " + id);
        return userRepository.findOne(id);
    }

    public User getUserByUserName(String userName) {
        logger.debug("Get user by user name: " + userName);
        return userRepository.findByUserName(userName);
    }

}
