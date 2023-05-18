package com.example.services;

import com.example.annotations.Inject;
import com.example.annotations.Named;
import com.example.repositories.UserRepository;

@Named("emailService")
public class EmailService {
    @Inject
    private UserRepository userRepository;

    public void sendEmail() {
        userRepository.saveUser();
        System.out.println("Sending email...");
    }
}
