package org.smark.prointro.eclipselink.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.smark.prointro.eclipselink.jpa.entity.User;

public class EntityService {
	
	@PersistenceContext
	protected EntityManager em;
	
	

	public EntityService(EntityManager em) {
		super();
		this.em = em;
	}
	public void info(){
		System.out.println(em);
	}
	public void saveUser(User user){
		em.persist(user);
		em.flush();
	}
	
	public List<User> loadUsers(){
		List<User> users = em.createQuery("select user from User user")
			.getResultList();
		return users;
	}
	
}
