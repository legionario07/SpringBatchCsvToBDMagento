package br.com.batch.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Produto {

	private Integer entityId;
	private String principioAtivo;
	private String cnpj;
	private String laboratorio;
	private String codigoGGREM;
	private String registro;
	private String ean;
	private String nome;
	private String apresentacao;
	private String classeTerapeutica;
	private String pf0;
	private String pf12;
	private String pf17;
	private String pf17Alc;
	private String pf17_5;
	private String pf17_5Alc;
	private String pf18;
	private String pf18Alc;
	private String pf20;
	private String pmc0;
	private String pmc12;
	private String pmc17;
	private String pmc17Alc;
	private String pmc17_5;
	private String pmc17_5Alc;
	private String pmc18;
	private String pmc18Alc;
	private String pmc20;
	private String restricaoHospitalar;
	private String cap;
	private String confaz87;
	private String dimensoes;
	private BigDecimal lenght;
	private BigDecimal height;
	private BigDecimal width;
	private String cubagem;
	private String peso;
	private Map<String, String> data;
	
	public Produto() {
		data = new HashMap<String, String>();
	}
	
	public Produto(String nome) {
		this();
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Map<String, String> getData() {
		return data;
	}

	public void setData(Map<String, String> data) {
		this.data = data;
	}

	public String getPrincipioAtivo() {
		return principioAtivo;
	}

	public void setPrincipioAtivo(String principioAtivo) {
		this.principioAtivo = principioAtivo;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public String getCodigoGGREM() {
		return codigoGGREM;
	}

	public void setCodigoGGREM(String codigoGGREM) {
		this.codigoGGREM = codigoGGREM;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public String getApresentacao() {
		return apresentacao;
	}

	public void setApresentacao(String apresentacao) {
		this.apresentacao = apresentacao;
	}

	public String getClasseTerapeutica() {
		return classeTerapeutica;
	}

	public void setClasseTerapeutica(String classeTerapeutica) {
		this.classeTerapeutica = classeTerapeutica;
	}

	public String getPf0() {
		return pf0;
	}

	public void setPf0(String pf0) {
		this.pf0 = pf0;
	}

	public String getPf12() {
		return pf12;
	}

	public void setPf12(String pf12) {
		this.pf12 = pf12;
	}

	public String getPf17() {
		return pf17;
	}

	public void setPf17(String pf17) {
		this.pf17 = pf17;
	}

	public String getPf17Alc() {
		return pf17Alc;
	}

	public void setPf17Alc(String pf17Alc) {
		this.pf17Alc = pf17Alc;
	}

	public String getPf17_5() {
		return pf17_5;
	}

	public void setPf17_5(String pf17_5) {
		this.pf17_5 = pf17_5;
	}

	public String getPf17_5Alc() {
		return pf17_5Alc;
	}

	public void setPf17_5Alc(String pf17_5Alc) {
		this.pf17_5Alc = pf17_5Alc;
	}

	public String getPf18() {
		return pf18;
	}

	public void setPf18(String pf18) {
		this.pf18 = pf18;
	}

	public String getPf18Alc() {
		return pf18Alc;
	}

	public void setPf18Alc(String pf18Alc) {
		this.pf18Alc = pf18Alc;
	}

	public String getPf20() {
		return pf20;
	}

	public void setPf20(String pf20) {
		this.pf20 = pf20;
	}

	public String getPmc0() {
		return pmc0;
	}

	public void setPmc0(String pmc0) {
		this.pmc0 = pmc0;
	}

	public String getPmc12() {
		return pmc12;
	}

	public void setPmc12(String pmc12) {
		this.pmc12 = pmc12;
	}

	public String getPmc17() {
		return pmc17;
	}

	public void setPmc17(String pmc17) {
		this.pmc17 = pmc17;
	}

	public String getPmc17Alc() {
		return pmc17Alc;
	}

	public void setPmc17Alc(String pmc17Alc) {
		this.pmc17Alc = pmc17Alc;
	}

	public String getPmc17_5() {
		return pmc17_5;
	}

	public void setPmc17_5(String pmc17_5) {
		this.pmc17_5 = pmc17_5;
	}

	public String getPmc17_5Alc() {
		return pmc17_5Alc;
	}

	public void setPmc17_5Alc(String pmc17_5Alc) {
		this.pmc17_5Alc = pmc17_5Alc;
	}

	public String getPmc18() {
		return pmc18;
	}

	public void setPmc18(String pmc18) {
		this.pmc18 = pmc18;
	}

	public String getPmc18Alc() {
		return pmc18Alc;
	}

	public void setPmc18Alc(String pmc18Alc) {
		this.pmc18Alc = pmc18Alc;
	}

	public String getPmc20() {
		return pmc20;
	}

	public void setPmc20(String pmc20) {
		this.pmc20 = pmc20;
	}

	public String getRestricaoHospitalar() {
		return restricaoHospitalar;
	}

	public void setRestricaoHospitalar(String restricaoHospitalar) {
		this.restricaoHospitalar = restricaoHospitalar;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getConfaz87() {
		return confaz87;
	}

	public void setConfaz87(String confaz87) {
		this.confaz87 = confaz87;
	}

	public String getDimensoes() {
		return dimensoes;
	}

	public void setDimensoes(String dimensoes) {
		this.dimensoes = dimensoes;
	}

	public String getCubagem() {
		return cubagem;
	}

	public void setCubagem(String cubagem) {
		this.cubagem = cubagem;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}


	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public BigDecimal getLenght() {
		return lenght;
	}

	public void setLenght(BigDecimal lenght) {
		this.lenght = lenght;
	}

	public BigDecimal getHeight() {
		return height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public BigDecimal getWidth() {
		return width;
	}

	public void setWidth(BigDecimal width) {
		this.width = width;
	}

	@Override
	public String toString() {
		return "Produto [entityId=" + entityId + ", principioAtivo=" + principioAtivo + ", cnpj=" + cnpj
				+ ", laboratorio=" + laboratorio + ", codigoGGREM=" + codigoGGREM + ", registro=" + registro + ", ean="
				+ ean + ", nome=" + nome + ", apresentacao=" + apresentacao + ", classeTerapeutica=" + classeTerapeutica
				+ ", pf0=" + pf0 + ", pf12=" + pf12 + ", pf17=" + pf17 + ", pf17Alc=" + pf17Alc + ", pf17_5=" + pf17_5
				+ ", pf17_5Alc=" + pf17_5Alc + ", pf18=" + pf18 + ", pf18Alc=" + pf18Alc + ", pf20=" + pf20 + ", pmc0="
				+ pmc0 + ", pmc12=" + pmc12 + ", pmc17=" + pmc17 + ", pmc17Alc=" + pmc17Alc + ", pmc17_5=" + pmc17_5
				+ ", pmc17_5Alc=" + pmc17_5Alc + ", pmc18=" + pmc18 + ", pmc18Alc=" + pmc18Alc + ", pmc20=" + pmc20
				+ ", restricaoHospitalar=" + restricaoHospitalar + ", cap=" + cap + ", confaz87=" + confaz87
				+ ", dimensoes=" + dimensoes + ", lenght=" + lenght + ", height=" + height + ", width=" + width
				+ ", cubagem=" + cubagem + ", peso=" + peso + ", data=" + data + "]";
	}
	
}
