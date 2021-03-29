package com.jk7.boot.explore.config.properties.v1;

import com.jk7.boot.explore.config.properties.v1.PersonPropertiesV1;
import com.jk7.boot.explore.config.properties.v1.PropertiesControllerV1;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PropertiesControllerV1.class)
@EnableConfigurationProperties(PersonPropertiesV1.class)
@TestPropertySource("classpath:person-test.properties")
public class PropertiesControllerV1Test_1 {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void valid200() throws Exception {
        mockMvc.perform(get("/rest/v1//person/properties").accept(MediaType.TEXT_PLAIN))
                .andDo(print()).andExpect(status().isOk());
    }


}
