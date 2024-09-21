package com.registerStudents.registerStudents;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.dao.DataIntegrityViolationException;
import java.util.Optional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;


import com.registerStudents.registerStudents.data.AlunoEntity; 
import com.registerStudents.registerStudents.data.AlunoRepository;
import jakarta.transaction.Transactional;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
public class AlunoRepositoryTest {

    @Autowired
    private AlunoRepository alunoRepository;

    private AlunoEntity aluno;

    @BeforeEach
    public void setUp() {
        aluno = new AlunoEntity();
        aluno.setNome("João");
        aluno.setSerie("5ª Série");
        aluno.setDataNascimento("01/01/2010");
    }

    @Test
    public void testSalvarAlunoComCamposPreenchidosCorretamente() {
        AlunoEntity savedAluno = alunoRepository.save(aluno);
        assertNotNull(savedAluno.getId());
        assertEquals("João", savedAluno.getNome());
        assertEquals("5ª Série", savedAluno.getSerie());
        assertEquals("01/01/2010", savedAluno.getDataNascimento());
    }


@Test
public void testValidarFormatoDataDeNascimento() {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    
    aluno.setDataNascimento("31-12-2010");

    Set<ConstraintViolation<AlunoEntity>> violations = validator.validate(aluno);
    
    assertFalse(violations.isEmpty(), "Esperava violações devido ao formato inválido de data.");
    
    violations.forEach(violation -> {
        assertTrue(violation.getMessage().contains("Data de nascimento deve estar no formato dd/MM/yyyy"));
    });
}

@Test
public void testSalvarAlunoComDadosInvalidos() {
    // Configurar o validator
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    
    aluno.setNome("12345"); // Nome inválido (por exemplo, só números)
    
    // Executa a validação manual
    Set<ConstraintViolation<AlunoEntity>> violations = validator.validate(aluno);
    
    // Verifica se há violações
    assertFalse(violations.isEmpty(), "Esperava violações devido a dados inválidos no nome.");
    
    violations.forEach(violation -> {
        assertTrue(violation.getMessage().contains("Nome inválido"), "A mensagem de erro esperada não foi encontrada.");
    });
}

@Test
public void testDuplicacaoDeDados() {
    AlunoEntity savedAluno1 = alunoRepository.save(aluno);

    // Crie uma nova instância com os mesmos dados
    AlunoEntity aluno2 = new AlunoEntity();
    aluno2.setNome(aluno.getNome());
    aluno2.setSerie(aluno.getSerie());
    aluno2.setDataNascimento(aluno.getDataNascimento());
    
    AlunoEntity savedAluno2 = alunoRepository.save(aluno2);
    
    assertNotEquals(savedAluno1.getId(), savedAluno2.getId());
}

}
