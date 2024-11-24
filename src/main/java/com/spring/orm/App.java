package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App{
    public static void main( String[] args ){
    	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
    	StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
    	
//    	Student student = new Student(1212,"Komal","Bhiwani");
//    	int r = studentDao.insert(student);
//    	System.out.println("done" + r);
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	boolean go = true;
    	while(go) {
    		System.out.println("Press 1 to add new student");
        	System.out.println("Press 2 to display all students");
        	System.out.println("Press 3 to get detail of single student");
        	System.out.println("Press 4 to delete students");
        	System.out.println("Press 5 to update student");
        	System.out.println("Press 6 to exit");
        	
        	try {
        		int input = Integer.parseInt(br.readLine());
        		
        		switch (input) {
				case 1:
					//Add new student
					//Taking input from user
					System.out.println("Enter user ID: ");
					int uId = Integer.parseInt(br.readLine());
					
					System.out.println("Enter user name");
					String uName = br.readLine();
					
					System.out.println("Enter user city");
					String uCity = br.readLine();
					
					//Creating student object and setting values
					Student s = new Student();
					s.setStudentId(uId);
					s.setStudentName(uName);
					s.setStudentCity(uCity);
					
					//Saving student object to database by calling insert method in studentDao
					int r = studentDao.insert(s);
					System.out.println(r + " student added");
					System.out.println("****************************");
					System.out.println();
					break;
				case 2:
					//Display all students
					System.out.println("****************************");
					List<Student> allStudents= studentDao.getAllStudents();
					for(Student st : allStudents) {
						System.out.println("ID: " + st.getStudentId());
						System.out.println("Name: " + st.getStudentName());
						System.out.println("City: " + st.getStudentCity());
						System.out.println("____________________________");
					}
					System.out.println("****************************");
					break;
				case 3:
					//Get detail of single student
					System.out.println("Enter user id: ");
					int userId = Integer.parseInt(br.readLine());
					Student student = studentDao.getStudent(userId);
					System.out.println("ID: " + student.getStudentId());
					System.out.println("Name: " + student.getStudentName());
					System.out.println("City: " + student.getStudentCity());
					System.out.println("____________________________");
					break;
				case 4:
					//Delete students
					System.out.println("Enter user id: ");
					int id = Integer.parseInt(br.readLine());
					studentDao.deleteStudent(id);
					System.out.println("Student deleted..");
					break;
				case 5:
					//Update student
					break;
				case 6:
					//Exit
					go = false;
					break;
				}
        	}
        	catch(Exception e) {
        		System.out.println("Invalid input try new one!!");
        		System.out.println(e.getMessage());
        	}
    	}
    	System.out.println("Thank You!!");
    }
}