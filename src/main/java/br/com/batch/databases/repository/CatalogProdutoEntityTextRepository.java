package br.com.batch.databases.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.batch.model.CatalogProdutoEntityText;


@Repository
public interface CatalogProdutoEntityTextRepository extends CrudRepository<CatalogProdutoEntityText, Integer> {
	

}
