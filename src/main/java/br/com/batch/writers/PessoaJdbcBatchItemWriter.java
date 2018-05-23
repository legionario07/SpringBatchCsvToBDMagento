package br.com.batch.writers;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import br.com.batch.databases.DataSourceConfiguration;
import br.com.batch.databases.PessoaItemPreparedStatementSetter;
import br.com.batch.model.Pessoa;

@Component
public class PessoaJdbcBatchItemWriter {

	@Autowired
	DataSourceConfiguration dataSource;
	
	@Autowired
	PessoaItemPreparedStatementSetter itemPreparedStatementSetter;
	
	@Bean
	public JdbcBatchItemWriter<Pessoa> getWriter(){
		
		JdbcBatchItemWriter<Pessoa> writer = new JdbcBatchItemWriter<Pessoa>();
		writer.setDataSource(dataSource.getDataSource());
		writer.setItemPreparedStatementSetter(itemPreparedStatementSetter.getSetter());
		writer.setSql("insert into Pessoa (nome, idade, mae) values (?, ?, ?)");
		
		return writer;
	}
	
}
