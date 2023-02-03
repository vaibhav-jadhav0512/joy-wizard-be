package com.joy.wizard.be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = { UserDetailsServiceAutoConfiguration.class })
public class JoyWizardBackendApplication {

    public static void main(String[] args) {
		SpringApplication.run(JoyWizardBackendApplication.class, args);
    }
}