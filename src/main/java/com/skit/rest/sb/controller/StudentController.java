package com.skit.rest.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.skit.rest.sb.model.Student;
import com.skit.rest.sb.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/students")
@CrossOrigin()
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping
	public Student save(@RequestBody Student student) {
		log.info("request student: {}", student);
		studentService.save(student);
		return student;
	}
	
	@GetMapping
	// @RequestMapping(value="/", method = RequestMethod.GET)
	public List<Student> getAll() {
		List<Student> students =  studentService.getAllStudent();
		log.info("request student: {}", students);
		return students;
	}

	@GetMapping("/{id}")
	// @RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Student getById(@PathVariable int id) {
		Student fetchedStudent = studentService.getById(id);
		log.info("request id {}, student:  {}",id,  fetchedStudent);
		return fetchedStudent;
	}
	
	@PutMapping("/{id}")
	// @RequestMapping(value="/", method = RequestMethod.PUT)
	public Student update(@RequestBody Student student, @PathVariable int id) {
		studentService.save(student);		
		return student;
	}

	@DeleteMapping("/{id}")
	// @RequestMapping(value="/", method = RequestMethod.DELETE)
	public String deleteById(@PathVariable int id) {
		studentService.delete(id);
		return "";
	}
	
	

	
}
