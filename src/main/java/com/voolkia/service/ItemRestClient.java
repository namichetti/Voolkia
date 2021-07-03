package com.voolkia.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.voolkia.constant.ItemConstants;
import com.voolkia.model.Item;

@Service
public class ItemRestClient {
	
	
	private WebClient webClient = WebClient.create(ItemConstants.END_POINT);
	
	public List<Item> getBySiteIdAndSellerId(){
		return this.webClient.get().uri(ItemConstants.GET_BY_SELLER_ID_AND_SITE_ID)
							.retrieve()
							.bodyToFlux(Item.class)
							.collectList()
							.block();
	}
	
	public List<Item> getBySiteIdAndSellerId(String siteId,String sellerId) {
		return this.webClient.get().uri(ItemConstants.GET_BY_SEARCH,siteId,sellerId)
				.retrieve()
				.bodyToFlux(Item.class)
				.collectList()
				.block();
		
	}
	

}
