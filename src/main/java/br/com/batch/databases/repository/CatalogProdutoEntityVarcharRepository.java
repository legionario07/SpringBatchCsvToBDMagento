package br.com.batch.databases.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.batch.model.CatalogProdutoEntityVarchar;


@Repository
public interface CatalogProdutoEntityVarcharRepository extends CrudRepository<CatalogProdutoEntityVarchar, Integer> {
	

}
