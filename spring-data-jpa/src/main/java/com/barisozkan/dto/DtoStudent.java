package com.barisozkan.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudent {
	
	private String firstName;
	
	private String lastName;
	
	/*
	 * Bu sınıf entity sınıfının gizliligini saglar.
	 * Yani mesela dogum tarihini görmesin istiyorum ama entity üzerinden
	 * islem yapınca onu da gosterıyor ama Dto mantıgıyla
	 * burada sadece gostermek istedigim seyleri ayarlayabiliyorum.
	 * bu sayede görünmesi gerekmeyen seyleri istedigimiz gibi düzenleyebiliriz.
	 * get islemlerini DtoStudent yani bu sınıftan hallederiz.
	 */
	
	private List<DtoCourse> courses= new ArrayList<>();
}
