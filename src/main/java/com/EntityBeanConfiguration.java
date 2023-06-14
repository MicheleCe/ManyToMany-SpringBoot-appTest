package com;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.entity.Course;
import com.entity.Student;

@Configuration
public class EntityBeanConfiguration {

	@Bean(name = "getStudent")
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Student getStudent() {
		return new Student();
	}

	@Bean(name = "getCourse")
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Course getCourse() {
		return new Course();
	}
}

// Per mettere lo scope = prototype
// @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)