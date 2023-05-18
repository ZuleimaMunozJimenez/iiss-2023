package com.example.services;

import com.example.annotations.Inject;
import com.example.annotations.Named;
import com.example.repositories.UserRepository;

@Named("smsService")
public class SMSService {
    @Inject
    private UserRepository userRepository;

    public void sendSMS() {
        userRepository.saveUser();
        System.out.println("Sending SMS...");
    }
}
