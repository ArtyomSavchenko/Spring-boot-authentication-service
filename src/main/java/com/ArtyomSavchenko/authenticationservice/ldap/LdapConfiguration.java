package com.ArtyomSavchenko.authenticationservice.ldap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

@Configuration
public class LdapConfiguration {
    @Autowired
    private LdapProperties properties;

    @Bean
    public LdapContextSource contextSource() {
        LdapContextSource contextSource = new LdapContextSource();

        contextSource.setUrl(properties.getUrl());
        contextSource.setBase(properties.getBase());
        contextSource.setUserDn(properties.getPrincipal());
        contextSource.setPassword(properties.getPassword());

        return contextSource;
    }

    @Bean
    public LdapTemplate ldapTemplate() {
        return new LdapTemplate(contextSource());
    }
}
