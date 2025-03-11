package com.springboot.security.SpringSecurityBasics.service;

import com.springboot.security.SpringSecurityBasics.model.UserPrincipal;
import com.springboot.security.SpringSecurityBasics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.springboot.security.SpringSecurityBasics.model.User;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepo;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
    /**
     * When we pass username in LoginPage, the username will gets passed to this method,
     * and we need to return UserDetails Obj
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepo.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("User Not Found for username : "+username);
        }
        return new UserPrincipal(user);
    }

    public void saveUser(User user) {
        user.setPassword( encoder.encode(user.getPassword()) );
        userRepo.save(user);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
