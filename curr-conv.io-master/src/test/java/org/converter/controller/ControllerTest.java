package org.converter.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.converter.model.UserData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ConverterController.class)
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    private ConverterController controller;

    @Test
    public void ConverterTestShouldReturnConversion() throws Exception {
        UserData userData = new UserData(new BigDecimal(45), "dollar", "ethereum");
        given(controller.getOutput(userData)).willReturn(String.valueOf(userData.getResult()));

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/converter")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .characterEncoding("utf-8")
                .content(objectMapper.writeValueAsString(userData)))
                .andExpect(status().is4xxClientError());
    }
}
