package com.ArtyomSavchenko.authenticationservice.ldap;

public interface LdapAuthenticationProvider {
    /**
     * Authenticate user in LDAP
     * @param username
     *      User name
     * @param password
     *      password
     */
    void authenticate(String username, String password);

    /**
     * Register new user in LDAP
     * @param username
     *      User name
     * @param password
     *      password
     */
    void registerUser(String username, String password);

    /**
     * Update existing user
     * @param username
     *      User name
     * @param password
     *      password
     */
    void updateUser(String username, String password);
}
