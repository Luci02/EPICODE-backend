package com.epicode.Spring.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.epicode.Spring.models.Sonda;
import com.epicode.Spring.repositories.SondaRepository;

@Service
public class SondaService {

	@Autowired SondaRepository repo;
	
	public void sendRequest( Sonda s ) {
		// http://localhost:8080/alarm?idsonda=01&lat=47.25845654&lon=98.7848467&smokelevel=50
		Random r = new Random();
		String url = "http://localhost:8080/alarm";
		url += "?idsonda=" + s.getId();
		url += "&lat=" + s.getLatitude();
		url += "&lon=" + s.getLongitude();
		url += "&smokelevel=" + r.nextInt(11);
		System.out.println(url);
		RestTemplate rt = new RestTemplate();
		rt.getForEntity(url, String.class);
	}
	
}
