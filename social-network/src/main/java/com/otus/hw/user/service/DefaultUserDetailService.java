package com.otus.hw.user.service;

import com.otus.hw.user.repository.UserRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class DefaultUserDetailService implements UserDetailsService {

    UserRepository userRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String uuid) throws UsernameNotFoundException {
        var user = userRepository.findById(UUID.fromString(uuid));
        if (user == null) {
            throw new UsernameNotFoundException("No user found with username: " + uuid);
        }
        return new org.springframework.security.core.userdetails.User(
                uuid,
                user.getPassword().toLowerCase(),
                true,
                true,
                true,
                true, getAuthorities(List.of("USER")));
    }

    private static List<GrantedAuthority> getAuthorities (List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}
