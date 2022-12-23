package com.arquitetura.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.arquitetura.application.facade.AutorFacade;
import com.arquitetura.infra.repository.AutorDomainRepositoryImpl;

@Configuration
public class AutorFacadeConfig {
	
	@Bean
	AutorFacade autorFacade(AutorDomainRepositoryImpl autorRepositoryImpl) {
		return new AutorFacade(autorRepositoryImpl);
	}	
}
