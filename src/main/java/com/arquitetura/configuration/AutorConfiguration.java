package com.arquitetura.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.arquitetura.application.facade.AutorFacade;
import com.arquitetura.infra.repository.AutorDomainRepositoryImpl;
import com.arquitetura.infra.spring.AutorRepositorySpring;

@Configuration
public class AutorConfiguration {
	
	@Bean
	AutorFacade autorFacade(AutorDomainRepositoryImpl autorRepositoryImpl) {
		return new AutorFacade(autorRepositoryImpl);
	}
	
	@Bean
	AutorDomainRepositoryImpl autorDomainRepositoryImpl(AutorRepositorySpring repositorySpring) {
		return new AutorDomainRepositoryImpl(repositorySpring);
	}
}
