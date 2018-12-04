package br.com.batch.configuration;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@ConfigurationProperties("csv")
@Validated
public class CsvConfig {

	private String nameFile;
	private String split;
	private String campoPrecoCompra;
	private String campoPrecoVenda;
	private List<String> namesCols;
	
	public String getNameFile() {
		return nameFile;
	}
	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}
	public String getSplit() {
		return split;
	}
	public void setSplit(String split) {
		this.split = split;
	}
	public List<String> getNamesCols() {
		return namesCols;
	}
	public void setNamesCols(List<String> namesCols) {
		this.namesCols = namesCols;
	}
	
	public String[] getNamesColsToArray() {
		String[] namesToArrays = new String[getNamesCols().size()];
		
		int i = 0;
		
		for(String s : getNamesCols()) {
			namesToArrays[i++] = s;
		}
		
		return namesToArrays;
		
	}
	public String getCampoPrecoCompra() {
		return campoPrecoCompra;
	}
	public void setCampoPrecoCompra(String campoPrecoCompra) {
		this.campoPrecoCompra = campoPrecoCompra;
	}
	public String getCampoPrecoVenda() {
		return campoPrecoVenda;
	}
	public void setCampoPrecoVenda(String campoPrecoVenda) {
		this.campoPrecoVenda = campoPrecoVenda;
	}
	
}
