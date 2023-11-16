package com.example.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Builder
public class Discount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Builder.Default
	private Integer discountId=50;
	private Integer policyId;
	private Double discountAmount;
	private Boolean active;
	
	public Discount(Integer policyId2, Double discountAmount2, Boolean active2) {
		policyId = policyId2;
		discountAmount = discountAmount2;
		active = active2;
	}
//	@PrePersist
//	private void generateRandomValue() {
//        // Generate a random value, for example, a UUID
//        this.discountId = Integer.parseInt(UUID.randomUUID());
//    }
}
