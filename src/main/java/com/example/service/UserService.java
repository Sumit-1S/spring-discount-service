package com.example.service;

import java.util.ArrayList;

import com.example.entity.Discount;


public interface UserService {
	public String addDiscount(Discount discount);
	public ArrayList<Discount> getDiscountByPolicyId(Integer policyId);
	
}
