package br.com.batch.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.batch.model.enums.CatalogProdutoType;

@Entity
@Table(name="catalog_product_entity")
public class CatalogProdutoEntity {
	
	@Column(name="entity_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer entityId;
	
	@Column(name="attribute_set_id")
	private Integer attributeSetId;
	
	@Column(name="type_id")
	private String typeId;
	
	@Column(name="sku")
	private String SKU;
	
	@Column(name="has_options")
	private Integer hasOptions;
	
	@Column(name="required_options")
	private Integer requiredOptions;
	
	@Column(name="created_at")
	private Date crateadAt;
	
	@Column(name="updated_at")
	private Date updatedAt;
	
	public CatalogProdutoEntity(Integer attributeSetId, String SKU) {
		this();
		this.attributeSetId = attributeSetId;
		this.SKU = SKU;
		this.typeId = CatalogProdutoType.SIMPLE.getValue();
		this.requiredOptions = 0;
		this.hasOptions = 0;
		this.crateadAt = new Date();
		this.updatedAt = new Date();
		
	}
	
	public CatalogProdutoEntity() {
		
	}
	
	public Integer getEntityId() {
		return entityId;
	}
	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}
	public Integer getAttributeSetId() {
		return attributeSetId;
	}
	public void setAttributeSetId(Integer attributeSetId) {
		this.attributeSetId = attributeSetId;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getSKU() {
		return SKU;
	}
	public void setSKU(String sKU) {
		SKU = sKU;
	}
	public Integer getHasOptions() {
		return hasOptions;
	}
	public void setHasOptions(Integer hasOptions) {
		this.hasOptions = hasOptions;
	}
	public Integer getRequiredOptions() {
		return requiredOptions;
	}
	public void setRequiredOptions(Integer requiredOptions) {
		this.requiredOptions = requiredOptions;
	}
	public Date getCrateadAt() {
		return crateadAt;
	}
	public void setCrateadAt(Date crateadAt) {
		this.crateadAt = crateadAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "CatalogProdutoEntity [entityId=" + entityId + ", attributeSetId=" + attributeSetId + ", typeId="
				+ typeId + ", SKU=" + SKU + ", hasOptions=" + hasOptions + ", requiredOptions=" + requiredOptions
				+ ", crateadAt=" + crateadAt + ", updatedAt=" + updatedAt + "]";
	}

}
