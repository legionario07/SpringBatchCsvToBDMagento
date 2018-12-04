package br.com.batch.writers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import br.com.batch.model.Produto;

@Component
public class SaveJdbcBatchItemWriter implements ItemWriter<Produto> {

	public static final Logger logger = LoggerFactory.getLogger(SaveJdbcBatchItemWriter.class);
	

	@Override
	public void write(List<? extends Produto> items) throws Exception {
		
		
		
	}
	
}
