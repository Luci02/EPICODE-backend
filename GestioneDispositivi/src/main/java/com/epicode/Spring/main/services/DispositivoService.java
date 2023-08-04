package com.epicode.Spring.main.services;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.Spring.main.exceptions.EqualStatusException;
import com.epicode.Spring.main.models.Dispositivo;
import com.epicode.Spring.main.models.Laptop;
import com.epicode.Spring.main.models.Smartphone;
import com.epicode.Spring.main.models.Tablet;
import com.epicode.Spring.main.models.Utente;
import com.epicode.Spring.main.models.enumerators.StatoDispositivo;
import com.epicode.Spring.main.repositories.DispositivoRepository;
import com.epicode.Spring.main.repositories.UtenteRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DispositivoService {
	
	@Autowired DispositivoRepository dispositivoRepository;
	@Autowired UtenteRepository utenteRepository;
	
	@Autowired @Qualifier("getSmartphone") ObjectProvider<Smartphone> smartphoneProvider;
	@Autowired @Qualifier("getTablet") ObjectProvider<Tablet> tabletProvider;
	@Autowired @Qualifier("getLaptop") ObjectProvider<Laptop> laptopProvider;
	
	public Smartphone createSmartphone() {
		return smartphoneProvider.getObject();
	}
	
	public Tablet createTablet() {
		return tabletProvider.getObject();
	}
	
	public Laptop createlapLaptop() {
		return laptopProvider.getObject();
	}
	
	public void saveDevice(Smartphone smartphone) {
		dispositivoRepository.save(smartphone);
		log.info("Smartphone aggiunto correttamente sul DB!");
	}
	
	public void saveDevice(Tablet tablet) {
		dispositivoRepository.save(tablet);
		log.info("Tablet aggiunto correttamente sul DB!");
	}
	
	public void saveDevice(Laptop laptop) {
		dispositivoRepository.save(laptop);
		log.info("Laptop aggiunto correttamente sul DB!");
	}
	
	public void changeDeviceStatus(Long id, StatoDispositivo s) throws EqualStatusException {
		Dispositivo dispositivo = dispositivoRepository.findById(id).get();
		
		if (dispositivo.getStatoDispositivo() == s) {
			throw new EqualStatusException("Il dispositivo possiede già lo stato che stai cercando di assegnare");
		}
		
		dispositivo.setStatoDispositivo(s);
		dispositivoRepository.save(dispositivo);
		log.info("Stato del dispositivo aggiornato! Nuovo stato: {}", dispositivo.getStatoDispositivo());
	}
	
	public void setDeviceUser(Long id, String username) {
		
		Dispositivo dispositivo = dispositivoRepository.findById(id).get();
		Utente utente = utenteRepository.findById(username).get();
		
		if ( dispositivoRepository.findById(id).get().getStatoDispositivo() != StatoDispositivo.DISPONIBILE ) {
			// Lanciare eccezione personalizzata
		}
		
		dispositivo.setUtente(utente);
		dispositivoRepository.save(dispositivo);
		log.info(
				"Dispositivo n. {} associato a {} {}",
				dispositivo.getId(),
				dispositivo.getUtente().getNome(),
				dispositivo.getUtente().getCognome()
				);
		
	}

}
