package com.barisozkan.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barisozkan.controller.IStudentController;
import com.barisozkan.dto.DtoStudent;
import com.barisozkan.dto.DtoStudentIU;
import com.barisozkan.entites.Student;
import com.barisozkan.services.IStudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController{
	
	@Autowired
	private IStudentService studentService;
	
	//DTO normalde kullanılır parametreleri vermeyiz ama anlatana kadar böyle olsun.Bu yontem yanlış yani parametreli vs.
	@PostMapping(path = "/save")
	@Override
	public DtoStudent saveStudent(@RequestBody @Valid DtoStudentIU dtoStudentIU) { //valid kullanma sebebin @NotNull, @NotEmpty gibi seyler kullandıgın zaman belirtirsin.
		return studentService.saveStudent(dtoStudentIU);
	}
	
	@GetMapping(path = "/list")
	@Override
	public List<DtoStudent> getAllStudent() {
		return studentService.getAllStudent();
	}

	@GetMapping(path = "/list/{id}")
	@Override
	public DtoStudent getStudentById(@PathVariable(name = "id", required = true)Integer id) {
		return studentService.getStudentById(id);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	@Override
	public void deleteStudent(@PathVariable(name = "id") Integer id) {
		studentService.deleteStudent(id);
	}
	
	@PutMapping(path = "/update/{id}")
	@Override
	public DtoStudent updateStudent(@PathVariable(name = "id") Integer id, @RequestBody DtoStudentIU dtoStudentIU) {
		return studentService.updateStudent(id, dtoStudentIU);
	}

}
