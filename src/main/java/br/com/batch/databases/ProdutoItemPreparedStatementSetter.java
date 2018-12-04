package br.com.batch.databases;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import br.com.batch.configuration.CsvConfig;
import br.com.batch.model.Produto;

@Component
public class ProdutoItemPreparedStatementSetter {

	@Autowired
	CsvConfig csvConfig;
	
	@Bean
	public ItemPreparedStatementSetter<Produto> getSetter() {
	    
		return new ItemPreparedStatementSetter<Produto>() {
			
			@Override
			public void setValues(Produto item, PreparedStatement ps) throws SQLException {
				int i = 1;
				List<String> namesCols = csvConfig.getNamesCols();
				for(String s : namesCols) {
					ps.setString(i++,item.getData().get(s));
				}
			}
		};
	 }
}
