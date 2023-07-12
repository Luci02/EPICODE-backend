package com.epicode.controller;

import java.sql.SQLException;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.epicode.enumerated.TipoEvento;
import com.epicode.model.Evento;

public class EventoDAO {
	
	static EntityManagerFactory  emf = Persistence.createEntityManagerFactory("AppGestioneEventi");
	static EntityManager em = emf.createEntityManager();

	public static void main(String[] args) {
		
		try {
			
			Evento e1 = new Evento("Ligabue - Indoor Tour 2023 - Dedicato a noi", LocalDate.of(2023, 10, 9), TipoEvento.PUBBLICO, 5000);
			Evento e2 = new Evento("Checco Zalone - Amore + Iva", LocalDate.of(2023, 8, 9), TipoEvento.PRIVATO, 50);
			Evento e3 = new Evento("Tiziano Ferro - TZN 2023", LocalDate.of(2023, 07, 14), TipoEvento.PUBBLICO, 600);
			
			save(e1);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			emf.close();
			em.close();
		}
		
		
		
	}
	
	public static void save(Evento e) throws SQLException {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		System.out.println(e);
	}
	
	public static void getById(long id) throws SQLException {
		em.getTransaction().begin();
		Evento e = em.find(Evento.class, id);
		em.getTransaction().commit();
		System.out.println(e);
	}
	
	public static void delete(Evento e) throws SQLException {
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
		System.out.println("Evento rimosso dal Database");
	}
	
	public static void refresh(Evento e) throws SQLException {
		em.getTransaction().begin();
		em.refresh(e);
		em.getTransaction().commit();
	}

}
