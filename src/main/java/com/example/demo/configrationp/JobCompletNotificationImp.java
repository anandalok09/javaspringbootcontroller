package com.example.demo.configrationp;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class JobCompletNotificationImp implements JobExecutionListener {

	@Override
	public void beforeJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub
		System.out.println("Job started");
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub
		System.out.println("Job Ended");
	}

	
	
	
}
