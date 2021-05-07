package com.example.springstart.service;

import com.example.springstart.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired//del
    private UserRepositories userRepositories;

    //public UserService(UserRepositories userRepositories) {
    //    this.userRepositories = userRepositories;
    //}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepositories.findByUsername(username);
    }
}
