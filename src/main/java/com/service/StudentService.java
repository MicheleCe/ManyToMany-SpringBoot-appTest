package com.service;

import java.util.List;
import java.util.Optional;

import com.entity.Student;

public interface StudentService {

	public void save(Student student);

	public List<Student> findAll();

	public void deleteById(Integer studentId);

	public void addCourseToStudent(Integer studentId, Integer courseId);

	public void removeCourseStudentRelation(Integer studentId, Integer courseId);

	public List<Student> findByLastNameOrFirstName(String studentNameOrLastName);

	public Optional<Student> findById(Integer studentId);
}
