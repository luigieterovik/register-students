package com.registerStudents.registerStudents;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;

import com.registerStudents.registerStudents.data.AlunoEntity; 
import com.registerStudents.registerStudents.data.AlunoRepository;

@DataJpaTest
public class AlunoRepositoryListTest {

    @Autowired
    private AlunoRepository alunoRepository;

    private AlunoEntity aluno1;
    private AlunoEntity aluno2;

    @BeforeEach
    public void setUp() {
        aluno1 = new AlunoEntity();
        aluno1.setNome("João");
        aluno1.setSerie("5ª Série");
        aluno1.setDataNascimento("01/01/2010");

        aluno2 = new AlunoEntity();
        aluno2.setNome("Maria");
        aluno2.setSerie("6ª Série");
        aluno2.setDataNascimento("15/03/2009");

        alunoRepository.save(aluno1);
        alunoRepository.save(aluno2);
    }

    @Test
    public void testListarAlunosCadastrados() {
        List<AlunoEntity> alunos = alunoRepository.findAll();
        assertEquals(2, alunos.size());
    }

    @Test
    public void testListarAlunosComBancoVazio() {
        alunoRepository.deleteAll();
        List<AlunoEntity> alunos = alunoRepository.findAll();
        assertTrue(alunos.isEmpty());
    }
}
