package com.barisozkan.services;

import com.barisozkan.dto.DtoHome;

public interface IHomeService {
	
	public DtoHome findHomeById(Long id);
}
