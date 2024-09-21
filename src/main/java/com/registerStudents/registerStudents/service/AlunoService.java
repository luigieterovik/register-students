package com.registerStudents.registerStudents.service;

import com.registerStudents.registerStudents.data.AlunoEntity;
import com.registerStudents.registerStudents.data.AlunoRepository;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated // Permite validação em métodos
public class AlunoService {
    
    @Autowired
    private AlunoRepository alunoRepository;
    
    public List<AlunoEntity> listarAlunos() {
        return alunoRepository.findAll();
    }
    
    public AlunoEntity getAlunoById(Integer id) {
        return alunoRepository.findById(id).orElse(null);
    }
    
    public AlunoEntity criarAluno(@Valid AlunoEntity aluno) { // Validação aqui
        return alunoRepository.save(aluno);
    }
    
    public AlunoEntity atualizarAluno(Integer id, @Valid AlunoEntity atualizacaoAluno) { // Validação aqui
        AlunoEntity aluno = getAlunoById(id);
        
        if (aluno != null) {
            aluno.setNome(atualizacaoAluno.getNome());
            aluno.setSerie(atualizacaoAluno.getSerie());
            aluno.setDataNascimento(atualizacaoAluno.getDataNascimento());
            return alunoRepository.save(aluno);
        }
        
        return null; // ou lance uma exceção se preferir
    }
    
    public void deletarAluno(Integer id) {
        alunoRepository.deleteById(id);
    }
}
