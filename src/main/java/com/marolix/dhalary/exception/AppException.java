package com.marolix.dhalary.exception;


import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AppException {

	private String msg;
	
	private String code;
	
	private LocalDateTime localDateTime;
}
