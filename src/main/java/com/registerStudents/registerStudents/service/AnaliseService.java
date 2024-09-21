package com.registerStudents.registerStudents.service;

import com.registerStudents.registerStudents.data.AnaliseEntity;
import com.registerStudents.registerStudents.data.AnaliseRepository;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 

@Service
public class AnaliseService {
    
    @Autowired
   AnaliseRepository analiseRepository;
    
    public List<AnaliseEntity> listarAnalises() {
        return analiseRepository.findAll();
    }
    
    public AnaliseEntity getAnaliseById(Integer id) {
        return analiseRepository.findById(id).orElse(null);
    }
    
    public List<AnaliseEntity> getAnalisesByAlunoId(Integer id) {
        return analiseRepository.findByAlunoId(id);
    }
    
    public AnaliseEntity criarAnalise(AnaliseEntity analise) {
        analiseRepository.save(analise);
        
        return analise;
    }
    
    public AnaliseEntity atualizarAnalise(Integer id, AnaliseEntity atualizacaoAnalise) {
        AnaliseEntity analise = getAnaliseById(id);
        
        analise.setAlunoId(atualizacaoAnalise.getAlunoId());
        analise.setAnalise(atualizacaoAnalise.getAnalise());
        analise.setNota(atualizacaoAnalise.getNota());
        
        analiseRepository.save(analise);
        
        return analise;
    }
    
    public void deletarAnalise(Integer id) {
        AnaliseEntity analise = getAnaliseById(id);
        
        analiseRepository.deleteById(analise.getId());
    }
}
