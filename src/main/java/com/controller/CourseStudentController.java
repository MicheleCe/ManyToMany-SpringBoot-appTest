package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Course;
import com.entity.Student;
import com.service.CourseService;
import com.service.StudentService;
import com.vo.CourseStudentVO;

@CrossOrigin(origins = { "http://127.0.0.1:5500" })
@RequestMapping("/api/v1")
@RestController
public class CourseStudentController {

	@Autowired
	private CourseService cs;

	@Autowired
	private StudentService ss;

	@GetMapping("/coursestudent")
	public List<CourseStudentVO> getCoursesReviews() {
		return cs.findCourseStudent();
	}

	@GetMapping("/coursestudent/{studentId}")
	public List<CourseStudentVO> findCourseStudentByStudentId(@PathVariable("studentId") Integer studentId) {
		return cs.findCourseStudentByStudentId(studentId);
	}

	@GetMapping("/findAllStudent")
	public List<Student> finAllStudents() {
		return ss.findAll();
	}

	@GetMapping("/findAllCourses")
	public List<Course> finAllCourses() {
		return cs.findAll();
	}

//	@PostMapping(value = "/students", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//	@ResponseBody
//	public void save(@ModelAttribute Student student) {
//		ss.save(student);
//	}

	@PostMapping(value = "/students", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void save(@RequestBody Student student) {
		System.out.println(student);
		ss.save(student);
	}

	@PostMapping(value = "/courses", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void save(@RequestBody Course course) {
		System.out.println(course);
		cs.save(course);
	}

	@DeleteMapping("/students/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
		ss.deleteById(id);
		return ResponseEntity.noContent().build();
	}

//	@PostMapping("api/v1/coursestudent/{studentId}/{courseId}")
//	public ResponseEntity<Void> addCourseToStudent(@PathVariable("studentId") Integer studentId,
//			@PathVariable("courseId") Integer courseId) {
//		// Call the service layer to add the course to the student
//		ss.addCourseToStudent(studentId, courseId);
//		return ResponseEntity.ok().build();

	@PostMapping(value = "/coursestudent/{studentId}/{courseId}")
	public void addCourseToStudent(@PathVariable("studentId") Integer studentId,
			@PathVariable("courseId") Integer courseId) {
		ss.addCourseToStudent(studentId, courseId);
	}

	@DeleteMapping(value = "/removeCourseStudentRelation/{studentId}/{courseId}")
	public void removeCourseStudentRelation(@PathVariable("studentId") Integer studentId,
			@PathVariable("courseId") Integer courseId) {
		ss.removeCourseStudentRelation(studentId, courseId);
	}

	@GetMapping("/findByLastnameOrFirstname/{studentNameOrLastName}")
	public List<Student> findByLastnameOrFirstname(
			@PathVariable("studentNameOrLastName") String studentNmaeOrLastName) {
		return ss.findByLastNameOrFirstName(studentNmaeOrLastName);
	}

	@PutMapping(value = "/student/name/{studentId}/{newName}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void saveStudentName(@PathVariable("studentId") Integer studentId,
			@PathVariable("newName") String studentName) {
		Optional<Student> studentOptional = ss.findById(studentId);
		try {
			if (studentOptional.isPresent()) {
				Student student = studentOptional.get();
				student.setFirstName(studentName);
				ss.save(student);
			} else {
				System.out.println("studente non trovato");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@PutMapping(value = "/student/lastname/{studentId}/{newNamLastName}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void saveStudentLastName(@PathVariable("studentId") Integer studentId,
			@PathVariable("newNamLastName") String studentLastName) {
		Optional<Student> studentOptional = ss.findById(studentId);
		try {
			if (studentOptional.isPresent()) {
				Student student = studentOptional.get();
				student.setLastName(studentLastName);
				ss.save(student);
			} else {
				System.out.println("studente non trovato");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
