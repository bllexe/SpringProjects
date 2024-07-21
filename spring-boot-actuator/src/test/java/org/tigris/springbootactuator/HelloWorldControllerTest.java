package org.tigris.springbootactuator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class HelloWorldControllerTest {

    @Test
    public void testGetMessage() throws  Exception {

        String expectedContent ="Hello, Stranger!";
        MockMvc mockMvc = MockMvcBuilders
                .standaloneSetup(new HelloWorldController())
                .build();

        mockMvc.perform(MockMvcRequestBuilders.get("/hello-world"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value(expectedContent))
                .andDo(MockMvcResultHandlers.print());


    }

}