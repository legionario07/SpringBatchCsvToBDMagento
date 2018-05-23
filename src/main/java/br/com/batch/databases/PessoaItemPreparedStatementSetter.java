package br.com.batch.databases;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import br.com.batch.model.Pessoa;

@Component
public class PessoaItemPreparedStatementSetter {

	@Bean
	public ItemPreparedStatementSetter<Pessoa> getSetter() {
	    
		return new ItemPreparedStatementSetter<Pessoa>() {
			
			@Override
			public void setValues(Pessoa item, PreparedStatement ps) throws SQLException {
				  ps.setString(1, item.getNome());
		           ps.setInt(2, item.getIdade());
		           ps.setString(3, item.getMae());
			}
			
		};
		
	 }
	
}
