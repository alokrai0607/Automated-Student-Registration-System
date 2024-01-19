	package com.StudentManagementSystem.Dao;
	
	import java.util.List;
	
	import com.StudentManagementSystem.Exceptions.CourseException;
	import com.StudentManagementSystem.Exceptions.StudentException;
	import com.StudentManagementSystem.models.Course;
	import com.StudentManagementSystem.models.Student;
	
	public interface StudentDao {
		
	public boolean registraterStudent(Student std) throws StudentException;
		
		public boolean loginStudent(String username, String password) throws StudentException;
		
		public boolean updatePassword(String username, String newpassword) throws StudentException;
		
		public boolean updateEmail(String username, String newEmail) throws StudentException;
		
		public boolean updateMobile(String username, long newMobile) throws StudentException;
		
		public boolean updateAddress(String username, String add) throws StudentException;
		
		public List<Course> viewAllCourseList() throws CourseException;
	
	}
