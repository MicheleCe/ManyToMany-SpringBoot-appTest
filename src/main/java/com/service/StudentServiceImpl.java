package com.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.entity.Student;
import com.repository.CourseRepository;
import com.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository sr;
	@Autowired
	private CourseRepository cr;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void save(Student student) {
		try {
			sr.save(student);
			log.info("Save riuscito.");
		} catch (IllegalArgumentException | OptimisticLockingFailureException e) {
			log.info("Save fallito.");
			e.printStackTrace();
		}

	}

	@Override
	public List<Student> findAll() {
		List<Student> students = sr.findAll();
		if (students != null && !students.isEmpty()) {
			log.info("Studenti trovati.");
			students.forEach(System.out::println);
		} else {
			log.info("Studenti non trovati.");
		}
		return students;
	}

	@Override
	public void deleteById(Integer studentId) {
		if (sr.existsById(studentId)) {
			try {
				sr.deleteById(studentId);
				log.info("Studente eliminato.");
			} catch (IllegalArgumentException iae) {
				log.info("Studente non eliminato.");
				iae.printStackTrace();
			}
		} else {
			log.info("Studente non trovato.");
		}
	}

//	public void addCourseToStudent(Integer studentId, Integer courseId) {
//		// Get the student with the specified ID
//		try {
//			Student student = sr.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
//
//			// Get the course with the specified ID
//			Course course = cr.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
//
//			// Add the course to the student's list of courses
//			student.getCourses().add(course);
//
//			// Save the updated student
//			sr.save(student);
//		} catch (IllegalArgumentException iae) {
//			log.info("Studente non eliminato.");
//			iae.printStackTrace();
//		}
//
//	}

	public void addCourseToStudent(Integer studentId, Integer courseId) {
		sr.addCourseToStudent(studentId, courseId);
	}
//
//	public void removeCourseFromStudent(Integer ) {
//		
//	}

	@Override
	public void removeCourseStudentRelation(Integer studentId, Integer courseId) {
		sr.removeCourseStudentRelation(studentId, courseId);

	}

	@Override
	public List<Student> findByLastNameOrFirstName(String studentNameOrLastName) {
		return sr.findByLastNameOrFirstName(studentNameOrLastName);
	}

	@Override
	public Optional<Student> findById(Integer studentId) {
		return sr.findById(studentId);
	}

//	@Override
//	public void removeCourseStudentRelation(Integer studentId, Integer courseId) {
//		Optional<Student> relatedStudent = sr.findById(studentId);
//		relatedStudent.get().getCourses().forEach(e -> {
//			if (e.getCourseId() == courseId) {
//				relatedStudent.get().getCourses().remove(e);
//			}
//		});
//		sr.save(relatedStudent.get());
//	}

}
