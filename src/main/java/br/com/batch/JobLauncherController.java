package br.com.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.batch.configuration.BatchConfiguration;

@RestController
public class JobLauncherController {
 
    @Autowired
    JobLauncher jobLauncher;
 
    @Autowired
    Job job;
    
    @Autowired
    BatchConfiguration bath;
    
    @RequestMapping("/launchjob")
    public String handle() throws Exception {
    	
        try {
            JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                    .toJobParameters();
            //jobLauncher.run(job, jobParameters);
        	jobLauncher.run(bath.exportSaveCsvJob(), jobParameters);
        } catch (Exception e) {
           System.out.println(e);
        }
 
        return "Done";
    }
}