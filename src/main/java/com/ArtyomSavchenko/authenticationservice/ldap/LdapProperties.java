package com.ArtyomSavchenko.authenticationservice.ldap;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.ldap")
@Setter
public class LdapProperties {
    private String url;
    private String base;
    private String principal;
    private String password;

    public String getUrl() {
        return url;
    }

    public String getBase() {
        return base;
    }

    public String getPrincipal() {
        return principal;
    }

    public String getPassword() {
        return password;
    }
}
