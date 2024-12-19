package com.barisozkan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.barisozkan.entites.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{ 
/*
 * burada hibernate yapısını kullanıyoruz repository katmanında.
 * JpaRepository 2 parametre alır
 * 1.Hangi entity sınıfı uzerinde islem yapacagın
 * 2. primary key olarak isaretledigin kolonun veri tipini belirtmen gerekir.
 */
	
	//yeri geldigi zaman jpa yetmediginde buralara kendi özel metotlarımızı yazacagız.
	
	
	/* HQL : sınıfın ismi ve degisken isimelri kullanılarak sorgular yazılır.  nativeQuery=false olacak bu tipte yazacaksan
	 * SQL : veritabanındaki tablo ismi ve tablo içerisindeki kolon isimleri ile sorgular yazılırç.  nativeQuery=true olacak bu tipte yazacaksan
	 * bu ikisi arasındaki fark çok onemli !
	 */
	@Query(value = "from Student", nativeQuery = false)
	List<Student> findAllStudent();
}
