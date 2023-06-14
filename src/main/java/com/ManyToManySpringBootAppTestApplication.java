package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.entity.Course;
import com.entity.Student;
import com.service.CourseService;
import com.service.StudentService;

import jakarta.annotation.Resource;

@SpringBootApplication
public class ManyToManySpringBootAppTestApplication implements CommandLineRunner {

	@Autowired
	private CourseService cs;

	@Autowired
	private StudentService ss;

	@Resource
	private Student s1;

	@Resource
	private Student s2;

	@Resource
	private Student s3;

	@Resource
	private Student s4;

	@Resource
	private Course c1;

	@Resource
	private Course c2;

	@Resource
	private Course c3;

	@Resource
	private Course c4;

	public static void main(String[] args) {
		SpringApplication.run(ManyToManySpringBootAppTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		s1.setFirstName("Roberto");
		s1.setLastName("Graffeo");

		s2.setFirstName("Marco");
		s2.setLastName("Rossi");

		s3.setFirstName("Marco");
		s3.setLastName("Verdi");

		c1.setTitle("Java 1");
		c1.setDescription("Corso Java 1");
		c2.setTitle("Python");
		c2.setDescription("Corso Python 1");
		c3.setTitle("Java 2");
		c3.setDescription("Corso Java 2");

		s1.getCourses().add(c1);
		s2.getCourses().add(c1);
		s3.getCourses().add(c1);

		cs.save(c1);
		cs.save(c2);
		cs.save(c3);
		ss.save(s1);
		ss.save(s2);
		ss.save(s3);

		ss.addCourseToStudent(1, 1);
		cs.findAll();
		ss.findAll();

//		ss.removeCourseStudentRelation(3, 1);

		ss.findByLastNameOrFirstName("Marco").forEach(System.err::println);

		;
	}

}
