package com.voolkia.controller;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.voolkia.model.Item;
import com.voolkia.model.Result;
import com.voolkia.service.ItemRestClient;

@RestController
public class ItemController {
		
	@Autowired
	private ItemRestClient itemRestClient;

	@GetMapping("/list")
	public List<Item> getAll(){	
		List<Item> items = itemRestClient.getBySiteIdAndSellerId();
	      Path path = Paths.get("items.txt");
	      try (BufferedWriter br = Files.newBufferedWriter(path,
	            Charset.defaultCharset(), StandardOpenOption.CREATE)) {

	    	  for (Item item : items) {
	    		  try {
	    			for (Result result : item.getResults()) {
		               br.write("Item id " + result.getId() + ",title "  + result.getTitle() + ",category id " + result.getCategoryId() + ",category name " + result.getDomainId() +"\n");
		               br.newLine();
	    				}
		            } catch (IOException e) {
		               throw new UncheckedIOException(e);
		            }
				}
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      
		return items;
	

	}
	
	@GetMapping("/list/{siteId}/{sellerId}")
	public List<Item> getAll(@PathVariable String siteId, @PathVariable String sellerId){
		List<Item> items = itemRestClient.getBySiteIdAndSellerId(siteId,sellerId);
	      Path path = Paths.get("itemsById.txt");
	      try (BufferedWriter br = Files.newBufferedWriter(path,
	            Charset.defaultCharset(), StandardOpenOption.CREATE)) {

	    	  for (Item item : items) {
	    		  try {
	    			for (Result result : item.getResults()) {
		               br.write("Item id " + result.getId() + ",title "  + result.getTitle() + ",category id " + result.getCategoryId() + ",category name " + result.getDomainId() +"\n");
		               br.newLine();
	    				}
		            } catch (IOException e) {
		               throw new UncheckedIOException(e);
		            }
				}
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      
		return items;
	}
}
