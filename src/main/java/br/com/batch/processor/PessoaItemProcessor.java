package br.com.batch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import br.com.batch.model.Pessoa;

@Component
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
	
	
	@Bean
	public PessoaItemProcessor getProcess() {
		return new PessoaItemProcessor();
	}

}
