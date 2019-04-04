package com.wildcodeschool.example.springHibernateExample.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.wildcodeschool.example.springHibernateExample.entities.User;
import com.wildcodeschool.example.springHibernateExample.repositories.UserDAO;

@Component
public class Outputter implements CommandLineRunner {
	
	private Logger LOG = LoggerFactory.getLogger("App");
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public void run(String... args) throws Exception {
		LOG.info("****************");
		LOG.info("Il y a " + userDAO.count() + " utilisateurs dans la base de données.");
		
		// Création d'un nouvel utilisateur.
		User user = new User("Christopher", "MILAZZO", 31);
		
		// Sauvegarde de l'utilisateur en BDD
		userDAO.save(user);
		
		
		LOG.info("");
	}
	
}
