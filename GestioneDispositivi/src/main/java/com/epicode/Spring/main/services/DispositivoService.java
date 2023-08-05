package com.epicode.Spring.main.services;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.epicode.Spring.main.exceptions.DeviceStatusException;
import com.epicode.Spring.main.models.Dispositivo;
import com.epicode.Spring.main.models.Laptop;
import com.epicode.Spring.main.models.Smartphone;
import com.epicode.Spring.main.models.Tablet;
import com.epicode.Spring.main.models.Utente;
import com.epicode.Spring.main.models.enumerators.StatoDispositivo;
import com.epicode.Spring.main.repositories.DispositivoPageableRepository;
import com.epicode.Spring.main.repositories.DispositivoRepository;
import com.epicode.Spring.main.repositories.UtenteRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DispositivoService {
	
	@Autowired DispositivoRepository dispositivoRepository;
	@Autowired DispositivoPageableRepository pageableDeviceRepo;
	
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
	
	public void saveDevice(Dispositivo dispositivo) {
		dispositivoRepository.save(dispositivo);
		log.info("Dispositivo aggiunto correttamente sul DB!");
	}
	
	public Page<Dispositivo> getAllDevices(Pageable pageable) {
		return pageableDeviceRepo.findAll(pageable);
	}
	
	public Dispositivo getDeviceById(Long id) {
		return dispositivoRepository.findById(id).get();
	}
	
	public Dispositivo changeDeviceStatus(Long id, StatoDispositivo s) {
		
		Dispositivo dispositivo = dispositivoRepository.findById(id).get();
		
		if (dispositivo.getStatoDispositivo() == s) {
			throw new DeviceStatusException("Il dispositivo possiede già lo stato che stai cercando di assegnare", HttpStatus.BAD_REQUEST);
		}
		
		dispositivo.setStatoDispositivo(s);
		dispositivoRepository.save(dispositivo);
		log.info("Stato del dispositivo aggiornato! Nuovo stato: {}", dispositivo.getStatoDispositivo());
		return dispositivo;
	}
	
	public String setDeviceUser(Long id, String username) {
		
		Dispositivo dispositivo = dispositivoRepository.findById(id).get();
		Utente utente = utenteRepository.findById(username).get();
		
		if ( dispositivo.getStatoDispositivo() == StatoDispositivo.IN_MANUTENZIONE ) {
			throw new DeviceStatusException("Il dispositivo si trova attualmente in manutenzione!", HttpStatus.NOT_ACCEPTABLE);
		} else if ( dispositivo.getStatoDispositivo() != StatoDispositivo.DISPONIBILE ) {
			throw new DeviceStatusException("Il dispositivo è già assegnato ad un altro dipendente!", HttpStatus.CONFLICT);
		}
		
		dispositivo.setUtente(utente);
		dispositivo.setStatoDispositivo( StatoDispositivo.ASSEGNATO );
		
		dispositivoRepository.save(dispositivo);
		
		return "Dispositivo n. " + dispositivo.getId() 
				+ " associato a " + dispositivo.getUtente().getNome() 
				+ " " + dispositivo.getUtente().getCognome();
	}
	
	public Dispositivo deleteDeviceById(Long id) {
		Dispositivo d = dispositivoRepository.findById(id).get();
		dispositivoRepository.delete(d);
		return d;
	}

}
