package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.entity.Discount;
import com.model.DiscountRegisterRequest;


public interface DiscountService {
	public String addDiscount(DiscountRegisterRequest discount);
	public ArrayList<Discount> getDiscountByPolicyId(Integer policyId);
	public ResponseEntity<String> deletePolicyById(Integer discountId);
	public ArrayList<Discount> getDiscountByPolicyIdList(List<Integer> policyId);
	public ArrayList<Discount> getAllDiscount();
	
}
