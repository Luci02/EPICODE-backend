package com.epicode.Spring.services;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.Spring.models.Ordine;
import com.epicode.Spring.models.Tavolo;

@Service
public class OrdineService {
	
	@Autowired 	@Qualifier("ordineBean") ObjectProvider<Ordine> ordineProvider;
	@Autowired @Qualifier("tavoloBean") ObjectProvider<Tavolo> tavoloProvider;
	
	public void creaOrdineSenzaNota(Integer numOrdine, Tavolo tavolo, Integer numeroCoperti) {
		Ordine o = ordineProvider.getObject();
		o.setNumeroOrdine(numOrdine);
		o.setTavolo(tavolo);
		o.setNumeroCoperti(numeroCoperti);
		
//		Integer numeroCoperti
//		ordineTavolo, 
//		String nota,
//		Double importoTotale
	}
	
	public Tavolo creaTavolo(Integer numTavolo, Integer maxCoperti) {
		Tavolo t = tavoloProvider.getObject();
		t.setEmpty(false);
		t.setNumeroCopertiMassimi(maxCoperti);
		t.setNumeroTavolo(numTavolo);
		return t;
	}

}
