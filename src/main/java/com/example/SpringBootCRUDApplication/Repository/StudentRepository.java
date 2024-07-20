package com.example.SpringBootCRUDApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.SpringBootCRUDApplication.Student.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
