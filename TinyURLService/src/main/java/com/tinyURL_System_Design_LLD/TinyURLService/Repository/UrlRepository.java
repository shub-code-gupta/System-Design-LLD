package com.tinyURL_System_Design_LLD.TinyURLService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tinyURL_System_Design_LLD.TinyURLService.Model.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long>{
	
	public Url findByShortUrl(String shortUrl);

}
