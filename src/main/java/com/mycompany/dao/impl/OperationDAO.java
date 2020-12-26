package com.mycompany.dao.impl;

import com.mycompany.dao.AbstractDAO;
import com.mycompany.domain.impl.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OperationDAO extends AbstractDAO<Long, Operation> {
    private static final Logger logger = LoggerFactory.getLogger(CashierDAO.class);

    public OperationDAO() throws SQLException {
    }

    @Override
    public List<Operation> getAll() {
        final String SELECT_ALL_OPERATIONS = "SELECT * FROM bank_terminal.operation";

        List<Operation> operations = new ArrayList<>();
        PreparedStatement preparedStatement = getPrepareStatement(SELECT_ALL_OPERATIONS);
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Operation operation = new Operation();

                operation.setOperationId(resultSet.getInt("id"));
                operation.setCashierName(resultSet.getString("cashier"));
                operation.setClientName(resultSet.getString("client"));
                operation.setBuyOrSell(resultSet.getString("buy or sell"));
                operation.setFromWhichCurrency(resultSet.getString("first currency"));
                operation.setToWhichCurrency(resultSet.getString("second currency"));
                operation.setSum(Double.parseDouble(resultSet.getString("sum")));
                operation.setDate(resultSet.getString("date"));

                operations.add(operation);
            }
//            System.out.println("*****************");
//            operations.forEach(System.out::println);
        } catch (SQLException e) {
            logger.error("", e);
        } finally {
            closePrepareStatement(preparedStatement);
        }

        return operations;
    }

    @Override
    public Optional<Operation> getEntityById(Long id) {
        final String FIND_BY_ID = "SELECT * FROM bank_terminal.operation WHERE id='" + id + "'";

        Operation operation = null;
        PreparedStatement preparedStatement = null;
        try {
            try {
                ResultSet resultSet = null;
                try {
                    preparedStatement = getPrepareStatement(FIND_BY_ID);
                    resultSet = preparedStatement.executeQuery();

                    while (resultSet.next()) {
                        operation = new Operation();

                        operation.setOperationId(resultSet.getInt("id"));
                        operation.setCashierName(resultSet.getString("cashier"));
                        operation.setClientName(resultSet.getString("client"));
                        operation.setBuyOrSell(resultSet.getString("buy or sell"));
                        operation.setFromWhichCurrency(resultSet.getString("first currency"));
                        operation.setToWhichCurrency(resultSet.getString("second currency"));
                        operation.setSum(Double.parseDouble(resultSet.getString("sum")));
                        operation.setDate(resultSet.getString("date"));
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

        return Optional.ofNullable(operation);
    }

    @Override
    public Operation update(Operation entity) {
        final String UPDATE_OPERATION = "UPDATE bank_terminal.operation SET cashier = '" + entity.getCashierName()
                + "', client = '" + entity.getClientName()
                + "', `buy or sell` =  '" + entity.getBuyOrSell()
                + "', `first currency` =  '" + entity.getFromWhichCurrency()
                + "', `second currency` =  '" + entity.getToWhichCurrency()
                + "', sum =  '" + entity.getSum()
                + "', date =  '" + entity.getDate()
                + "' WHERE id = " + entity.getOperationId();

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getPrepareStatement(UPDATE_OPERATION);
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
        final String DELETE_OPERATION = "DELETE FROM bank_terminal.operation WHERE id = " + id;

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getPrepareStatement(DELETE_OPERATION);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            logger.error("", throwables);
        } finally {
            closePrepareStatement(preparedStatement);
        }

        return true;
    }

    @Override
    public boolean create(Operation entity) {
        final String INSERT_CASHIER = "INSERT INTO bank_terminal.operation (cashier, client, `buy or sell`, `first currency`, `second currency`, sum, date) values ('"
                + entity.getCashierName()
                + "', '" + entity.getClientName()
                + "', '" + entity.getBuyOrSell()
                + "', '" + entity.getFromWhichCurrency()
                + "', '" + entity.getToWhichCurrency()
                + "', '" + entity.getSum()
                + "', '" + entity.getDate() + "')";

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
