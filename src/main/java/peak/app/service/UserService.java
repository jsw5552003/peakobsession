package peak.app.service;

import java.util.Collection;
import java.util.stream.Collectors;

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
        if(userRepository.findByEmail(user.getEmail()) != null)
            throw new UsernameNotFoundException("That email is already in use.");
        
        if(userRepository.findByUserName(user.getUserName()) != null)
            throw new UsernameNotFoundException("That username is already in use.");
        
        userRepository.save(user);
    }

}
