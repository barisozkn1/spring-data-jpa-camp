package com.barisozkan.controller;

import java.util.List;

import com.barisozkan.dto.DtoStudent;
import com.barisozkan.dto.DtoStudentIU;
import com.barisozkan.entites.Student;

public interface IStudentController {
	
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);
	
	public List<DtoStudent> getAllStudent(); 
	
	public DtoStudent getStudentById(Integer id);
	
	public void deleteStudent(Integer id);
	
	public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU);
}
