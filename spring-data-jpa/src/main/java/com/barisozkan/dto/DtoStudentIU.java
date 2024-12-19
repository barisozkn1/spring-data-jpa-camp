package com.barisozkan.dto;

import java.sql.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudentIU {
	
	@NotEmpty(message = "Please fill in the name field.")
	@Min(value = 3)
	@Max(value = 20)
	private String firstName;
	
	@Size(min = 3, max = 30) //min 3 karakter max 30 karakter kısıtlaması
	private String lastName;
	
	private Date birthOfDate;
	
//	@Email
//	private String email;
//	 																				//bu kod satırları validations kullanımına örnekler.
//	@Size(min = 11, max = 11, message = "TCKN alani 11 karakter olmalı.")
//	@NotEmpty(message = "TCKN alani bos olamaz!")
//	private String tckn;
	
	/*
	 * DtoStudentIU, bu sınıfta insert, update islemleri yapılırken kullanılır.
	 * bu islemler bunu kullanıp daha sonra get islemlerinde ise
	 * actıgımız diger DtoStudent sınıfını kullanırız böylelikle
	 * bu 2 dto sınıf mantıgı sayesinde entity kısmımız arka planda gizli kalır
	 * bu sınıflar uzerinden islemlerimizi hallederiz.
	 */
}
