package com.editora.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.editora.demo.entity.Artigo;
import com.editora.demo.repository.ArtigoRepository;

@RestController
public class ArtigoController {
  @Autowired
  private ArtigoRepository _artigoRepository;

  @RequestMapping(value = "/api/artigos", method = RequestMethod.GET)
  public List<Artigo> Get() {
      return _artigoRepository.findAll();
  }

  @RequestMapping(value = "/api/artigos", method =  RequestMethod.POST)
  public Artigo Post(@RequestBody Artigo artigo)
  {
      return _artigoRepository.save(artigo);
  }
}
