package com.display.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

public class JobConfig {
	
	@Value("${filename}")
	String filename ;
	
	@Value("${threadSize}")
	int threads ;
	
	@Bean
	  public Job job(JobBuilderFactory jobBuilders,
	      StepBuilderFactory stepBuilders) {
	    return jobBuilders.get("job")
	        .start(step(stepBuilders)).build();
	  }
	
	@Bean
	public TaskExecutor taskExecutor(){
	    return new SimpleAsyncTaskExecutor("spring_batch");
	}

	  @Bean
	  public Step step(StepBuilderFactory stepBuilders) {
	    return stepBuilders.get("step")
	        .<String, String>chunk(threads).reader(reader())
	        .processor(processor()).taskExecutor(taskExecutor()).build();
	    
	  }

	  @Bean
	  public FlatFileItemReader<String> reader() {
	    return new FlatFileItemReaderBuilder<String>()
	        .name("reader")
	        .resource(new ClassPathResource(filename)).build();
	  }
	  
	  @Bean
	  public ItemsProcessor processor() {
	    return new ItemsProcessor();
	  }


}
