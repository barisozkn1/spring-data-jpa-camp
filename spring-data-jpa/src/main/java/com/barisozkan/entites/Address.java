package com.barisozkan.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "description")
	private String description;
	
	@OneToOne(mappedBy = "address") 
	/*
	 * ilişkinin sahibi bu olmadıgı için burada mappedby kullanıp ilişkinin asıl sahibinin fieldını gösterirsin.
	 * tabi bu çift taraflı ilişki kuruldugunda geçerli olur tek taraflı kurdugunda buna gerek kalmaz
	 */
	private Customer customer;
}
