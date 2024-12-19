package com.barisozkan.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.barisozkan.dto.DtoCourse;
import com.barisozkan.dto.DtoStudent;
import com.barisozkan.dto.DtoStudentIU;
import com.barisozkan.entites.Course;
import com.barisozkan.entites.Student;
import com.barisozkan.repository.StudentRepository;
import com.barisozkan.services.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService{
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
		DtoStudent response=new DtoStudent(); //DtoStudent sınıfından response nesnesi turetildi.
		Student student = new Student(); //student sınıfından student nesnesi turetildi.
		BeanUtils.copyProperties(dtoStudentIU, student);//bu yapı sayesinde dtoStudentIU yu studenta kopyaladık.
		
		Student dbStudent= studentRepository.save(student); //dbStudent'ı veritabanına kaydettik.
		BeanUtils.copyProperties(dbStudent, response); //dbStudent kaydettikten sonra donusum yapıyoruz responsa kopyalıyoruz.
		return response;//ve en sonda responsu donuyoruz.
	}

	@Override
	public List<DtoStudent> getAllStudent() {
		List<DtoStudent> dtoList= new ArrayList<>(); //dtostudent tipinle liste olusturduk
		List<Student> studentList = studentRepository.findAll();
		for (Student student : studentList) { //foreachle listeyi dönüyoruz bu sırada
			DtoStudent dto = new DtoStudent(); //dtostudenttan nesne türettik 
			BeanUtils.copyProperties(student, dto);//BeanUtils.copyProperties sayesinde elimizdeki studentı dto ya kopyala dedik.
			dtoList.add(dto);//Kopyalandıktan sonra dtodaki veriyi de olusturdugumuz dtoListe ekle diyoruz ve en sonda
		}
		return dtoList; //dtoListesini dönüyoruz.
	}

	@Override
	public DtoStudent getStudentById(Integer id) {
		DtoStudent dtoStudent = new DtoStudent();
		Optional<Student> optional= studentRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		Student dbStudent=optional.get();
		BeanUtils.copyProperties(dbStudent, dtoStudent);
		if (dbStudent.getCourse()!=null && !dbStudent.getCourse().isEmpty()) {
			for (Course course : dbStudent.getCourse()) {
				DtoCourse dtoCourse= new DtoCourse();
				BeanUtils.copyProperties(course, dtoCourse);
				dtoStudent.getCourses().add(dtoCourse);
			}
		}
		return dtoStudent;
//		DtoStudent dtoStudent = new DtoStudent();//dtoStudent nesnesini türettik
//		Optional<Student> optional= studentRepository.findById(id);
//		if (optional.isPresent()) {
//			Student dbStudent = optional.get(); //Student sınıfından dbStudent turetip optional.get() tten aldıgımız içine attık.
//			BeanUtils.copyProperties(dbStudent, dtoStudent);//yapı sayesinde dbStudent içindekileri dtoStudent a kopyaladık.
//		}
//		return dtoStudent; //en son da dtoStudent ı döndük.
	}
	
	@Override
	public void deleteStudent(Integer id) {
		Optional<Student> optional = studentRepository.findById(id); //burada dto ile bagımız yok çünkü direkt studenttan gelen
		if (optional.isPresent()) { //veritabanındaki veriyi silebiliriz.
			studentRepository.delete(optional.get());//optional.get() bize studentı verdi.
		}
	}

	@Override
	public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU) {
		DtoStudent dto = new DtoStudent();
		Optional<Student> optional= studentRepository.findById(id);
		if (optional.isPresent()) {
			Student dbStudent = optional.get();
			dbStudent.setFirstName(dtoStudentIU.getFirstName());
			dbStudent.setLastName(dtoStudentIU.getLastName());
			dbStudent.setBirthOfDate(dtoStudentIU.getBirthOfDate());
			
			Student updatedStudent= studentRepository.save(dbStudent);
			BeanUtils.copyProperties(updatedStudent, dto);
			return dto;
		}
		return null;
	}
}
