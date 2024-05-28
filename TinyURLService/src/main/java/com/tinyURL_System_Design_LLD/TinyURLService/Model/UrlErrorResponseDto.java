package com.tinyURL_System_Design_LLD.TinyURLService.Model;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlErrorResponseDto {
	
	private String status;
	private HttpStatus error;

}
