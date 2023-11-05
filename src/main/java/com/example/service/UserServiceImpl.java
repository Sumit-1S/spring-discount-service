package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DAO.DiscountDAO;
import com.example.entity.Discount;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private DiscountDAO dao;

	
	@Override
	public ArrayList<Discount> getDiscountByPolicyId(Integer policyId) {
		return (ArrayList)dao.findByPolicyId(policyId);
	}


	@Override
	public String addDiscount(Discount discount) {
		dao.save(discount);
		return "Discount Added...";
	}
	
	
}
