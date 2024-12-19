package com.barisozkan.controller;

import com.barisozkan.dto.DtoHome;

public interface IHomeController {
	
	public DtoHome findHomeById(Long id);
}
