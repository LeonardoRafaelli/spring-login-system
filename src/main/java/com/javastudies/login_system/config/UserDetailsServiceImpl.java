package com.javastudies.login_system.config;

import com.javastudies.login_system.model.UserDtls;
import com.javastudies.login_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDtls user = userRepo.findByEmail(username);

        if(user != null) {
             return new CustomUserDetails(user);
        }
        throw new UsernameNotFoundException("User not found!");
    }


}
