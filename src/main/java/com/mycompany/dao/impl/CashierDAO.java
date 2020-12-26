package com.mycompany.dao.impl;

import com.mycompany.domain.impl.Cashier;
import com.mycompany.dao.AbstractDAO;
import com.mycompany.factory.impl.CashierFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CashierDAO extends AbstractDAO<Long, Cashier> {
    private static final Logger logger = LoggerFactory.getLogger(CashierDAO.class);

    public CashierDAO() throws SQLException {
    }

    @Override
    public List<Cashier> getAll() {
        final String SELECT_ALL_CASHIERS = "SELECT * FROM bank_terminal.user";

        List<Cashier> cashiers = new ArrayList<>();
        PreparedStatement preparedStatement = getPrepareStatement(SELECT_ALL_CASHIERS);
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Cashier cashier = CashierFactory.CASHIER_FACTORY.create(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("mobile_phone"),
                        resultSet.getString("login"),
                        resultSet.getString("password")
                );
                cashiers.add(cashier);
            }
//            System.out.println("*****************");
//            cashiers.forEach(System.out::println);
        } catch (SQLException e) {
            logger.error("", e);
        } finally {
            closePrepareStatement(preparedStatement);
        }

        return cashiers;
    }

    @Override
    public Optional<Cashier> getEntityById(Long id) {
        final String FIND_BY_ID = "SELECT * FROM bank_terminal.user WHERE id='" + id + "'";

        Cashier cashier = null;
        PreparedStatement preparedStatement = null;
        try {
            try {
                ResultSet resultSet = null;
                try {
                    preparedStatement = getPrepareStatement(FIND_BY_ID);
                    resultSet = preparedStatement.executeQuery();

                    while (resultSet.next()) {
                        cashier = CashierFactory.CASHIER_FACTORY.create(
                                resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getString("surname"),
                                resultSet.getString("mobile_phone"),
                                resultSet.getString("login"),
                                resultSet.getString("password")
                        );
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

        return Optional.ofNullable(cashier);
    }

    public Optional<Cashier> getEntityByLogin(String login) {
        final String FIND_BY_LOGIN = "SELECT * FROM bank_terminal.user WHERE login='" + login + "'";

        Cashier cashier = null;
        PreparedStatement preparedStatement = null;
        try {
            try {
                ResultSet resultSet = null;
                try {
                    preparedStatement = getPrepareStatement(FIND_BY_LOGIN);
                    resultSet = preparedStatement.executeQuery();

                    while (resultSet.next()) {
                        cashier = CashierFactory.CASHIER_FACTORY.create(
                                resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getString("surname"),
                                resultSet.getString("mobile_phone"),
                                resultSet.getString("login"),
                                resultSet.getString("password")
                        );
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

        return Optional.ofNullable(cashier);
    }

    @Override
    public Cashier update(Cashier entity) {
        final String UPDATE_CASHIER = "UPDATE bank_terminal.user SET mobile_phone = '" + entity.getMobilePhone()
                + "', login = '" + entity.getLogin()
                + "', password =  '" + entity.getPassword() + "' WHERE id = " + entity.getCashierId();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getPrepareStatement(UPDATE_CASHIER);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            logger.error("", throwables);
        } finally {
            closePrepareStatement(preparedStatement);
        }

        return entity;
    }

    @Override
    public boolean delete(Long id) {
        final String DELETE_CASHIER = "DELETE FROM bank_terminal.user WHERE id = " + id;

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getPrepareStatement(DELETE_CASHIER);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            logger.error("", throwables);
        } finally {
            closePrepareStatement(preparedStatement);
        }

        return true;
    }

    @Override
    public boolean create(Cashier entity) {
        final String INSERT_CASHIER = "INSERT INTO bank_terminal.user (name, surname, mobile_phone, login, password) values ('"
                + entity.getName() + "', '" + entity.getSurname() + "', '" + entity.getMobilePhone() + "', '" + entity.getLogin()
                + "', '" + entity.getPassword() + "')";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getPrepareStatement(INSERT_CASHIER);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            logger.error("", throwables);
        } finally {
            closePrepareStatement(preparedStatement);
        }

        return true;
    }

}
