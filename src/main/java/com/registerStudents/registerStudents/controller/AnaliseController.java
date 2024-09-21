package com.registerStudents.registerStudents.controller;

import com.registerStudents.registerStudents.data.AnaliseEntity;
import com.registerStudents.registerStudents.service.AnaliseService;

import java.util.List; 
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
import org.springframework.web.bind.annotation.RestController; 

@RestController 
@RequestMapping("/analise") 

public class AnaliseController {
    @Autowired
    AnaliseService analiseService;
    
    @GetMapping("/listar")
     public ResponseEntity<List> getAllAnalises() {
        List<AnaliseEntity> analises = analiseService.listarAnalises();

        return new ResponseEntity<>(analises, HttpStatus.OK);
    }
     
     @GetMapping("/listarPorAluno/{id}")
     public ResponseEntity<List> getAnalisesByAluno(@PathVariable Integer id) {
         List<AnaliseEntity> analises =analiseService. getAnalisesByAlunoId(id);

        return new ResponseEntity<>(analises, HttpStatus.OK);
     }
     
    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<AnaliseEntity> getAnaliseById(@PathVariable Integer id) {
        AnaliseEntity analise = analiseService.getAnaliseById(id);
        
        return new ResponseEntity<>(analise, HttpStatus.OK);
    }
    
    @PostMapping("/adicionar")
    public ResponseEntity<AnaliseEntity> addAnalise(@RequestBody AnaliseEntity analise) {
        var novoAnalise = analiseService.criarAnalise(analise); 

        return new ResponseEntity<>(novoAnalise, HttpStatus.CREATED);
    }
    
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<AnaliseEntity> atualizarAnalise(@PathVariable Integer id, @RequestBody AnaliseEntity analise) {
        var analiseAtualizado = analiseService.atualizarAnalise(id, analise); 
        
        return new ResponseEntity<>(analiseAtualizado, HttpStatus.OK);
    } 
    
    @DeleteMapping("/deletar/{id}") 
    public ResponseEntity deletarAnalise(@PathVariable Integer id) { 
        analiseService.deletarAnalise(id); 
        
        return new ResponseEntity<>(HttpStatus.OK); 
    } 
}
