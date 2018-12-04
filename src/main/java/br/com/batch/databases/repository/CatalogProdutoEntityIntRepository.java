package br.com.batch.databases.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.batch.model.CatalogProdutoEntityInt;


@Repository
public interface CatalogProdutoEntityIntRepository extends CrudRepository<CatalogProdutoEntityInt, Integer> {
	

}
