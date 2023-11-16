package com.example.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.controller.ResApplication;
import com.example.entity.Discount;
import com.example.service.DiscountService;
import com.model.DiscountRegisterRequest;

@ExtendWith(MockitoExtension.class)
public class ResApplicationTest {

    @InjectMocks
    private ResApplication resApplication;

    @Mock
    private DiscountService discountService;
    
    public void init() {
 		MockitoAnnotations.openMocks(this);
 	}


    private MockMvc mockMvc;

    @Test
    public void testAddDiscount() throws Exception {
        // Create a sample discount request
        DiscountRegisterRequest discountRequest = new DiscountRegisterRequest(1, 10.0, true);

        // Mock the service response
        when(discountService.addDiscount(any(Discount.class))).thenReturn("Discount Added...");

        // Initialize MockMvc using standalone setup
        mockMvc = MockMvcBuilders.standaloneSetup(resApplication).build();

        // Perform the HTTP request and verify the response
        mockMvc.perform(post("/discountService/adddiscount")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"policyId\":1,\"discountAmount\":10.0,\"active\":true}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Discount Added..."));
    }

    @Test
    public void testGetPolicyById() throws Exception {
        // Create a sample list of discounts
        ArrayList<Discount> discountList = new ArrayList<>();
        discountList.add(new Discount(1, 10.0, true));
        discountList.add(new Discount(1, 15.0, true));

        // Mock the service response
        when(discountService.getDiscountByPolicyId(1)).thenReturn(discountList);

        // Initialize MockMvc using standalone setup
        mockMvc = MockMvcBuilders.standaloneSetup(resApplication).build();

        // Perform the HTTP request and verify the response
        mockMvc.perform(get("/discountService/getDiscount/{policyId}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].discountAmount").value(10.0))
                .andExpect(jsonPath("$[1].discountAmount").value(15.0));
    }

    @Test
    public void testDeleteDiscount() throws Exception {
        // Mock the service response
        ResponseEntity<String> responseEntity = ResponseEntity.ok("Updated Discount");
        when(discountService.deletePolicyById(1)).thenReturn(responseEntity);

        // Initialize MockMvc using standalone setup
        mockMvc = MockMvcBuilders.standaloneSetup(resApplication).build();

        // Perform the HTTP request and verify the response
        mockMvc.perform(put("/discountService/deleteoffer/{discountId}", 1))
                .andExpect(status().isOk())
                .andExpect(content().string("Updated Discount"));
    }
}
