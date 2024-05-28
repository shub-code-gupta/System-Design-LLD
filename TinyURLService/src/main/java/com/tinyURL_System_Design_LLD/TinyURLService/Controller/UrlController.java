package com.tinyURL_System_Design_LLD.TinyURLService.Controller;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tinyURL_System_Design_LLD.TinyURLService.Model.Url;
import com.tinyURL_System_Design_LLD.TinyURLService.Model.UrlDto;
import com.tinyURL_System_Design_LLD.TinyURLService.Model.UrlErrorResponseDto;
import com.tinyURL_System_Design_LLD.TinyURLService.Model.UrlResponseDto;
import com.tinyURL_System_Design_LLD.TinyURLService.Service.URLService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/tinyUrl")
public class UrlController {

	@Autowired
	private URLService urlService;

	@PostMapping("/generateTinyUrl")
	public ResponseEntity<?> generateShortUrl(@RequestBody UrlDto urlDto) {

		Url urlRet = urlService.generateShortLink(urlDto);

		if (urlRet != null) {

			UrlResponseDto urlResp = new UrlResponseDto();
			urlResp.setExpirationDate(urlRet.getExpirationDate());
			urlResp.setOriginalUrl(urlRet.getOriginalUrl());
			urlResp.setShortUrl(urlRet.getShortUrl());
			return new ResponseEntity<UrlResponseDto>(urlResp, HttpStatus.OK);
		}

		UrlErrorResponseDto error = new UrlErrorResponseDto();
		error.setStatus("URL IS INVALID");
		error.setError(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<UrlErrorResponseDto>(error, HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/{shortUrl}")
	public ResponseEntity<?> redirectToOriginalUrl(@PathVariable("shortUrl") String url, HttpServletResponse response)
			throws IOException {

		if (url.isEmpty()) {
			UrlErrorResponseDto error = new UrlErrorResponseDto();
			error.setStatus("SHORT URL IS INVALID");
			error.setError(HttpStatus.BAD_REQUEST);
			return new ResponseEntity<UrlErrorResponseDto>(error, HttpStatus.BAD_REQUEST);

		}

		Url urlRet = urlService.getEncodedUrl(url);

		if (urlRet == null) {
			UrlErrorResponseDto error = new UrlErrorResponseDto();
			error.setStatus("SHORT URL IS INVALID");
			error.setError(HttpStatus.BAD_REQUEST);
			return new ResponseEntity<UrlErrorResponseDto>(error, HttpStatus.BAD_REQUEST);

		}

		if (urlRet.getExpirationDate().isBefore(LocalDateTime.now())) {

			urlService.deleteUrl(urlRet);
			
			UrlErrorResponseDto error = new UrlErrorResponseDto();
			error.setStatus("SHORT URL IS EXPIRED PLEASE CREATE AGAIN");
			error.setError(HttpStatus.BAD_REQUEST);
			return new ResponseEntity<UrlErrorResponseDto>(error, HttpStatus.BAD_REQUEST);
		}

		response.sendRedirect(urlRet.getOriginalUrl());
		return null;
	}

}
