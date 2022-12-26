package com.arquitetura.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.arquitetura.infra.repository.EditoraDomainRepositoryImpl;
import com.arquitetura.infra.spring.EditoraRepositorySpring;

@Configuration
public class EditoraConfiguration {

	@Bean
	EditoraDomainRepositoryImpl editoraDomainRepositoryImpl(EditoraRepositorySpring repositorySpring) {
		return new EditoraDomainRepositoryImpl(repositorySpring);
	}
}
