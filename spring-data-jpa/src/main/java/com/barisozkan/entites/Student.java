package com.barisozkan.entites;

import java.sql.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //bu lombokta @Getter ve @Setter anatasyonunu birlikte icerir ayrı ayrı yazmak yerine bunu yaz
@NoArgsConstructor
@AllArgsConstructor
@Entity //veritabanına bir tablo olarak yansıtmayı saglayan anatasyon.
@Table(name = "student")
public class Student {
	
	@Id //veritabanında primary key olarak belirletmeyi saglar
	@Column(name = "id") //bunu demesek de sutun ismi olarak default id alır.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "first_name", nullable = false, length = 35)
	private String firstName;
	@Column(name = "last_name", nullable = false, length = 35)
	private String lastName;
	//@JsonFormat(pattern = "yyyy-MM-dd") //bu anatasyon 2001-06-14 olarak girdigi tarihi tanır.
	@DateTimeFormat(iso = ISO.DATE) //JsonFormat anatasyonu ile aynı islevde.
	@Column(name = "birth_of_date", nullable = true)
	private Date birthOfDate;
	
	@ManyToMany
	@JoinTable(name = "student_course", joinColumns = @JoinColumn(name="student_id"),
	inverseJoinColumns = @JoinColumn(name="course_id"))
	private List<Course> course;

}
