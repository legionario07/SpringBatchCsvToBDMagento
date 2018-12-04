package br.com.batch.utils;

import java.util.HashMap;
import java.util.Map;

import br.com.batch.model.EavAttribute;

public class SessionUtil {

	private static SessionUtil instance = null;
	
	private Map<String, EavAttribute> mapEavAttributes;
	
	private SessionUtil() {
		mapEavAttributes = new HashMap<>();
	}

	public static SessionUtil getInstance() {
		if(instance == null) {
			instance = new SessionUtil();
		}
		
		return instance;
	}

	
	public Map<String, EavAttribute> getMapEavAttributes() {
		return mapEavAttributes;
	}

	public void setMapEavAttributes(Map<String, EavAttribute> mapEavAttributes) {
		this.mapEavAttributes = mapEavAttributes;
	}
	
	
}
