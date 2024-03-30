package com.ArtyomSavchenko.authenticationservice.ldap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.Name;

@Service
class LdapAuthenticationProviderImpl implements LdapAuthenticationProvider {
    @Autowired
    private LdapTemplate ldapTemplate;

    @Autowired
    private LdapContextSource contextSource;

    @Autowired
    private LdapProperties ldapProperties;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void authenticate(String username, String password) {
        contextSource
                .getContext(
                        "uid=" +
                                username +
                                ",ou=people," +
                                ldapProperties.getBase(), password);
    }

    @Override
    public void registerUser(String username, String password) {
        DirContextOperations context = buildUserContext(username, password);

        ldapTemplate.bind(context);
    }

    @Override
    public void updateUser(String username, String password) {
        DirContextOperations context = buildUserContext(username, password);
        ldapTemplate.modifyAttributes(context);
    }

    private DirContextOperations buildUserContext(String username, String password) {
        Name dn = LdapNameBuilder
                .newInstance()
                .add("ou", "users")
                .add("cn", username)
                .build();

        DirContextOperations context = ldapTemplate.lookupContext(dn);

        context.setAttributeValues
                ("objectclass",
                        new String[]
                                { "top",
                                        "person",
                                        "organizationalPerson",
                                        "inetOrgPerson" });
        context.setAttributeValue("cn", username);
        context.setAttributeValue("sn", username);
        context.setAttributeValue("userPassword",
                passwordEncoder.encode(password));

        return context;
    }
}
