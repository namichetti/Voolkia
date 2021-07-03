package com.voolkia.constant;

public class ItemConstants {
	
	public  final static String SELLER_ID = "179571326";
	public  final static String SITE_ID = "MLA";
	public  final static String END_POINT ="https://api.mercadolibre.com/sites/";
	public  final static String GET_BY_SELLER_ID_AND_SITE_ID = END_POINT+SITE_ID+"/search?seller_id="+SELLER_ID;
	public  final static String GET_BY_SEARCH = END_POINT+"{siteId}/search?seller_id={sellerId}";

}
