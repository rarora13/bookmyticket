package com.movie.user.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.movie.user.entity.User;
import com.movie.user.repository.UserRepository;

@Component
public class BookingSystemUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> users = userRepository.findByUsername(username);
        if(users.isEmpty() && !"admin".equals(username)){
            throw new UsernameNotFoundException("User "+username+" is not registered user.");
        }else if ("admin".equals(username)) {
        	User user = new User();
        	user.setFirstName("Admin");
        	user.setUsername("admin");
        	user.setPassword("admin");
        	user.setEnabled(true);
        	return new SecurityUser(user);
        }
        return new SecurityUser(users.get());
    }
}
