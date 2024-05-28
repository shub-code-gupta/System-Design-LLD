package com.tinyURL_System_Design_LLD.TinyURLService.Service;

import org.springframework.stereotype.Service;

import com.tinyURL_System_Design_LLD.TinyURLService.Model.Url;
import com.tinyURL_System_Design_LLD.TinyURLService.Model.UrlDto;

@Service
public interface URLService {
	
	public Url generateShortLink(UrlDto urlDto);
	public Url persistShortLink(Url url);
	public Url getEncodedUrl(String url);
	public void deleteUrl(Url url);

}
