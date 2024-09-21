package com.registerStudents.registerStudents.controller;

import com.registerStudents.registerStudents.data.AlunoEntity;
import com.registerStudents.registerStudents.service.AlunoService;

import java.util.List; 
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.PutMapping; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.servlet.ModelAndView;

@RestController 
@RequestMapping("/aluno") 

public class AlunoController {
    @Autowired
    AlunoService alunoService;
    
    @GetMapping("/listar")
     public ResponseEntity<List> getAllAlunos() {
        List<AlunoEntity> alunos = alunoService.listarAlunos();

        return new ResponseEntity<>(alunos, HttpStatus.OK);
    }
     
    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<AlunoEntity> getAlunoById(@PathVariable Integer id) {
        AlunoEntity aluno = alunoService.getAlunoById(id);
        
        return new ResponseEntity<>(aluno, HttpStatus.OK);
    }
    
    @PostMapping("/adicionar")
    public ModelAndView  addAluno(@ModelAttribute AlunoEntity aluno) {
        alunoService.criarAluno(aluno); 

        return new ModelAndView("redirect:/");
    }
    
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<AlunoEntity> atualizarAluno(@PathVariable Integer id, @RequestBody AlunoEntity aluno) {
        var alunoAtualizado = alunoService.atualizarAluno(id, aluno); 
        
        return new ResponseEntity<>(alunoAtualizado, HttpStatus.OK);
    } 
    
    @DeleteMapping("/deletar/{id}") 
    public ResponseEntity deletarAluno(@PathVariable Integer id) { 
        alunoService.deletarAluno(id); 
        
        return new ResponseEntity<>(HttpStatus.OK); 
    } 
}
