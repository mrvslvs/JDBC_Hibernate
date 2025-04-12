package jm_task_core_jdbc.dao;

import jm_task_core_jdbc.model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.logging.Logger;

public class UserDaoHibernateImpl implements UserDao {

    private static Logger logger = Logger.getLogger(UserDaoHibernateImpl.class.getName());
    private static SessionFactory sessionFactory;

    public UserDaoHibernateImpl() {

        sessionFactory = new Configuration().configure().buildSessionFactory();

    }

    @Override
    public void createUsersTable() {

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS users " +
                    "(id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(255), " +
                    "lastName VARCHAR(255), " +
                    "age TINYINT)").executeUpdate();
            transaction.commit();
            logger.info("Table created");
        } catch (Exception e) {
            logger.info("Error creating users table");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void dropUsersTable() {

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS users").executeUpdate();
            transaction.commit();
            logger.info("Table dropped");
        } catch (Exception e) {
            logger.info("Error dropping users table");
            throw new RuntimeException(e);
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            User user = new User(name, lastName, age);
            session.save(user);
            transaction.commit();
            logger.info("User saved");
        } catch (Exception e) {
            logger.info("Error saving user");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeUserById(long id) {

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            transaction.commit();
            logger.info("User deleted");
        } catch (Exception e) {
            logger.info("Error deleting user");
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from User", User.class).list();
        } catch (Exception e) {
            logger.info("Error getting all users");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery("TRUNCATE TABLE users").executeUpdate();
            transaction.commit();
            logger.info("Table cleaned");
        } catch (Exception e) {
            logger.info("Error cleaning users table");
            throw new RuntimeException(e);
        }

    }
}
