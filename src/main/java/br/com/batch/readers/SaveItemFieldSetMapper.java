package br.com.batch.readers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;

import br.com.batch.configuration.CsvConfig;
import br.com.batch.model.SaveItem;

@Component
public class SaveItemFieldSetMapper implements FieldSetMapper<SaveItem> {

	private CsvConfig csvConfig;
	
	public SaveItemFieldSetMapper() {
		
	}
	
	public SaveItemFieldSetMapper(CsvConfig csvConfig) {
		this.csvConfig = csvConfig;
	}
	
	public SaveItem mapFieldSet(FieldSet arg) {

		SaveItem p = new SaveItem();
		List<String> fields = csvConfig.getNamesCols();
		
		Map<String, String> dataTemp = new HashMap<String, String>();		
		for(String field : fields) {
			dataTemp.put(field, arg.readString(field));
		}
		
		p.setData(dataTemp);
		
		/*p.setNome(arg.readString("nome"));
		p.setIdade(arg.readInt("idade"));
		p.setMae(arg.readString("mae"));*/

		return p;
	}
}
