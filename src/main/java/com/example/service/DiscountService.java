package com.example.service;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;

import com.example.entity.Discount;


public interface DiscountService {
	public String addDiscount(Discount discount);
	public ArrayList<Discount> getDiscountByPolicyId(Integer policyId);
	public ResponseEntity<String> deletePolicyById(Integer discountId);
	
}
