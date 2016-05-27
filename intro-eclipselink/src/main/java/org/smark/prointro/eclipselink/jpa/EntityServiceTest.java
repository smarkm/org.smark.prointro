package org.smark.prointro.eclipselink.jpa;

import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;
import org.smark.prointro.eclipselink.jpa.entity.User;

public class EntityServiceTest {
	EntityManagerFactory emf;
	EntityManager em;
	private EntityService service;
	@Before
	public void Before() {
		emf = Persistence.createEntityManagerFactory("jpa-dev");
		em = emf.createEntityManager();
		service = new EntityService(em);
	}
	
	@Test
	public void info(){
		service.info();
		service.saveUser(new User("hello", 00));
	}
	
	@Test
	public void loadUsers(){
		for (User user : service.loadUsers()) {
			System.out.println(user);
		}
	}
}
