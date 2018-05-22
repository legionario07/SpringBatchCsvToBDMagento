package br.com.batch.model;

import org.springframework.batch.item.ItemProcessor;

public class PessoaItemProcessor implements ItemProcessor<Pessoa, Pessoa> {

	@Override
	public Pessoa process(Pessoa pessoa) throws Exception {
		System.out.println("Iniciando Processamento");
		Integer idade = pessoa.getIdade();
		idade+=10;
		pessoa.setIdade(idade);
		System.out.println(pessoa);
		
		return pessoa;
	}

}
