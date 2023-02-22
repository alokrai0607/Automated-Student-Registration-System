package com.StudentManagementSystem.Dao;

import java.util.List;

import com.StudentManagementSystem.Exceptions.AdminException;
import com.StudentManagementSystem.Exceptions.BatchException;
import com.StudentManagementSystem.Exceptions.CourseException;
import com.StudentManagementSystem.Exceptions.StudentException;
import com.StudentManagementSystem.models.Course;
import com.StudentManagementSystem.models.Student;

public interface AdminDao {
	
	public boolean adminLogIn(String userName, String password) throws AdminException;

	public String insertNewCourse(Course course) throws CourseException;
	
	public String updateCourseFee(int c_id,int fee) throws  CourseException;
	
	public String deleteCourse(int c_id) throws  CourseException;
	
	public Course searchInformationAboutCourse(int c_id) throws  CourseException;
	
	public String createBatchUnderCourse(int c_id, String batch,int totalSeats) throws BatchException;
	
	public int  allocateBatchToStudent(String email ,String batchname) throws BatchException, StudentException;
	
	public String updateTotalSeatsInBatch(String batch, int seats) throws BatchException;
	
	public List<Student> veiwStudentList()  throws StudentException;

}
