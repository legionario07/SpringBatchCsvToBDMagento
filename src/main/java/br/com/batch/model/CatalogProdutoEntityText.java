package br.com.batch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="catalog_product_entity_text")
public class CatalogProdutoEntityText {
	
	@Column(name="value_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer valueId;
	
	@Column(name="attribute_id")
	private Integer attributeId;
	
	@Column(name="store_id")
	private Integer storeId;
	
	@Column(name="entity_id")
	private Integer entityId;
	

	@Column(name="value")
	private String value;
	
	
	
	public CatalogProdutoEntityText(Integer entityId, String value, Integer attributeId) {
		this(attributeId);
		this.entityId =entityId;
		this.value =value;
	}
	
	public CatalogProdutoEntityText() {
		this.storeId = 0;
	}
	
	public CatalogProdutoEntityText(Integer attributeId) {
		this();
		this.attributeId =attributeId;
	}
	
	
	public Integer getEntityId() {
		return entityId;
	}
	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public Integer getValueId() {
		return valueId;
	}

	public void setValueId(Integer valueId) {
		this.valueId = valueId;
	}

	public Integer getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(Integer attributeId) {
		this.attributeId = attributeId;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "CatalogProdutoEntityText [valueId=" + valueId + ", attributeId=" + attributeId + ", storeId="
				+ storeId + ", entityId=" + entityId + ", value=" + value + "]";
	}

}
