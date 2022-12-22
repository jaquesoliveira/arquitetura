package com.arquitetura.infra.spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arquitetura.infra.entity.EditoraEntityDb;

@Repository
public interface EditoraRepositorySpring extends JpaRepository <EditoraEntityDb, Long> {

}
