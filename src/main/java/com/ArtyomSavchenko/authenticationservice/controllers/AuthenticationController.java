package com.ArtyomSavchenko.authenticationservice.controllers;


import com.ArtyomSavchenko.authenticationservice.ldap.LdapAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthenticationController {
    @Autowired
    private LdapAuthenticationProvider ldapAuthenticationProvider;

    @PostMapping("auth/signup")
    public Map<String, Object> signup(String username, String password) {

    }
}
