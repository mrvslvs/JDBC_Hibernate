package jm_task_core_jdbc.util;

import jm_task_core_jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;
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

                Properties properties = new Properties();
                properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                properties.put(Environment.URL, "jdbc:mysql://localhost:3306/mydb");
                properties.put(Environment.USER, "root");
                properties.put(Environment.PASS, "root");
                properties.put(Environment.DIALECT, "MySQL");
                properties.put(Environment.SHOW_SQL, "true");
                properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                properties.put(Environment.HBM2DDL_AUTO, "update");


                configuration.setProperties(properties);
                configuration.addAnnotatedClass(User.class);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
                logger.info("Hibernate SessionFactory created");

            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error creating session factory", e);
                throw new RuntimeException(e);
            }
        }
        return sessionFactory;
    }
}
