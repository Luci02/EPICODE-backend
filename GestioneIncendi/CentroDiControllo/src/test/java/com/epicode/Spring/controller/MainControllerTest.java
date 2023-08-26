package com.epicode.Spring.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(MainController.class)
public class MainControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@Test
    public void testGetCall_smokeLevelAboveThreshold() throws Exception {
        mockMvc.perform(get("/alarm")
                .param("idsonda", "123")
                .param("lat", "12.345")
                .param("lon", "67.890")
                .param("smokelevel", "6"))
                .andExpect(status().isOk());
    }
	
	@Test
    public void testGetCall_smokeLevelBelowThreshold() throws Exception {
        mockMvc.perform(get("/alarm")
                .param("idsonda", "123")
                .param("lat", "12.345")
                .param("lon", "67.890")
                .param("smokelevel", "5"))
                .andExpect(status().isOk());
    }

}
