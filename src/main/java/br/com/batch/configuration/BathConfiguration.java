package br.com.batch.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.batch.model.Pessoa;
import br.com.batch.processor.PessoaItemProcessor;
import br.com.batch.readers.PessoaFieldSetMapper;
import br.com.batch.readers.PessoaFlatFileReader;
import br.com.batch.writers.PessoaJdbcBatchItemWriter;

@Configuration
@EnableBatchProcessing
public class BathConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	PessoaFieldSetMapper pessoaFieldSetMapper;
	
	@Autowired
	PessoaFlatFileReader pessoaFlatFileReader;
	
	@Autowired
	PessoaJdbcBatchItemWriter pessoaJdbcBatchItemWriter;
	
	@Autowired
	PessoaItemProcessor pessoaItemProcessor;
	
	
	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<Pessoa,Pessoa>chunk(10)
				.reader(pessoaFlatFileReader.getPessoaFlatFileReader())
				.processor(pessoaItemProcessor.getProcess())
				.writer(pessoaJdbcBatchItemWriter.getWriter())
				.build();
	}
	
	@Bean
	public Job exportPessoaJob() {
		return jobBuilderFactory.get("exportPessoaJob")
				.incrementer(new RunIdIncrementer())
				.flow(step1())
				.end()
				.build();
				
	}
}

