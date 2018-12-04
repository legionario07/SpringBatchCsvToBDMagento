package br.com.batch.model.enums;

public enum EavAttributeType {

	TAX_CLASS_ID("tax_class_id"),
	QTDE_AND_STOCK("quantity_and_stock_status"),
	VISIBILTY("visibility"),
	STATUS("status"),
	META_KEYWORD("meta_keyword"),
	NAME("name"),
	META_TITLE("meta_title"),
	META_DESCRIPTION("meta_description"),
	IMAGE("image"),
	SMALL_IMAGE("small_image"),
	THUMBNAIL("thumbnail"),
	OPTION_CONTAINER("options_container"),
	URL_KEY("url_key"),
	GIFT_MESSAGE_AVAILABLE("gift_message_available"),
	SWATCH_IMAGE("swatch_image"),
	TS_DIMENSIONS_LENGTH("ts_dimensions_length"),
	TS_DIMENSIONS_WIDTH("ts_dimensions_width"),
	TS_DIMENSIONS_HEIGHT("ts_dimensions_height"),
	PRINCIPIO_ATIVO("principio_ativo"),
	CONCENTRACAO("concentracao"),
	FORMA_FARMACEUTICA("forma_farmaceutica"),
	MARCA("marca"),
	FABRICANTE("fabricante"),
	DIMENSOES("dimensoes"),
	REGISTRO("registro"),
	CLASSE_TERAPEUTICA("classe_terapeutica"),
	CODIGO_GGREM("codigo ggrem"),
	RESTRICAO_HOSPITALAR("restricao_hospitalar"),
	CAP("cap"),
	CONFAZ_87("confaz_87"),
	DATA_DE_VENCIMENTO("data_de_vencimento"),
	PRICE("price");
	
	private String value;
	
	private EavAttributeType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
