package jm_task_core_jdbc.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.*;

public class Util {

    public static SessionFactory sessionFactory;
    private static final Logger logger = Logger.getLogger(Util.class.getName());

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.configure("hibernate.cfg.xml");

                sessionFactory = configuration.buildSessionFactory();
                logger.info("Hibernate SessionFactory created");
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error creating session factory", e);
                throw new RuntimeException(e);
            }
        }
        return sessionFactory;
    }
}
