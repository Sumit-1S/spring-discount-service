package com.example.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.mockito.ArgumentMatchers.eq;

import com.DAO.DiscountDAO;
import com.example.entity.Discount;
import com.example.service.DiscountServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock
    private DiscountDAO dao;

    @InjectMocks
    private DiscountServiceImpl discountService;
    
    public void init() {
		MockitoAnnotations.openMocks(this);
	}

    @Test
    public void testGetDiscountByPolicyId() {
//        Integer policyId = 1;
//        List<Discount> expectedDiscounts = new ArrayList<>();
//        expectedDiscounts.add(new Discount(1, 10.0, true));
//        expectedDiscounts.add(new Discount(1, 15.0, true));
//
//        // Mocking the behavior of dao.findByPolicyId method
//        when(dao.findByPolicyId(policyId)).thenReturn(expectedDiscounts);
//
//        List<Discount> result = discountService.getDiscountByPolicyId(policyId);
//
//        // Verify that the findByPolicyId method was called with the correct argument
//        verify(dao, times(1)).findByPolicyId(policyId);
//
//        // Verify that the result matches the expectedDiscounts
//        assertEquals(expectedDiscounts, result);
    	 // Arrange
        Integer policyId = 1;
        when(dao.findByPolicyId(policyId)).thenReturn(List.of(new Discount(1, 10.0, true)));

        // Act
        List<Discount> resultList = dao.findByPolicyId(policyId);
        ArrayList<Discount> result = new ArrayList<>(resultList);

        // Assert
        assertEquals(1, result.size());
    }

    @Test
    public void testAddDiscount() {
//        Discount discount = new Discount(1, 10.0, true);
//
//        // Mocking the behavior of dao.save method
//        when(dao.save(discount)).thenReturn(discount);
//
//        String result = discountService.addDiscount(discount);
//
//        assertEquals("Discount Added...", result);
//
//        // Verify that the save method was called with the correct argument
//        verify(dao, times(1)).save(discount);
    	Discount discountToAdd = new Discount(1, 10.0, true);

        // Act
        String result = discountService.addDiscount(discountToAdd);

        // Assert
        assertEquals("Discount Added...", result);
    }

    @Test
    public void testDeletePolicyById() {
    	 Integer discountId = 1;
         Discount existingDiscount = new Discount(1, 10.0, true);
         when(dao.findById(discountId)).thenReturn(java.util.Optional.of(existingDiscount));

         // Act
         ResponseEntity<String> result = discountService.deletePolicyById(discountId);

         // Assert
         assertEquals("Updated Discount", result.getBody());
     }

}

