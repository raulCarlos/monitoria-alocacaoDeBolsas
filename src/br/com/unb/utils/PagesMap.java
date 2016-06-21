package br.com.unb.utils;

import java.util.HashMap;
import java.util.Map;

import br.com.unb.constant.Page;

public class PagesMap {

	private static Map<Page, String> pageMap;
	private static PagesMap instance;
	
	public Map<Page, String> getMessage(){
		pageMap = new HashMap<Page,String>();
		
		pageMap.put(Page.INDEX_PAGE, "/pages/admin/index.xhtml");
		pageMap.put(Page.LOGOUT_PAGE, "/pages/login.xhtml");
		pageMap.put(Page.OFFER_PAGE, "/pages/admin/offer_list_page.xhtml");
		
		return pageMap;
	}
	
	public static PagesMap getInstance(){
		if(instance == null){
			instance = new PagesMap();
		}
		return instance;
	}
}
