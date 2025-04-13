package com.example.demo.configrationp;

import java.util.HashMap;

import javax.sql.DataSource;

import org.hibernate.mapping.Map;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import com.example.demo.dao.Productrepo;

import com.example.demo.entity.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
@Configuration
//@EnableBatchProcessing
public class BatchConfig {

	@Bean
	public Job job(JobRepository jobRepository,
			JobCompletNotificationImp jobListner,Step steps,Step steps1  ) {
		return new JobBuilder("Job1", jobRepository)
		.listener(jobListner)
		.start(steps)
		.next(steps1)
		.build();
	}
	
	@Bean
	public Step steps(JobRepository jobRepository
			,FlatFileItemReader reader,
			ItemProcessor itemProcessor, 
			RepositoryItemWriter<Product> itemWriter,
			PlatformTransactionManager platformTransactionManager) {
		
		return new StepBuilder("JobStep", jobRepository)
				.<Product,Product>chunk(5,platformTransactionManager)
				.reader(reader)
				.processor(itemProcessor)
				.writer(itemWriter)
				.build();
	}
	@Bean
	public Step steps1(JobRepository jobRepository
			,RepositoryItemReader readerre1,
			ItemProcessor itemProcessor, 
			JsonItemWriter jsonItemWriter,
			PlatformTransactionManager platformTransactionManager) {
		
		return new StepBuilder("JobStep1", jobRepository)
				.<Product,Product>chunk(5,platformTransactionManager)
				.reader(readerre1)
				.processor(itemProcessor)
				.writer(jsonItemWriter)
				.build();
	}
		
	 @Bean
	    public RepositoryItemReader<Product> readerre1(Productrepo Productrepo) {
		 RepositoryItemReader<Product> reader = new RepositoryItemReader<>();
	        reader.setRepository(Productrepo);
	        reader.setMethodName("findAll");
	        reader.setPageSize(10);
	        HashMap sortMap;
	        
	            sortMap = new HashMap();
	            ((java.util.Map) sortMap).put("productId", Sort.Direction.ASC);
	        
	        reader.setSort(sortMap);
	        return reader;
	    }	
	
	 @Bean
	    public JsonItemWriter jsonItemWriter() {
	        return new JsonItemWriter("products.json");
	    }
@Bean
public 	FlatFileItemReader<Product> reader(){
	return new FlatFileItemReaderBuilder<Product>()
			.name("itemReader")
			.resource(new ClassPathResource("data.csv"))
			.linesToSkip(1)
			.delimited()
			.delimiter(",")
			.names("productId","itle","description","price","descount")
			.targetType(Product.class)
			.build();	
}
/*here ItemProcesser taking 2 value as genric
first is inputtype and second is output type 
we can define bothin diffrent 
this is interface that why we provide CustomerItem implementation

*/ 
@Bean
public ItemProcessor<Product, Product> itemProcessor(){
	return new CustomerItem();
}

//@Bean
//public ItemWriter<Product> itemWriter(){
//	return new JpaItemWriter<>();
//	
//}

@Bean
public RepositoryItemWriter<Product> writer(Productrepo Productrepo){

	RepositoryItemWriter<Product> itemWriter=new RepositoryItemWriter<Product>();
	itemWriter.setRepository(Productrepo);
	itemWriter.setMethodName("save");
	return itemWriter;
}
	
}
