package com.registerStudents.registerStudents;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.Optional;

import com.registerStudents.registerStudents.data.AlunoEntity; 
import com.registerStudents.registerStudents.data.AlunoRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.dao.DataIntegrityViolationException;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@Transactional
public class AlunoRepositoryEditTest {

    @Autowired
    private AlunoRepository alunoRepository;

    private AlunoEntity aluno;

    @BeforeEach
    public void setUp() {
        aluno = new AlunoEntity();
        aluno.setNome("João");
        aluno.setSerie("5ª Série");
        aluno.setDataNascimento("01/01/2010");
        alunoRepository.save(aluno);
    }

    @Test
    public void testEditarAluno() {
        Optional<AlunoEntity> alunoOptional = alunoRepository.findById(aluno.getId());
        assertTrue(alunoOptional.isPresent());

        AlunoEntity alunoEditado = alunoOptional.get();
        alunoEditado.setNome("João Editado");
        alunoEditado.setSerie("6ª Série");
        alunoRepository.save(alunoEditado);

        AlunoEntity alunoSalvo = alunoRepository.findById(alunoEditado.getId()).get();
        assertEquals("João Editado", alunoSalvo.getNome());
        assertEquals("6ª Série", alunoSalvo.getSerie());
    }
}
