package com.example;

import com.example.di.DependencyInjector;
import com.example.services.EmailService;
import com.example.services.SMSService;

public class Main {
    public static void main(String[] args) {
        DependencyInjector injector = new DependencyInjector();

        EmailService emailService = new EmailService();
        injector.injectDependencies(emailService);

        SMSService smsService = new SMSService();
        injector.injectDependencies(smsService);

        emailService.sendEmail();
        smsService.sendSMS();
    }
}
