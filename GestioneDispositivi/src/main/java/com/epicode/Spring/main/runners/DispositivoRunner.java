package com.epicode.Spring.main.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.Spring.main.models.enumerators.StatoDispositivo;
import com.epicode.Spring.main.services.DispositivoService;

@Component
public class DispositivoRunner implements CommandLineRunner {
	
	@Autowired DispositivoService dispositivoSvc;
	
	@Override
	public void run(String... args) throws Exception {
		
//		for (int i = 0; i < 3; i++) {			
//			dispositivoSvc.saveDevice( dispositivoSvc.createSmartphone() );
//			dispositivoSvc.saveDevice( dispositivoSvc.createTablet() );
//			dispositivoSvc.saveDevice( dispositivoSvc.createlapLaptop() );
//		}
		
		//dispositivoSvc.changeDeviceStatus(3l, StatoDispositivo.IN_MANUTENZIONE);
		
	}

}
