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

    private Logger LOG = LoggerFactory.getLogger("Wilder");

    @Autowired
    private UserDAO userDao;

    @Override
    public void run(String... args) throws Exception {

        // Checke combien d'objets se trouvent dans la BDD        
        LOG.info("******************");
        LOG.info("Objects in DB : " + userDao.count());

        // Crée un nouvel utilisateur et l'enregistre dans la BDD
        User user1 = new User("Brenda", "Wildeuse", 19);
        LOG.info("******************");
        LOG.info(user1 + " has been created !");
        userDao.save(user1);
        LOG.info(user1 + " has been saved !");
    }    
}
