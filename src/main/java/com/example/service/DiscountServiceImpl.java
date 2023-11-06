package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.DAO.DiscountDAO;
import com.example.entity.Discount;

@Service
public class DiscountServiceImpl implements DiscountService {

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


	@Override
	public ResponseEntity<String> deletePolicyById(Integer discountId) {
		Optional<Discount> d = dao.findById(discountId);
		d.get().setActive(false);
		return new ResponseEntity<>("Updated Discount",HttpStatus.OK);
	}
	
	
}
