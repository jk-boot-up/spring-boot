package com.jk7.boot.explore.config.properties.v1;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/rest/v1")
@Getter
public class PropertiesControllerV1 {

    private final PersonPropertiesV1 personPropertiesV1;

    @Autowired
    public PropertiesControllerV1(PersonPropertiesV1 personPropertiesV1) {
        this.personPropertiesV1 = personPropertiesV1;
    }

    @RequestMapping("/person/properties")
    public String properties() {
        return personPropertiesV1.toString();
    }

}
