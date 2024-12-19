package com.barisozkan.dto;

import com.barisozkan.entites.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoAddress {
	
	private Long id;
	
	private String description;
}
