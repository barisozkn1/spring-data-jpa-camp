package com.barisozkan.services;

import java.util.List;

import com.barisozkan.dto.DtoStudent;
import com.barisozkan.dto.DtoStudentIU;
import com.barisozkan.entites.Student;

public interface IStudentService {
	
	public DtoStudent saveStudent(DtoStudentIU student);
	
	public List<DtoStudent> getAllStudent();
	
	public DtoStudent getStudentById(Integer id);
	
	public void deleteStudent(Integer id);
	
	public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU); //normalde entity kavramları gecilmez burada dto gecınce degisecek
}
