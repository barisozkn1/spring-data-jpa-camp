package com.barisozkan.exception;

import java.util.Date;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiError <T>{ //<T> yapısı ile generic hala getirdik sınıfı artık ne gelirse errors da o tipte olacak.
	
	private String id;
	
	private Date errorTime;
	
	private T errors;
}
