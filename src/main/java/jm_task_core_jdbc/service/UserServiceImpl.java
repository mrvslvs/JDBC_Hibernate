package jm_task_core_jdbc.service;

import jm_task_core_jdbc.dao.UserDao;
import jm_task_core_jdbc.dao.UserDaoHibernateImpl;
import jm_task_core_jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao;

    public UserServiceImpl() {
        this.dao = new UserDaoHibernateImpl();
    }

    public void createUsersTable() {

        dao.createUsersTable();

    }

    public void dropUsersTable() {

        dao.dropUsersTable();

    }

    public void saveUser(String name, String lastName, byte age) {

        dao.saveUser(name, lastName, age);

    }

    public void removeUserById(long id) {

        dao.removeUserById(id);

    }

    public List<User> getAllUsers() {

        return dao.getAllUsers();

    }

    public void cleanUsersTable() {

        dao.cleanUsersTable();

    }
}
