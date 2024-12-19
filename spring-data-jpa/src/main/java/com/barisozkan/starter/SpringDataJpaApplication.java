package com.barisozkan.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import jakarta.persistence.Entity;


@SpringBootApplication
@EntityScan(basePackages = {"com.barisozkan"}) //bunu yazmazsan tarama yapacagı yeri bilmedigi icin hata veriyor.Entity anatasyonunu bulmaya yarıyor.
@ComponentScan(basePackages = {"com.barisozkan"})//service, controller vs icin bunu da tanımlaman sart!
@EnableJpaRepositories(basePackages = {"com.barisozkan"})//bunu da jpa repositorylerini aktif edebilmek icin yazman sart
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

}
