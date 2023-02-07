package com.skit.rest.sb.repository;

import org.springframework.data.repository.CrudRepository;

import com.skit.rest.sb.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
