package com.tinyURL_System_Design_LLD.TinyURLService.Model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Url {
	
	@Id
	@GeneratedValue
	private long id;
	@Lob
	private String originalUrl;
	private String shortUrl;
	private LocalDateTime expirationDate;
	private LocalDateTime creationDate;

}
