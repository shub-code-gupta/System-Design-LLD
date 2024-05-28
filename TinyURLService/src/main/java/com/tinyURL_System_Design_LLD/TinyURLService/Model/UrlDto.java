package com.tinyURL_System_Design_LLD.TinyURLService.Model;


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
public class UrlDto {
	
	private String url;
	private String expirationDate;

}
