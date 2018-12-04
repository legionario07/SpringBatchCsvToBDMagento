package br.com.batch.listener;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.batch.databases.repository.EavAttributeRepository;
import br.com.batch.model.EavAttribute;
import br.com.batch.utils.SessionUtil;

@Component
public class InterceptingJobExecution implements JobExecutionListener{
	
	private static final Logger logger = LoggerFactory.getLogger(InterceptingJobExecution.class);
	
	@Autowired
	private EavAttributeRepository eavAttributeRepository;
	
	
	@Override
	public void beforeJob(JobExecution jobExecution) {
		
		
		//Carregando os dados de EavAttributes
		Iterable<EavAttribute> listAttributes = eavAttributeRepository.findAll();
		Map<String, EavAttribute> mapAttributes = new HashMap<>();
		for(EavAttribute e : listAttributes) {
			mapAttributes.put(e.getAttributeCode(), e);
		}
		SessionUtil.getInstance().setMapEavAttributes(mapAttributes);
		
		logger.info("Iniciando JobExecutionListener");
	}
 
	@Override
	public void afterJob(JobExecution jobExecution) {
		
		logger.info("Total de Produtos inseridos: {}",jobExecution.getStepExecutions().iterator().next().getReadCount());
		
		logger.info("Finalizado");
	}
 
}
