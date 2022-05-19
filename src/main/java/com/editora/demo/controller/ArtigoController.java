package com.editora.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.editora.demo.entity.Artigo;
import com.editora.demo.repository.ArtigoRepository;

@RestController
@RequestMapping("/api/artigos")
public class ArtigoController {
  @Autowired
  private ArtigoRepository _artigoRepository;

  @PostMapping() // CRIAR
  public Artigo Post(@RequestBody Artigo artigo) {
      return _artigoRepository.save(artigo);
  }

  @GetMapping() // LISTAR TODOS
  public List<Artigo> Get() {
      return _artigoRepository.findAll();
  }

  @GetMapping("/{id}") // RECUPERAR POR ID
  public ResponseEntity<Artigo> GetById(@PathVariable("id") long id) {
    Optional<Artigo> artigo = _artigoRepository.findById(id);
    if(artigo.isPresent())
        return new ResponseEntity<Artigo>(artigo.get(), HttpStatus.OK);
    else
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PutMapping("/{id}") // ATUALIZAR POR ID
  public ResponseEntity<Artigo> Put(@PathVariable("id") long id, @RequestBody Artigo newArtigo) {
      Optional<Artigo> oldArtigo = _artigoRepository.findById(id);
      if(oldArtigo.isPresent()) {
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

  @DeleteMapping("/{id}") // DELETAR POR ID
  public ResponseEntity<Object> DeleteById(@PathVariable("id") long id) {
      Optional<Artigo> artigo = _artigoRepository.findById(id);
      if(artigo.isPresent()){
          _artigoRepository.delete(artigo.get());
          return new ResponseEntity<>(HttpStatus.OK);
      }
      else
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @DeleteMapping() // DELETAR POR ID
  public ResponseEntity<Object> Delete() {
    _artigoRepository.deleteAll();;
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping("/publicados") // LISTAR TODOS OS PUBLICADOS
  public List<Artigo> GetPublished() {
      return _artigoRepository.findPublished();
  }

}
