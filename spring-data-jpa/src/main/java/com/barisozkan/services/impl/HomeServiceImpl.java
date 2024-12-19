package com.barisozkan.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barisozkan.dto.DtoHome;
import com.barisozkan.dto.DtoRoom;
import com.barisozkan.entites.Home;
import com.barisozkan.entites.Room;
import com.barisozkan.repository.HomeRepository;
import com.barisozkan.services.IHomeService;

@Service
public class HomeServiceImpl implements IHomeService{
	
	@Autowired
	private HomeRepository homeRepository;
	
	@Override
	public DtoHome findHomeById(Long id) {
		DtoHome dtoHome = new DtoHome();
		Optional<Home> optional= homeRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		Home dbHome = optional.get();
		
		List<Room> dbRooms = optional.get().getRoom();
		
		BeanUtils.copyProperties(dbHome, dtoHome);
		if (dbRooms!=null && !dbRooms.isEmpty()) {
			for (Room room : dbRooms) {
				DtoRoom dtoRoom = new DtoRoom();
				BeanUtils.copyProperties(room, dtoRoom);
				dtoHome.getRooms().add(dtoRoom);
			}
		}
		return dtoHome;
		
	}
	
	
}
