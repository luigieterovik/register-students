package com.registerStudents.registerStudents.data;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository; 

@Repository 
public interface AlunoRepository extends JpaRepository<AlunoEntity, Integer> {

} 
