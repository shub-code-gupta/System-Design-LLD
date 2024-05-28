package com.tinyURL_System_Design_LLD.TinyURLService.Model;

import java.time.LocalDateTime;

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
public class UrlResponseDto {
	
	private String originalUrl;
	private String shortUrl;
	private LocalDateTime expirationDate;

}
