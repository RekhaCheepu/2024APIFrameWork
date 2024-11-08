package com.qa.api.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	private Integer id;
	private String title;
	private double price;
	private String description;
	private String image;
	private Rating rating;
	private String category;
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor	
public  static class Rating{
	private double rate;
	private int count;
	
		
	}
	
}