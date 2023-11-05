package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Discount {
	@Id
	@GeneratedValue
	private Integer discountId;
	private Integer policyId;
	private Double discountAmount;
	private Boolean active;
	public Discount(Integer policyId2, Double discountAmount2, Boolean active2) {
		policyId = policyId2;
		discountAmount = discountAmount2;
		active = active2;
	}
}
