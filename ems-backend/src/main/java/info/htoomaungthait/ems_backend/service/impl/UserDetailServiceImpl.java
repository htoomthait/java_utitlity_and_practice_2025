package info.htoomaungthait.ems_backend.service.impl;

import info.htoomaungthait.ems_backend.dto.UserDto;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import info.htoomaungthait.ems_backend.exception.ResourceNotFoundException;
//import info.htoomaungthait.ems_backend.service.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;

    public UserDetailServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public User loadUserByUsername(String username) throws ResourceNotFoundException {

        System.out.println("Loaded user: " + username);

        final String  passwordToCheck = "password";

        if(username.equals("admin")){

            return new User(
                    "admin",
                    this.passwordEncoder.encode(passwordToCheck), // {noop} means no password encoding
                    Collections.singletonList(new SimpleGrantedAuthority("ADMIN_ROLE"))
            );


        }
        else{
            throw new ResourceNotFoundException("User not found");
        }
    }
}
