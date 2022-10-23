package com.example.async.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {
	
	@Bean(name="asyncExecutor")
	public Executor asyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(3); // mínimo de hilos que se usaran en la aplicación
		executor.setMaxPoolSize(4); // máximo de hilos que se crearan despues de que estan ocupados los del corePoolSize
		executor.setQueueCapacity(8); // máximo de hilos que pueden ser creados en total y estan a la espera de que puedan ser atendidos
		executor.setThreadNamePrefix("AsyncThread");
		executor.initialize();
		return executor;
	}

}
