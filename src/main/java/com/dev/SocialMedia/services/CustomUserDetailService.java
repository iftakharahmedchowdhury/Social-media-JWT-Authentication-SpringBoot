package com.dev.SocialMedia.services;

import com.dev.SocialMedia.Repository.UserRepo;
import com.dev.SocialMedia.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private UserRepo userRepo;

    public CustomUserDetailService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // here loading user form DB
        User user =userRepo.findByEmail(username).orElseThrow(()-> new RuntimeException("User not found"));
        return user;
    }
}
