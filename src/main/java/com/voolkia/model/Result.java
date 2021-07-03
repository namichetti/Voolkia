package com.voolkia.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Result {

	private String id;
	private String title;
	@JsonProperty("category_id")
	private String categoryId;
	@JsonProperty("domain_id")
	private String domainId;
	
}
