package com.worldofshopping.Ecommerce.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Brand implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long brand_id;
	@Column(unique=true,nullable=false)
	private String brand_name;
	@NotBlank(message="Description can't be blank")
	@Size(max=255,message="description upto 255 words only")
	private String brand_description;
	public Long getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(Long brand_id) {
		this.brand_id = brand_id;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public String getBrand_description() {
		return brand_description;
	}
	public void setBrand_description(String brand_description) {
		this.brand_description = brand_description;
	}
	@Override
	public String toString() {
		return "Brand [brand_id=" + brand_id + ", brand_name=" + brand_name + ", brand_description=" + brand_description
				+ "]";
	}
	
}
