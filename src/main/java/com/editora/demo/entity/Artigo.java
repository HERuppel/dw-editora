package com.editora.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Artigo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(nullable = false)
  private String titulo;

  @Column(nullable = false)
  private String resumo;

  @Column(nullable = false)
  private Boolean status;

  public long getId() {
      return id;
  }

  public String getTitulo() {
      return titulo;
  }

  public void setTitulo(String titulo) {
      this.titulo = titulo;
  }

  public String getResumo() {
      return resumo;
  }

  public void setResumo(String resumo) {
      this.resumo = resumo;
  }

  public Boolean getStatus() {
      return status;
  }

  public void setStatus(Boolean status) {
      this.status = status;
  }

  public void setId(long id) {
      this.id = id;
  }
}
