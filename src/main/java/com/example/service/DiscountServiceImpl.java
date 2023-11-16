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
import com.model.DiscountRegisterRequest;

@Service
public class DiscountServiceImpl implements DiscountService {

	@Autowired
	private DiscountDAO dao;

	
	@Override
	public ArrayList<Discount> getDiscountByPolicyId(Integer policyId) {
		return (ArrayList)dao.findByPolicyId(policyId);
	}


	@Override
	public String addDiscount(DiscountRegisterRequest discount) {
		Discount dis = Discount.builder()
				.policyId(discount.getPolicyId())
				.discountAmount(discount.getDiscountAmount())
				.active(discount.getActive())
				.build();
		dao.save(dis);
		return "Discount Added...";
	}


	@Override
	public ResponseEntity<String> deletePolicyById(Integer discountId) {
		Optional<Discount> d = dao.findById(discountId);
		d.get().setActive(false);
		return new ResponseEntity<>("Updated Discount",HttpStatus.OK);
	}


	@Override
	public ArrayList<Discount> getDiscountByPolicyIdList(List<Integer> policyId) {
		ArrayList<Discount> arr = new ArrayList();
		for(Integer i:policyId) {
			ArrayList<Discount> temp = (ArrayList)dao.findByActiveTrueAndPolicyId(i);
			if(temp.size()>0)
				arr.add(temp.get(0));
			else {
				arr.add(new Discount(0,i,0.0,true));
			}
		}
		return arr;
	}


	@Override
	public ArrayList<Discount> getAllDiscount() {
		return (ArrayList)dao.findByActiveTrue();
	}
	
	
}
