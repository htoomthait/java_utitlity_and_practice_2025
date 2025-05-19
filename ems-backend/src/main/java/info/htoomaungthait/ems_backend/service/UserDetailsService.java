package info.htoomaungthait.ems_backend.service;

import info.htoomaungthait.ems_backend.dto.UserDto;
import org.springframework.security.core.userdetails.User;

public interface UserDetailsService {
    public User loadUserByUsername(String username);
}
