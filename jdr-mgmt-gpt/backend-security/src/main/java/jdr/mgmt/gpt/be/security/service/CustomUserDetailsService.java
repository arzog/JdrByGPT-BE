package jdr.mgmt.gpt.be.security.service;

import jdr.mgmt.gpt.be.domain.model.CustomUser;
import jdr.mgmt.gpt.be.domain.security.port.UserPort;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserPort userPort;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        CustomUser customUser = userPort.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return User
                .withUsername(customUser.getUsername())
                .password(customUser.getPassword())
                .roles(customUser.getRole())
                .build();
    }
}
