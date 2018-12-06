package br.com.batch.processor;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import br.com.batch.configuration.CsvConfig;
import br.com.batch.databases.repository.CatalogProdutoEntityDecimalRepository;
import br.com.batch.databases.repository.CatalogProdutoEntityIntRepository;
import br.com.batch.databases.repository.CatalogProdutoEntityRepository;
import br.com.batch.databases.repository.CatalogProdutoEntityTextRepository;
import br.com.batch.databases.repository.CatalogProdutoEntityVarcharRepository;
import br.com.batch.model.CatalogProdutoEntity;
import br.com.batch.model.CatalogProdutoEntityDecimal;
import br.com.batch.model.CatalogProdutoEntityInt;
import br.com.batch.model.CatalogProdutoEntityText;
import br.com.batch.model.CatalogProdutoEntityVarchar;
import br.com.batch.model.Produto;
import br.com.batch.model.enums.EavAttributeType;
import br.com.batch.utils.SessionUtil;

@Component
public class SaveItemProcessor implements ItemProcessor<Produto, Produto> {

	public static final Logger logger = LoggerFactory.getLogger(SaveItemProcessor.class);

	@Autowired
	private CsvConfig csvConfig;

	@Autowired
	private CatalogProdutoEntityRepository catalogProdutoEntityRepository;

	@Autowired
	private CatalogProdutoEntityDecimalRepository catalogProdutoEntityDecimalRepository;

	@Autowired
	private CatalogProdutoEntityIntRepository catalogProdutoEntityIntRepository;

	@Autowired
	private CatalogProdutoEntityTextRepository catalogProdutoEntityTextRepository;

	@Autowired
	private CatalogProdutoEntityVarcharRepository catalogProdutoEntityVarcharRepository;

	@Override
	public Produto process(Produto saveItem) throws Exception {

		logger.info("Iniciando Processamento: {}", saveItem);

		// inserindo o Produto como Entidade
		CatalogProdutoEntity catalogProdutoEntity = new CatalogProdutoEntity(4, saveItem.getEan());
		if(catalogProdutoEntityRepository.findBySKU(catalogProdutoEntity.getSKU())!=null) {
			return saveItem;
		}
		catalogProdutoEntity = catalogProdutoEntityRepository.save(catalogProdutoEntity);
		logger.info("Inserindo na tabela catalog_product_entity: {}", catalogProdutoEntity);
		saveItem.setEntityId(catalogProdutoEntity.getEntityId());

		// Inserindo atributos BigDecimal do produto
		Map<Integer, BigDecimal> listDecimal = new HashMap<>();
		String precoVendaStr = saveItem.getData().get(csvConfig.getCampoPrecoVenda());
		BigDecimal precoVenda = null;
		if (precoVendaStr != null && !precoVendaStr.equals("")) {
			precoVenda = new BigDecimal(precoVendaStr.replace(",", "."));
		} else {
			precoVenda = BigDecimal.ZERO;
		}

		listDecimal.put(
				SessionUtil.getInstance().getMapEavAttributes().get(EavAttributeType.PRICE.getValue()).getAttributeId(),
				precoVenda);

		listDecimal.put(SessionUtil.getInstance().getMapEavAttributes()
				.get(EavAttributeType.TS_DIMENSIONS_HEIGHT.getValue()).getAttributeId(), saveItem.getHeight());
		listDecimal.put(SessionUtil.getInstance().getMapEavAttributes()
				.get(EavAttributeType.TS_DIMENSIONS_LENGTH.getValue()).getAttributeId(), saveItem.getLenght());
		listDecimal.put(SessionUtil.getInstance().getMapEavAttributes()
				.get(EavAttributeType.TS_DIMENSIONS_WIDTH.getValue()).getAttributeId(), saveItem.getWidth());

		CatalogProdutoEntityDecimal catalogProdutoDecimal = null;

		for (Integer i : listDecimal.keySet()) {

			catalogProdutoDecimal = new CatalogProdutoEntityDecimal(saveItem.getEntityId(), listDecimal.get(i), i);
			catalogProdutoEntityDecimalRepository.save(catalogProdutoDecimal);

			logger.info("Inserindo na tabela catalog_product_entity_int: {}", catalogProdutoDecimal);

		}

		// Inserindo attributes obrigatórios
		Map<Integer, Integer> listInt = new HashMap<>();
		listInt.put(SessionUtil.getInstance().getMapEavAttributes().get(EavAttributeType.STATUS.getValue())
				.getAttributeId(), 1);
		listInt.put(SessionUtil.getInstance().getMapEavAttributes().get(EavAttributeType.VISIBILTY.getValue())
				.getAttributeId(), 4);
		listInt.put(SessionUtil.getInstance().getMapEavAttributes().get(EavAttributeType.QTDE_AND_STOCK.getValue())
				.getAttributeId(), 1);
		listInt.put(SessionUtil.getInstance().getMapEavAttributes().get(EavAttributeType.TAX_CLASS_ID.getValue())
				.getAttributeId(), 2);

		CatalogProdutoEntityInt catalogProdutoEntityInt = null;

		for (Integer i : listInt.keySet()) {

			catalogProdutoEntityInt = new CatalogProdutoEntityInt(saveItem.getEntityId(), listInt.get(i), i);
			catalogProdutoEntityIntRepository.save(catalogProdutoEntityInt);

			logger.info("Inserindo na tabela catalog_product_entity_int: {}", catalogProdutoEntityInt);

		}

		// Inserindo atributo meta_keywork
		Integer metaKeyWord = SessionUtil.getInstance().getMapEavAttributes()
				.get(EavAttributeType.META_KEYWORD.getValue()).getAttributeId();
		CatalogProdutoEntityText catalogProdutoEntityText = new CatalogProdutoEntityText(saveItem.getEntityId(),
				saveItem.getNome(), metaKeyWord);
		catalogProdutoEntityTextRepository.save(catalogProdutoEntityText);

		logger.info("Inserindo na tabela catalog_product_entity_text: {}", catalogProdutoEntityText);

		// Inserindo atributos da tabela catalog_product_entity_varchar
		Map<Integer, String> listVarchar = new HashMap<>();
		listVarchar.put(
				SessionUtil.getInstance().getMapEavAttributes().get(EavAttributeType.NAME.getValue()).getAttributeId(),
				saveItem.getNome());
		listVarchar.put(SessionUtil.getInstance().getMapEavAttributes().get(EavAttributeType.META_TITLE.getValue())
				.getAttributeId(), saveItem.getNome());
		listVarchar.put(SessionUtil.getInstance().getMapEavAttributes()
				.get(EavAttributeType.META_DESCRIPTION.getValue()).getAttributeId(), saveItem.getPrincipioAtivo());
		listVarchar.put(SessionUtil.getInstance().getMapEavAttributes()
				.get(EavAttributeType.OPTION_CONTAINER.getValue()).getAttributeId(), "container 2");
		listVarchar.put(SessionUtil.getInstance().getMapEavAttributes().get(EavAttributeType.URL_KEY.getValue())
				.getAttributeId(), saveItem.getNome().toLowerCase());
		listVarchar.put(SessionUtil.getInstance().getMapEavAttributes()
				.get(EavAttributeType.GIFT_MESSAGE_AVAILABLE.getValue()).getAttributeId(), "2");
		listVarchar.put(SessionUtil.getInstance().getMapEavAttributes().get(EavAttributeType.PRINCIPIO_ATIVO.getValue())
				.getAttributeId(), saveItem.getPrincipioAtivo());
		listVarchar.put(SessionUtil.getInstance().getMapEavAttributes().get(EavAttributeType.CONCENTRACAO.getValue())
				.getAttributeId(), saveItem.getApresentacao());
		listVarchar.put(SessionUtil.getInstance().getMapEavAttributes().get(EavAttributeType.FABRICANTE.getValue())
				.getAttributeId(), saveItem.getLaboratorio());
		listVarchar.put(SessionUtil.getInstance().getMapEavAttributes().get(EavAttributeType.DIMENSOES.getValue())
				.getAttributeId(), saveItem.getDimensoes());
		listVarchar.put(SessionUtil.getInstance().getMapEavAttributes().get(EavAttributeType.REGISTRO.getValue())
				.getAttributeId(), saveItem.getRegistro());
		listVarchar.put(SessionUtil.getInstance().getMapEavAttributes()
				.get(EavAttributeType.CLASSE_TERAPEUTICA.getValue()).getAttributeId(), saveItem.getClasseTerapeutica());
		listVarchar.put(SessionUtil.getInstance().getMapEavAttributes().get(EavAttributeType.CODIGO_GGREM.getValue())
				.getAttributeId(), saveItem.getCodigoGGREM());
		listVarchar.put(SessionUtil.getInstance().getMapEavAttributes()
				.get(EavAttributeType.RESTRICAO_HOSPITALAR.getValue()).getAttributeId(),
				saveItem.getRestricaoHospitalar());
		listVarchar.put(SessionUtil.getInstance().getMapEavAttributes().get(EavAttributeType.CONFAZ_87.getValue())
				.getAttributeId(), saveItem.getConfaz87());
		listVarchar.put(
				SessionUtil.getInstance().getMapEavAttributes().get(EavAttributeType.CAP.getValue()).getAttributeId(),
				saveItem.getCap());

		CatalogProdutoEntityVarchar catalogProdutoEntityVarchar = null;
		for (Integer i : listVarchar.keySet()) {

			catalogProdutoEntityVarchar = new CatalogProdutoEntityVarchar(saveItem.getEntityId(), listVarchar.get(i),
					i);
			catalogProdutoEntityVarcharRepository.save(catalogProdutoEntityVarchar);

			logger.info("Inserindo na tabela catalog_product_entity_varchar: {}", catalogProdutoEntityVarchar);

		}

		return saveItem;
	}

	@Bean
	public SaveItemProcessor getProcess() {
		return new SaveItemProcessor();
	}

}
