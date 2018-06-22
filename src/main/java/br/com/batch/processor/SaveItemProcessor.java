package br.com.batch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import br.com.batch.model.SaveItem;

@Component
public class SaveItemProcessor implements ItemProcessor<SaveItem, SaveItem> {

	@Override
	public SaveItem process(SaveItem saveItem) throws Exception {
		
		System.out.println("Iniciando Processamento");
		
//		Integer idade = saveItem.getIdade();
//		idade+=10;
//		saveItem.setIdade(idade);
		//System.out.println(saveItem);
		System.out.println(saveItem.getData().toString());
		
		return saveItem;
	}
	
	
	@Bean
	public SaveItemProcessor getProcess() {
		return new SaveItemProcessor();
	}

}
