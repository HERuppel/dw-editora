package com.editora.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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

  @RequestMapping(value = "/api/artigos", method = RequestMethod.GET) // LISTAR TODOS
  public List<Artigo> Get() {
      return _artigoRepository.findAll();
  }

  @RequestMapping(value = "/api/artigos", method =  RequestMethod.POST) // CRIAR
  public Artigo Post(@RequestBody Artigo artigo)
  {
      return _artigoRepository.save(artigo);
  }

  @RequestMapping(value = "/api/artigos/{id}", method = RequestMethod.GET) // RECUPERAR POR ID
  public ResponseEntity<Artigo> GetById(@PathVariable(value = "id") long id) {
    Optional<Artigo> artigo = _artigoRepository.findById(id);
    if(artigo.isPresent())
        return new ResponseEntity<Artigo>(artigo.get(), HttpStatus.OK);
    else
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value = "/api/artigos/{id}", method =  RequestMethod.PUT)
  public ResponseEntity<Artigo> Put(@PathVariable(value = "id") long id, @RequestBody Artigo newArtigo)
  {
      Optional<Artigo> oldArtigo = _artigoRepository.findById(id);
      if(oldArtigo.isPresent()){
          Artigo artigo = oldArtigo.get();

          artigo.setTitulo(newArtigo.getTitulo());
          artigo.setResumo(newArtigo.getResumo());
          artigo.setStatus(newArtigo.getStatus());

          _artigoRepository.save(artigo);
          return new ResponseEntity<Artigo>(artigo, HttpStatus.OK);
      }
      else
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
