package com.jk7.boot.explore.config.properties.v1;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Configuration
@ConfigurationProperties(prefix = "person")
@Getter
@Setter
@Slf4j
public class PersonPropertiesV1 {

    @NotNull
    @Size(min=1, max=40)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 40)
    private String lastName;

    @NotNull
    private AccountCredentials accountCredentials;

    public PersonPropertiesV1() {
        log.info("Created an instance of {}", PersonPropertiesV1.class.getSimpleName());
    }

    @Override
    public String toString() {
        return "PersonPropertiesV1{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accountCredentials=" + accountCredentials +
                '}';
    }

    @Slf4j
    @Getter
    @Setter
    public static class AccountCredentials {
        @NotNull
        @Size(min = 1, max = 40)
        private String loginId;

        @NotNull
        @Size(min = 4, max = 40)
        private String secretToken;

        public AccountCredentials() {
            log.info("Created an instance of {}", AccountCredentials.class.getSimpleName());
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



