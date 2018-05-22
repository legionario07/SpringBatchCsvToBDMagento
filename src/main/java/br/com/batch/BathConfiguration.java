package br.com.batch;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import br.com.batch.dao.PessoaFieldSetMapper;
import br.com.batch.model.Pessoa;
import br.com.batch.model.PessoaItemProcessor;

@Configuration
@EnableBatchProcessing
public class BathConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	public DataSource dataSource;
	
	@Autowired
	PessoaFieldSetMapper pessoaFieldSetMapper;
	
	@Bean
	public DataSource dataSource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/etl?autoReconnect=true&useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		return dataSource;
	}
	
	@Bean
	public FlatFileItemReader<Pessoa> reader(){
		
		System.out.println("Iniciando reader");
	
		DelimitedLineTokenizer line = new DelimitedLineTokenizer();
		
		FlatFileItemReader<Pessoa> reader = new FlatFileItemReader<Pessoa>();
		reader.setEncoding("UTF-8");
		reader.setResource(new FileSystemResource("c://teste//pessoas.csv"));
		reader.setLineMapper(new DefaultLineMapper<Pessoa>() {{
			setLineTokenizer(new DelimitedLineTokenizer(",") {{
				//setIncludedFields(0,1,2);
				setNames("nome","idade", "mae");
			}});
			setFieldSetMapper(new PessoaFieldSetMapper());
		}});
		return reader;
	}
	
	public class PessoaRowMapper implements RowMapper<Pessoa>{

		@Override
		public Pessoa mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Pessoa pessoa = new Pessoa();
			pessoa.setNome(rs.getString("nome"));
			pessoa.setIdade(rs.getInt("idade"));
			pessoa.setMae(rs.getString("mae"));
			
			System.out.println(pessoa);
			
			return pessoa;
		}
	}
	
	@Bean
	public PessoaItemProcessor processor() {
		return new PessoaItemProcessor();
	}
	
	@Bean
	public JdbcBatchItemWriter<Pessoa> writer(){
		JdbcBatchItemWriter<Pessoa> writer = new JdbcBatchItemWriter<Pessoa>();
		writer.setDataSource(dataSource);
		writer.setItemPreparedStatementSetter(setter());
		writer.setSql("insert into Pessoa (nome, idade, mae) values (?, ?, ?)");
		
		return writer;
	}
	
	@Bean
	public ItemPreparedStatementSetter<Pessoa> setter() {
	       return (item, ps) -> {
	           ps.setString(1, item.getNome());
	           ps.setInt(2, item.getIdade());
	           ps.setString(3, item.getMae());
	       };
	 }
	
	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<Pessoa,Pessoa>chunk(10)
				.reader(reader())
				.processor(processor())
				.writer(writer())
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

