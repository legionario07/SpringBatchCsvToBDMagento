package br.com.batch.readers;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import br.com.batch.configuration.CsvConfig;
import br.com.batch.model.SaveItem;

@Component
public class SaveItemFlatFileReader {

	@Autowired
	CsvConfig csvConfig;
	
	@Bean
	public FlatFileItemReader<SaveItem> getSaveItemFlatFileReader(){
		
		System.out.println("Iniciando reader");
		
		//String names[] = csvConfig.get
	
		FlatFileItemReader<SaveItem> reader = new FlatFileItemReader<SaveItem>();
		reader.setEncoding("UTF-8");
		reader.setResource(new FileSystemResource(csvConfig.getNameFile()));
		reader.setLineMapper(new DefaultLineMapper<SaveItem>() {{
			setLineTokenizer(new DelimitedLineTokenizer(csvConfig.getSplit()) {{
				//setNames("nome","idade", "mae");
				setNames((String[]) csvConfig.getNamesColsToArray());
			}});
			setFieldSetMapper(new SaveItemFieldSetMapper(csvConfig));
		}});
		return reader;
	}
	
}
