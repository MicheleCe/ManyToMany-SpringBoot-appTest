package com.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.entity.Course;
import com.repository.CourseRepository;
import com.vo.CourseStudentVO;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository cr;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void save(Course course) {
		try {
			cr.save(course);
			log.info("Save riuscito.");
		} catch (IllegalArgumentException | OptimisticLockingFailureException e) {
			log.info("Save fallito.");
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(Integer courseId) {
		if (cr.existsById(courseId)) {
			try {
				cr.deleteById(courseId);
				log.info("Corso eliminato.");
			} catch (IllegalArgumentException iae) {
				log.info("Corso non eliminato.");
				iae.printStackTrace();
			}
		} else {
			log.info("Corso non trovato.");
		}
	}

	@Override
	public List<Course> findAll() {
		List<Course> courses = cr.findAll();
		if (courses != null && !courses.isEmpty()) {
			log.info("Corsi trovati.");
			courses.forEach(System.out::println);
		} else {
			log.info("Corsi non trovati.");
		}
		return courses;
	}

	@Override
	public List<CourseStudentVO> findCourseStudent() {
		List<CourseStudentVO> coursesStudents = cr.findCourseStudent();
		if (coursesStudents != null && !coursesStudents.isEmpty()) {
			log.info("Corsi trovati.");
			coursesStudents.forEach(System.out::println);
		} else {
			log.info("Corsi non trovati.");
		}
		return coursesStudents;
	}

	@Override
	public List<CourseStudentVO> findCourseStudentByStudentId(Integer studentId) {
		List<CourseStudentVO> coursesStudents = cr.findCourseStudentByStudentId(studentId);
		if (coursesStudents != null && !coursesStudents.isEmpty()) {
			log.info("Corsi trovati.");
			coursesStudents.forEach(System.out::println);
		} else {
			log.info("Corsi non trovati.");
		}
		return coursesStudents;
	}

}
