package com.SecurityLearning.Controllers;

import com.SecurityLearning.Models.ApplicationUser;
import com.SecurityLearning.Models.LoginResponseDTO;
import com.SecurityLearning.Models.RegistrationDTO;
import com.SecurityLearning.Services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO registrationDTO) {
        return authenticationService.registerUser(registrationDTO.getUsername(), registrationDTO.getPassword());
    }

    @PostMapping("/login")
    public LoginResponseDTO loginResponseDTO(@RequestBody RegistrationDTO registrationDTO) {
        return authenticationService.loginUser(registrationDTO.getUsername(), registrationDTO.getPassword());
    }
}
