package br.com.batch.dao;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;

import br.com.batch.model.Pessoa;

@Component
public class PessoaFieldSetMapper implements FieldSetMapper<Pessoa> {

	public Pessoa mapFieldSet(FieldSet arg) {

		Pessoa p = new Pessoa();
		p.setNome(arg.readString("nome"));
		p.setIdade(arg.readInt("idade"));
		p.setMae(arg.readString("mae"));

		return p;
	}
}
