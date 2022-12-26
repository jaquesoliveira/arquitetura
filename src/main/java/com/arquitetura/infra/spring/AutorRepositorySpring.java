package com.arquitetura.infra.spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arquitetura.infra.entities.AutorEntityDb;

@Repository
public interface AutorRepositorySpring extends JpaRepository<AutorEntityDb, Long>{

}
