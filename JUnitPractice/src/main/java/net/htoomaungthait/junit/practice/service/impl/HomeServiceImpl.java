package net.htoomaungthait.junit.practice.service.impl;

import net.htoomaungthait.junit.practice.service.HomeService;
import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements HomeService {
    @Override
    public String getWelcomeMessage(String name) {
        return "Hello " + name + ", Welcome to Home Page";
    }
}
