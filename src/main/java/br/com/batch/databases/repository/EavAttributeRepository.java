package br.com.batch.databases.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.batch.model.EavAttribute;


@Repository
public interface EavAttributeRepository extends CrudRepository<EavAttribute, Integer> {
	

}
