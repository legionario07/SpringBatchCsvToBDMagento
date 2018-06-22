package br.com.batch.configuration;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class InterceptingJobExecution implements JobExecutionListener{
	
 
	@Override
	public void beforeJob(JobExecution jobExecution) {
		//
		// Can Log || do some business code
		//
		System.out.println("Before JobExecutionListener");
	}
 
	@Override
	public void afterJob(JobExecution jobExecution) {
		//
		// Can Log || do some Business code
		//
		System.out.println("After JobExecutionListener");
	}
 
}
