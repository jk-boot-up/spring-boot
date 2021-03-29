package com.jk7.boot.explore.config.properties.v1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@EnableConfigurationProperties(PersonPropertiesV1.class)
@TestPropertySource("classpath:person-test.properties")
public class PersonPropertiesV1Test {

    @Autowired
    private PersonPropertiesV1 personPropertiesV1;

    @Test
    public void assertPersonProperties() {
        assertNotNull(personPropertiesV1);
        assertEquals("J_test", personPropertiesV1.getFirstName());
        assertEquals("K_test", personPropertiesV1.getLastName());
        assertNotNull(personPropertiesV1.getAccountCredentials());
        assertEquals("J1234_test", personPropertiesV1.getAccountCredentials().getLoginId());
        assertEquals("secret_test", personPropertiesV1.getAccountCredentials().getSecretToken());
    }
}
