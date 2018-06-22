package br.com.batch.writers;

import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import br.com.batch.configuration.DbConfig;
import br.com.batch.databases.DataSourceConfiguration;
import br.com.batch.databases.SaveItemPreparedStatementSetter;
import br.com.batch.model.SaveItem;

@Component
public class SaveJdbcBatchItemWriter {

	@Autowired
	DataSourceConfiguration dataSource;
	
	@Autowired
	SaveItemPreparedStatementSetter itemPreparedStatementSetter;

	@Autowired
	DbConfig dbConfig;
	
	@Bean
	public JdbcBatchItemWriter<SaveItem> getWriter(){
		
		JdbcBatchItemWriter<SaveItem> writer = new JdbcBatchItemWriter<SaveItem>();
		writer.setDataSource(dataSource.getDataSource());
		writer.setItemPreparedStatementSetter(itemPreparedStatementSetter.getSetter());
		writer.setSql(dbConfig.getSqlSave());
		
		return writer;
	}
	
}
