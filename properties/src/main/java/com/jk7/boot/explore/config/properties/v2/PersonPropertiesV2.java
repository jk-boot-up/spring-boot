package com.jk7.boot.explore.config.properties.v2;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Slf4j
@Component
public class PersonPropertiesV2 {

    @Value("${person2.firstName}")
    private String firstName;

    @Value("${person2.lastName}")
    private String lastName;

    private final PersonPropertiesV2.AccountCredentials accountCredentials;

    @Autowired
    public PersonPropertiesV2(PersonPropertiesV2.AccountCredentials accountCredentials) {
        this.accountCredentials = accountCredentials;
        log.info("Created an instance of {}", PersonPropertiesV2.class.getSimpleName());
    }

    @Override
    public String toString() {
        return "PersonPropertiesV2{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accountCredentials=" + accountCredentials +
                '}';
    }

    @Slf4j
    @Getter
    @Setter
    @Component
    public static class AccountCredentials {

        @Value("${person2.accountCredentials.loginId}")
        private String loginId;

        @Value("${person2.accountCredentials.secretToken}")
        private String secretToken;

        public AccountCredentials() {
            log.info("Created an instance of {}", PersonPropertiesV2.AccountCredentials.class.getSimpleName());
        }

        @Override
        public String toString() {
            return "AccountCredentials{" +
                    "loginId='" + loginId + '\'' +
                    ", secretToken='" + secretToken + '\'' +
                    '}';
        }
    }
}
