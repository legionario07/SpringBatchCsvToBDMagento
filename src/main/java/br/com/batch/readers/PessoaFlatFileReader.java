package br.com.batch.readers;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import br.com.batch.model.Pessoa;

@Component
public class PessoaFlatFileReader {

	@Bean
	public FlatFileItemReader<Pessoa> getPessoaFlatFileReader(){
		
		System.out.println("Iniciando reader");
	
		FlatFileItemReader<Pessoa> reader = new FlatFileItemReader<Pessoa>();
		reader.setEncoding("UTF-8");
		reader.setResource(new FileSystemResource("c://teste//pessoas.csv"));
		reader.setLineMapper(new DefaultLineMapper<Pessoa>() {{
			setLineTokenizer(new DelimitedLineTokenizer(",") {{
				setNames("nome","idade", "mae");
			}});
			setFieldSetMapper(new PessoaFieldSetMapper());
		}});
		return reader;
	}
	
}
