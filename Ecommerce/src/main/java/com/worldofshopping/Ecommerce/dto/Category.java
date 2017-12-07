package com.worldofshopping.Ecommerce.dto;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;
@Entity
public class Category implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long category_id;
	@Column(unique=true,nullable=false)
	@NotBlank(message="Name not Blank")
	private String category_name;
	private boolean activeIs=true;
	public Long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public boolean isActiveIs() {
		return activeIs;
	}
	public void setActiveIs(boolean activeIs) {
		this.activeIs = activeIs;
	}
	@Override
	public String toString() {
		return "Category [category_id=" + category_id + ", category_name=" + category_name + ", activeIs=" + activeIs
				+ "]";
	}


	
}
