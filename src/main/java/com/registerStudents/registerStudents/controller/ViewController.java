package com.registerStudents.registerStudents.controller;

import com.registerStudents.registerStudents.data.AnaliseEntity;
import com.registerStudents.registerStudents.data.AlunoEntity;
import com.registerStudents.registerStudents.service.AnaliseService;
import com.registerStudents.registerStudents.service.AlunoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping("/") 
public class ViewController {
    @Autowired
    AlunoService alunoService;

    @Autowired
    AnaliseService analiseService;

    @GetMapping("/")
    public String listarAlunos(Model model, HttpServletRequest request) {
        model.addAttribute("alunos", alunoService.listarAlunos());
        return "listaAlunos.html";
    }

    @GetMapping("/novoAluno")
    public String novoAlunoForm(Model model, HttpServletRequest request) {
        model.addAttribute("aluno", new AlunoEntity());
        return "novoAluno.html";
    }

    @GetMapping("/detalhes/{id}")
    public String detalhesAluno(@PathVariable Integer id, Model model, HttpServletRequest request) {
        model.addAttribute("aluno", alunoService.getAlunoById(id));
        model.addAttribute("analises", analiseService.getAnalisesByAlunoId(id));
        model.addAttribute("novaAnalise", new AnaliseEntity());
        return "detalhesAluno.html";
    }
}
