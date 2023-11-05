package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Discount;
import com.example.service.DiscountService;
import com.model.DiscountRegisterRequest;


@Controller
@RequestMapping("/loginService")
public class ResApplication {
	
	@Autowired
	private DiscountService service;
	
	
	@PostMapping("adddiscount")
	@ResponseBody
	public ResponseEntity<String> addDiscount(@RequestBody DiscountRegisterRequest discount) throws Exception{
		return new ResponseEntity<>(service.addDiscount(new Discount(discount.getPolicyId(),discount.getDiscountAmount(),discount.getActive())),HttpStatus.OK);	
	}
	
	@GetMapping("/getalldiscount/{policyId}")
	@ResponseBody
	public ArrayList<Discount> getPolicyById(@PathVariable Integer policyId) throws Exception{
		return service.getDiscountByPolicyId(policyId);
	}
	

}
