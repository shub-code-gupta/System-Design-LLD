package com.tinyURL_System_Design_LLD.TinyURLService.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;
import com.tinyURL_System_Design_LLD.TinyURLService.Model.Url;
import com.tinyURL_System_Design_LLD.TinyURLService.Model.UrlDto;
import com.tinyURL_System_Design_LLD.TinyURLService.Repository.UrlRepository;

@Component
public class URLServiceImpl implements URLService {

	@Autowired
	private UrlRepository urlRepository;

	@Override
	public Url generateShortLink(UrlDto urlDto) {

		if (!(urlDto.getUrl()).isBlank() && !(urlDto.getUrl()).isEmpty()) {

			String encodedUrl = encodeURL(urlDto.getUrl());

			Url persitUrl = new Url();
			persitUrl.setCreationDate(LocalDateTime.now());
			persitUrl.setOriginalUrl(urlDto.getUrl());
			persitUrl.setShortUrl(encodedUrl);
			if (urlDto.getExpirationDate().isBlank() || urlDto.getExpirationDate().isEmpty()) {
				persitUrl.setExpirationDate(LocalDateTime.now().plusSeconds(120));
			} else {
				persitUrl.setExpirationDate(LocalDateTime.parse(urlDto.getExpirationDate()));
			}

			return persistShortLink(persitUrl);
		}

		return null;
	}

	private String encodeURL(String url) {

		String encodedUrl = "";
		LocalDateTime time = LocalDateTime.now();

		encodedUrl = Hashing.crc32().hashString(url.concat(time.toString()), StandardCharsets.UTF_8).toString();

		return encodedUrl;

	}

	@Override
	public Url persistShortLink(Url url) {
		return urlRepository.save(url);
	}

	@Override
	public Url getEncodedUrl(String url) {
		return urlRepository.findByShortUrl(url);
	}

	@Override
	public void deleteUrl(Url url) {
		urlRepository.delete(url);
	}

}
