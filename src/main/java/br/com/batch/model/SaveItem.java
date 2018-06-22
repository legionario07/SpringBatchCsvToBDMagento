package br.com.batch.model;

import java.util.HashMap;
import java.util.Map;

public class SaveItem {

	private String nome;
	private Integer idade;
	private String mae;
	private Map<String, String> data;
	
	public SaveItem() {
		data = new HashMap<String, String>();
	}
	
	public SaveItem(String nome, Integer idade, String mae) {
		this();
		this.nome = nome;
		this.idade = idade;
		this.mae = mae;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getMae() {
		return mae;
	}
	public void setMae(String mae) {
		this.mae = mae;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", idade=" + idade + ", mae=" + mae + "]";
	}

	public Map<String, String> getData() {
		return data;
	}

	public void setData(Map<String, String> data) {
		this.data = data;
	}
	
}
