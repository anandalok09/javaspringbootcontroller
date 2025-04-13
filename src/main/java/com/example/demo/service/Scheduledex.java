package com.example.demo.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Scheduledex {
//fixedRate execute every 5 second
	@Scheduled(fixedRate = 5000)
public void scheduledfirst() {
	System.out.println("this is the sechedual task================================");	
}
	@Scheduled(fixedRate = 5000)
public void scheduledfirst3() {
	System.out.println("this is the sechedual task=========3333333333333333=======================");	
}
	//fixedDelay this will executing if above task finish after 5 second
	@Scheduled(fixedDelay =5000)
public void scheduledfirst2() {
	System.out.println("this is the sechedual task============fixedDelay====================");	
}
/*Seconds Minutas Hours DayOfMonth month DayOfWeek	
 * her is 6 parameter 
 * 0-> it will run on zero second
 * 35-> this willrun on 35 second
 * 12-> this is run on 12 o clock , here time will calculate 24 hours
 * *--> indicate every day
 * *-->indicate every month
 * ? --> no specification dayofweek , so it will run every week
 * */
	@Scheduled(cron ="0 35 12 * * ?" )
public void scheduledfirst4() {
	System.out.println("this is the sechedual task============Sechudel====================");	
}	
}
