package com.cnqisoft.demo.config;

import com.cnqisoft.demo.repository.AuthorityRepository;
import com.cnqisoft.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetails implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String password = userRepository.findUserByUsername(username).getPassword();
        String authority = authorityRepository.findAuthorityByUsername(username).getAuthority();
        return new org.springframework.security.core.userdetails.User(username, password,
                AuthorityUtils.commaSeparatedStringToAuthorityList(authority));
    }

}
