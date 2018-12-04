package br.com.batch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="eav_attribute")
public class EavAttribute {
	
	

	
	@Column(name="attribute_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer attributeId;
	
	@Column(name="entity_type_id")
	private Integer entityTypeId;
	
	@Column(name="attribute_code")
	private String attributeCode;
	
	@Column(name="attribute_model")
	private String attributeModel;
	
	@Column(name="backend_model")
	private String backendModel;
	
	@Column(name="backend_type")
	private String backendType;
	
	@Column(name="backend_table")
	private String backendTable;
	
	@Column(name="frontend_model")
	private String frontendModel;
	
	@Column(name="frontend_input")
	private String frontendInput;
	
	@Column(name="frontend_label")
	private String frontendLabel;
	
	@Column(name="frontend_class")
	private String frontendClass;
	
	@Column(name="source_model")
	private String sourceModel;
	
	@Column(name ="is_required")
	private Integer isRequired;
	
	@Column(name ="is_user_defined")
	private Integer isUserDefined;
	
	@Column(name ="default_value")
	private String defaultValue;
	
	@Column(name ="is_unique")
	private String isUnique;
	
	@Column(name ="note")
	private String note;
	
	public EavAttribute(Integer attributeId) {
		this();
		this.attributeId = attributeId;
	}
	
	public EavAttribute() {
		
	}

	public Integer getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(Integer attributeId) {
		this.attributeId = attributeId;
	}

	public Integer getEntityTypeId() {
		return entityTypeId;
	}

	public void setEntityTypeId(Integer entityTypeId) {
		this.entityTypeId = entityTypeId;
	}

	public String getAttributeCode() {
		return attributeCode;
	}

	public void setAttributeCode(String attributeCode) {
		this.attributeCode = attributeCode;
	}

	public String getAttributeModel() {
		return attributeModel;
	}

	public void setAttributeModel(String attributeModel) {
		this.attributeModel = attributeModel;
	}

	public String getBackendModel() {
		return backendModel;
	}

	public void setBackendModel(String backendModel) {
		this.backendModel = backendModel;
	}

	public String getBackendType() {
		return backendType;
	}

	public void setBackendType(String backendType) {
		this.backendType = backendType;
	}

	public String getBackendTable() {
		return backendTable;
	}

	public void setBackendTable(String backendTable) {
		this.backendTable = backendTable;
	}

	public String getFrontendModel() {
		return frontendModel;
	}

	public void setFrontendModel(String frontendModel) {
		this.frontendModel = frontendModel;
	}

	public String getFrontendInput() {
		return frontendInput;
	}

	public void setFrontendInput(String frontendInput) {
		this.frontendInput = frontendInput;
	}

	public String getFrontendLabel() {
		return frontendLabel;
	}

	public void setFrontendLabel(String frontendLabel) {
		this.frontendLabel = frontendLabel;
	}

	public String getFrontendClass() {
		return frontendClass;
	}

	public void setFrontendClass(String frontendClass) {
		this.frontendClass = frontendClass;
	}

	public String getSourceModel() {
		return sourceModel;
	}

	public void setSourceModel(String sourceModel) {
		this.sourceModel = sourceModel;
	}

	public Integer getIsRequired() {
		return isRequired;
	}

	public void setIsRequired(Integer isRequired) {
		this.isRequired = isRequired;
	}

	public Integer getIsUserDefined() {
		return isUserDefined;
	}

	public void setIsUserDefined(Integer isUserDefined) {
		this.isUserDefined = isUserDefined;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getIsUnique() {
		return isUnique;
	}

	public void setIsUnique(String isUnique) {
		this.isUnique = isUnique;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "EavAttributes [attributeId=" + attributeId + ", entityTypeId=" + entityTypeId + ", attributeCode="
				+ attributeCode + ", attributeModel=" + attributeModel + ", backendModel=" + backendModel
				+ ", backendType=" + backendType + ", backendTable=" + backendTable + ", frontendModel=" + frontendModel
				+ ", frontendInput=" + frontendInput + ", frontendLabel=" + frontendLabel + ", frontendClass="
				+ frontendClass + ", sourceModel=" + sourceModel + ", isRequired=" + isRequired + ", isUserDefined="
				+ isUserDefined + ", defaultValue=" + defaultValue + ", isUnique=" + isUnique + ", note=" + note + "]";
	}
	

}
