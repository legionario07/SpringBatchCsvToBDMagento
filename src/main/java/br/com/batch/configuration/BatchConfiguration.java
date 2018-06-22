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

import br.com.batch.model.SaveItem;
import br.com.batch.processor.SaveItemProcessor;
import br.com.batch.readers.SaveItemFieldSetMapper;
import br.com.batch.readers.SaveItemFlatFileReader;
import br.com.batch.writers.SaveJdbcBatchItemWriter;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	SaveItemFieldSetMapper saveItemFieldSetMapper;
	
	@Autowired
	SaveItemFlatFileReader saveItemFlatFileReader;
	
	@Autowired
	SaveJdbcBatchItemWriter saveJdbcBatchItemWriter;
	
	@Autowired
	SaveItemProcessor saveItemProcessor;
	
	@Autowired
	InterceptingJobExecution interceptingJobExecution;
	
	
	@Bean
	public Step step1() {
		System.out.println("STEP 1");
		return stepBuilderFactory.get("step1").<SaveItem,SaveItem>chunk(10)
				.reader(saveItemFlatFileReader.getSaveItemFlatFileReader())
				.processor(saveItemProcessor.getProcess())
				.writer(saveJdbcBatchItemWriter.getWriter())
				.build();
	}
	
//	@Bean
//	public Step step2() {
//		System.out.println("STEP 2");
//		return stepBuilderFactory.get("step2").<SaveItem,SaveItem>chunk(10)
//				.reader(saveItemFlatFileReader.getSaveItemFlatFileReader())
//				.processor(saveItemProcessor.getProcess())
//				.writer(saveJdbcBatchItemWriter.getWriter())
//				.build();
//	}
	
	@Bean
	public Job exportSaveCsvJob() {
		return jobBuilderFactory.get("exportSaveCsvJob")
				.incrementer(new RunIdIncrementer())
				.flow(step1())
				//.next(step2())
				.end()
				.listener(interceptingJobExecution)
				.build();
				
	}
}

