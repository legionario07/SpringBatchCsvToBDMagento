package br.com.batch.readers;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;

import br.com.batch.configuration.CsvConfig;
import br.com.batch.model.Produto;

@Component
public class ProdutoItemFieldSetMapper implements FieldSetMapper<Produto> {

	private CsvConfig csvConfig;
	
	public ProdutoItemFieldSetMapper() {
		
	}
	
	public ProdutoItemFieldSetMapper(CsvConfig csvConfig) {
		this.csvConfig = csvConfig;
	}
	
	public Produto mapFieldSet(FieldSet arg) {

		Produto p = new Produto();
		List<String> fields = csvConfig.getNamesCols();
		
		Map<String, String> dataTemp = new HashMap<String, String>();		
		for(String field : fields) {
			dataTemp.put(field, arg.readString(field));
		}
		
		p.setData(dataTemp);
		
		int i = 0;
		p.setPrincipioAtivo(dataTemp.get(csvConfig.getNamesCols().get(i++)));
		p.setCnpj(dataTemp.get(csvConfig.getNamesCols().get(i++)));
		p.setLaboratorio(dataTemp.get(csvConfig.getNamesCols().get(i++)));
		p.setCodigoGGREM(dataTemp.get(csvConfig.getNamesCols().get(i++)));
		p.setRegistro(dataTemp.get(csvConfig.getNamesCols().get(i++)));
		p.setEan(dataTemp.get(csvConfig.getNamesCols().get(i++)));
		p.setNome(dataTemp.get(csvConfig.getNamesCols().get(i++)));
		p.setApresentacao(dataTemp.get(csvConfig.getNamesCols().get(i++)));
		p.setClasseTerapeutica(dataTemp.get(csvConfig.getNamesCols().get(i++)));
		p.setPf0(dataTemp.get(csvConfig.getNamesCols().get(i++)));
		p.setPf12(dataTemp.get(csvConfig.getNamesCols().get(i++)));
		p.setPf17(dataTemp.get(csvConfig.getNamesCols().get(i++)));
		p.setPf17Alc(dataTemp.get(csvConfig.getNamesCols().get(i++)));
		p.setPf17_5(dataTemp.get(csvConfig.getNamesCols().get(i++)));
		p.setPf17_5Alc(dataTemp.get(csvConfig.getNamesCols().get(i++)));
		p.setPf18(dataTemp.get(csvConfig.getNamesCols().get(i++)));
		p.setPf18Alc(dataTemp.get(csvConfig.getNamesCols().get(i++)));
		p.setPf20(dataTemp.get(csvConfig.getNamesCols().get(i++)));
		p.setPmc0(dataTemp.get(csvConfig.getNamesCols().get(i++)));
		p.setPmc12(dataTemp.get(csvConfig.getNamesCols().get(i++)));
		p.setPmc17(dataTemp.get(csvConfig.getNamesCols().get(i++)));
		p.setPmc17Alc(dataTemp.get(csvConfig.getNamesCols().get(i++)));
		p.setPmc17_5(dataTemp.get(csvConfig.getNamesCols().get(i++)));
		p.setPmc17_5Alc(dataTemp.get(csvConfig.getNamesCols().get(i++)));
		p.setPmc18(dataTemp.get(csvConfig.getNamesCols().get(i++)));
		p.setPmc18Alc(dataTemp.get(csvConfig.getNamesCols().get(i++)));
		p.setPmc20(dataTemp.get(csvConfig.getNamesCols().get(i++)));
		
		String restricaoHospitalar = dataTemp.get(csvConfig.getNamesCols().get(i++));
		if(restricaoHospitalar==null || "Não".equalsIgnoreCase(restricaoHospitalar) 
				|| "".equalsIgnoreCase(restricaoHospitalar) || "Nao".equalsIgnoreCase(restricaoHospitalar) ) {
			p.setRestricaoHospitalar("Não");
		}else {
			p.setRestricaoHospitalar("Sim");
		}
		
		String cap = dataTemp.get(csvConfig.getNamesCols().get(i++));
		if(cap==null || "Não".equalsIgnoreCase(cap) 
				|| "".equalsIgnoreCase(cap) || "Nao".equalsIgnoreCase(cap) ) {
			p.setCap("NÃO");
		}else {
			p.setCap("SIM");
		}
		
		String confaz87 = dataTemp.get(csvConfig.getNamesCols().get(i++));
		if(confaz87==null || "Não".equalsIgnoreCase(confaz87) 
				|| "".equalsIgnoreCase(confaz87) || "Nao".equalsIgnoreCase(confaz87) ) {
			p.setConfaz87("NÃO");
		}else {
			p.setConfaz87("SIM");
		}
		
		p.setDimensoes(dataTemp.get(csvConfig.getNamesCols().get(i++)));
		p.setCubagem(dataTemp.get(csvConfig.getNamesCols().get(i++)));
		p.setPeso(dataTemp.get(csvConfig.getNamesCols().get(i++)));
		
		BigDecimal length = null;
		BigDecimal width = null;
		BigDecimal heigth = null;
		
		if(p.getDimensoes()!=null) {
			String valores[] = p.getDimensoes().split("x");
			length = new BigDecimal(valores[0].trim().replace(",", "."));
			width = new BigDecimal(valores[1].trim().replace(",", "."));
			heigth = new BigDecimal(valores[2].trim().replace(",", "."));
		}else {
			length = new BigDecimal("10.8");
			width = new BigDecimal("5.7");
			heigth = new BigDecimal("2.1");
		}
		
		p.setLenght(length);
		p.setWidth(width);
		p.setHeight(heigth);
		
		return p;
	}
}
