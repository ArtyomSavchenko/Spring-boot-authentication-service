package com.ArtyomSavchenko.authenticationservice.ldap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class LdapAuthenticationProviderTest {
	@Autowired
	private LdapAuthenticationProvider ldapAuthenticationProvider;

	@Test
	void testSignUp() {
		ldapAuthenticationProvider.authenticate("bob", "bobspassword");
	}

}
