package com.enviro.assessment.grad001.mphorakgope.demo;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(WasteController.class)
public class WasteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WasteRepository repository;

    @Test
    public void testGetAllWaste() throws Exception {
        Waste waste1 = new Waste("Plastic", "plastic recycle bin");
        Waste waste2 = new Waste("Paper", "paper bin for recycling");

        given(repository.findAll()).willReturn(Arrays.asList(waste1, waste2));

        mockMvc.perform(get("/waste"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Plastic"))
                .andExpect(jsonPath("$[1].name").value("Paper"));
    }

    @Test
    public void testCreateWaste() throws Exception {
        Waste newWaste = new Waste("Glass", "glass recycle bin");

        given(repository.save(newWaste)).willReturn(newWaste);

        mockMvc.perform(post("/waste")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(newWaste)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Glass"));
    }
}
