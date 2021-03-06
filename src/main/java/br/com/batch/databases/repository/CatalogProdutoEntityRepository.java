package br.com.batch.databases.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.batch.model.CatalogProdutoEntity;


@Repository
public interface CatalogProdutoEntityRepository extends CrudRepository<CatalogProdutoEntity, Integer> {
	
	CatalogProdutoEntity findBySKU(String sku);

}
