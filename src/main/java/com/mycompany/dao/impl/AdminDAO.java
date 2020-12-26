package com.mycompany.dao.impl;

import com.mycompany.dao.AbstractDAO;
import com.mycompany.domain.Entity;
import com.mycompany.domain.impl.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AdminDAO extends AbstractDAO {
    private static final Logger logger = LoggerFactory.getLogger(AdminDAO.class);


    public AdminDAO() throws SQLException {
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public Optional<Entity> getEntityById(Object id) {
        return null;
    }

    public Optional<Admin> getEntityByLogin(String login) {
        final String FIND_LOGIN = "SELECT * FROM bank_terminal.user WHERE login='" + login + "'";

        Admin admin = null;
        PreparedStatement preparedStatement = null;
        try {
            try {
                ResultSet resultSet = null;
                try {
                    preparedStatement = getPrepareStatement(FIND_LOGIN);
                    resultSet = preparedStatement.executeQuery();

                    while (resultSet.next()) {
                        admin = new Admin();
                        admin.setAdminId(resultSet.getInt("id"));
                        admin.setName(resultSet.getString("name"));
                        admin.setSurname(resultSet.getString("surname"));
                        admin.setMobilePhone(resultSet.getString("mobile_phone"));
                        admin.setLogin(resultSet.getString("login"));
                        admin.setPassword(resultSet.getString("password"));
                    }

//                    ConnectionPool.CONNECTION_POOL.putback(connection);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } finally {
                    if (resultSet != null) {
                        resultSet.close();
                    } else {
                        logger.error("error while reading from database");
                    }
                }
            } finally {
                closePrepareStatement(preparedStatement);
            }
        } catch (SQLException e) {
            logger.error("", e);
        }

        return Optional.ofNullable(admin);
    }

    @Override
    public Entity update(Entity entity) {
        return null;
    }

    @Override
    public boolean delete(Object id) {
        return false;
    }

    @Override
    public boolean create(Entity entity) {
        return false;
    }
}
