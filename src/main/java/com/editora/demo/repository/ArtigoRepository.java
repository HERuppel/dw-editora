package com.editora.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.editora.demo.entity.Artigo;

@Repository
public interface ArtigoRepository extends JpaRepository<Artigo, Long> { 

  // @Query(value = "select * from artigo where status = true", nativeQuery = true)
  // public List<Artigo> findPublished();

  // @Query(value = "select * from artigo where titulo like %:titulo%", nativeQuery = true)
  // public List<Artigo> findByKeyword(@Param("titulo") String titulo);
  public List<Artigo> findPublished(boolean published);

  public List<Artigo> findByKeyword(String titulo);
}
