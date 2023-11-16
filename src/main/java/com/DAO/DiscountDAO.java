package com.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Discount;

@Repository
public interface DiscountDAO extends CrudRepository<Discount, Integer> {
	public List<Discount> findByActiveTrueAndPolicyId(Integer policyId);
	public List<Discount> findByPolicyId(Integer policyId);
	public List<Discount> findByActiveTrue();

}
