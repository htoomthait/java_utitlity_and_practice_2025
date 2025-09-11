package net.htoomaungthait.junit.practice.service.impl;

import net.htoomaungthait.junit.practice.entity.Guest;
import net.htoomaungthait.junit.practice.repository.GuestRepository;
import net.htoomaungthait.junit.practice.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    GuestRepository guestRepository;

    @Override
    public String getWelcomeMessage(String name, String email) {

        try{
            Guest newGuest = Guest.of(name, email);

            guestRepository.save(newGuest);

            return "Hello " + name + ", Welcome to Home Page! Will record with your email: " + email;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }


    }
}
