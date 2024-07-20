package com.example.SpringBootCRUDApplication.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootCRUDApplication.Repository.StudentRepository;
import com.example.SpringBootCRUDApplication.Student.Student;


@RestController
public class StudentController {
	
	@Autowired
	StudentRepository studentRepo;
	
	//Get all student data from here
	//http://localhost:8080/students
	@GetMapping("/students")
	public List<Student> getAllDataList(){
		return studentRepo.findAll();
	}
	
	//Get one student data by id from here
	//http://localhost:8080/students/id
	@GetMapping("/students/{id}")
	public ResponseEntity<Optional<Student>> getDataById(@PathVariable Long id){
		
			Optional<Student> studentData = studentRepo.findById(id);
		
			if(studentData.isPresent()) {
				return ResponseEntity.status(HttpStatus.FOUND).body(studentData);
			}else {
				throw new RuntimeException("Student id is not present in the system");
			}
	}
	
	//New student Data get added from here
	//http://localhost:8080/students/addstudent
	@PostMapping("/students/addstudent")
	public ResponseEntity<Student> addStudentData(@RequestBody Student student){
		Student bookObj = studentRepo.save(student);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(bookObj);
	}
	
	//Student data get updated by id from here
	//http://localhost:8080/students/update/id
	@PostMapping("/students/update/{id}")
	public Student updateStudentDataById(@PathVariable Long id,  @RequestBody Student student){
		
		Optional<Student> oldStudentData = studentRepo.findById(id);
		
		if(oldStudentData.isPresent()) {
			Student newStudentData = oldStudentData.get(); 
			
			newStudentData.setName(student.getName());
			newStudentData.setAddress(student.getAddress());
			newStudentData.setCity(student.getCity());
			newStudentData.setPercentage(student.getPercentage());
			newStudentData.setRollNo(student.getRollNo());
			
			return studentRepo.save(newStudentData);
		}else {
			throw new RuntimeException("Student id is not present in the system");
		}
	}
	
	//delete student data by id performed from this method
	//http://localhost:8080/delete/id
	@DeleteMapping("/students/delete/{id}")
	public ResponseEntity<String> deleteStudentData(@PathVariable Long id){
		
		Optional<Student> oldStudentData = studentRepo.findById(id);
		if(oldStudentData.isPresent()) {
			studentRepo.deleteById(id);
			return ResponseEntity.status(HttpStatus.FOUND).body("Data is deleted successfully on this id: "+id);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data is not present on this id: "+id);
		}
	}
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(code= HttpStatus.NOT_FOUND)
	public String runTimeExceptionhandler(Exception ex) {
		return ex.getMessage();
		
	}
	

}
