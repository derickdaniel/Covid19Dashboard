package com.covid19.demo.service.impl;
import com.covid19.demo.entity.User;
import com.covid19.demo.repository.IUserRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  private IUserRepository userRepository;
  
  @Override
  @Transactional(readOnly = true)
  public UserDetails loadUserByUsername(String email) {
    Optional<User> userEntity = userRepository.findByEmail(email);
    if (userEntity.isEmpty()) {
      throw new UsernameNotFoundException(email);
    }
    User user = userEntity.get();
    
    Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
    grantedAuthorities.add(new SimpleGrantedAuthority("user"));
    
    return new org.springframework.security.core.userdetails.User(user.getEmail(),
        user.getPassword(), grantedAuthorities);
  }
}