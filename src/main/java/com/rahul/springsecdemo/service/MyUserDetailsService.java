package com.rahul.springsecdemo.service;

import com.rahul.springsecdemo.model.User;
import com.rahul.springsecdemo.model.UserPrincipal;
import com.rahul.springsecdemo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user  = userRepo.findUserByUsername(username);
        if(user == null){
            System.out.print("user not found");
            throw  new UsernameNotFoundException("user not");
        }
        return new UserPrincipal(user);
    }
}
