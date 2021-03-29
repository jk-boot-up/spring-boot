package com.jk7.boot.explore.config.properties.v2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ComponentScan(basePackageClasses = PersonPropertiesV2.class)
@PropertySource("classpath:person-test.properties")
class PersonPropertiesV2TestContext {
    //
}

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = PersonPropertiesV2TestContext.class)
public class PersonPropertiesV2Test {

    @Autowired
    private PersonPropertiesV2 personPropertiesV2;

    @Test
    public void properties() {
        assertNotNull(personPropertiesV2);
        assertEquals("J_test2", personPropertiesV2.getFirstName());
        assertEquals("K_test2", personPropertiesV2.getLastName());
        assertNotNull(personPropertiesV2.getAccountCredentials());
        assertEquals("J1234_test2", personPropertiesV2.getAccountCredentials().getLoginId());
        assertEquals("secret_test2", personPropertiesV2.getAccountCredentials().getSecretToken());
    }

}
