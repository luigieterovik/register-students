package com.registerStudents.registerStudents.data;

import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Id; 
import jakarta.persistence.Table; 
import lombok.Data; 

@Data 
@Entity 
@Table(name="analise") 
public class AnaliseEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Integer id;
    private Integer alunoId;
    private String analise;
    private String nota;
}
