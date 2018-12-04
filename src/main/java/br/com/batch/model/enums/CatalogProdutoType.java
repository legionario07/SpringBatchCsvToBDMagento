package br.com.batch.model.enums;

public enum CatalogProdutoType {

	SIMPLE("simple");
	
	private String value;
	
	private CatalogProdutoType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
