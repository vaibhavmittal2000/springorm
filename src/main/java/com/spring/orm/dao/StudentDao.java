package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;
import com.spring.orm.entities.Student;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	
	//Save Student(Insert Data)
	@Transactional
	public int insert(Student student) {
		Integer i =(Integer)this.hibernateTemplate.save(student);
		return i;
	}
	
	//Get Single Data(Object)
	public Student getStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class,studentId);
		return student;
	}
	
	//Get all Data(all students)
	public List<Student> getAllStudents(){
		List<Student> students= this.hibernateTemplate.loadAll(Student.class);
		return students;
	}
	
	//Deleting the data
	@Transactional
	public void deleteStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class,studentId);
		this.hibernateTemplate.delete(student);
	}
	
	//Update the data
	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}