package com.registerStudents.registerStudents.data;

import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Id; 
import jakarta.persistence.Table; 
import jakarta.validation.constraints.NotNull; 
import jakarta.validation.constraints.Pattern;
import lombok.Data; 

@Data 
@Entity 
@Table(name = "aluno") 
public class AlunoEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Integer id;

@NotNull(message = "Nome é obrigatório")
@Pattern(regexp = "^[A-Za-zÀ-ÿ\\s]+$", message = "Nome inválido, deve conter apenas letras")
private String nome;


        @NotNull
    private String serie;
        
        @NotNull
            @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "Data de nascimento deve estar no formato dd/MM/yyyy")
    private String dataNascimento;
}
