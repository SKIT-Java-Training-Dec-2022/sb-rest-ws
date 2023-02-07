package com.skit.rest.sb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skit.rest.sb.model.Student;
import com.skit.rest.sb.repository.StudentRepository;


@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> getAllStudent(){
		List<Student> students =  (List<Student>) studentRepository.findAll();
		for(Student st: students) {
			String name = st.getFname() + " "+st.getLname();
			st.setName(name);
		}
		return students;
	}

	public Student getById(int id) {
		Optional<Student> record = studentRepository.findById(id);
		if(record.isPresent()) {
			Student st =record.get();
			st.setName(st.getFname()+" "+st.getLname());
			return record.get();
		}else {
			return null;
		}
	}

	public void save(Student student) {
		studentRepository.save(student);		
	}

	public void delete(int id) {
		studentRepository.deleteById(id);
	}

}
