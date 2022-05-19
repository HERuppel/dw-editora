package com.editora.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.editora.demo.entity.Artigo;

@Repository
public interface ArtigoRepository extends JpaRepository<Artigo, Long> { }
