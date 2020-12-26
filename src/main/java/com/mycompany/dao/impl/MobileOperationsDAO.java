package com.mycompany.dao.impl;

import com.mycompany.dao.AbstractDAO;
import com.mycompany.domain.impl.MobileOperations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MobileOperationsDAO extends AbstractDAO<Long, MobileOperations> {

    private static final Logger logger = LoggerFactory.getLogger(CashierDAO.class);

    public MobileOperationsDAO() throws SQLException {
    }

    @Override
    public List<MobileOperations> getAll() {
        final String SELECT_ALL_Mobile_Operations = "SELECT * FROM bank_terminal.mobile_operations";

        List<MobileOperations> Mobile_Operations = new ArrayList<>();
        PreparedStatement preparedStatement = getPrepareStatement(SELECT_ALL_Mobile_Operations);
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                MobileOperations mobOperations = new MobileOperations();

                mobOperations.setMobileOperationId(resultSet.getInt("id"));
                mobOperations.setMobilePhone(resultSet.getString("mobile_phone"));
                mobOperations.setClientName(resultSet.getString("name"));
                mobOperations.setClientSurname(resultSet.getString("surname"));
                mobOperations.setSum(resultSet.getString("Sum"));

                Mobile_Operations.add(mobOperations);
            }

        } catch (SQLException e) {
            logger.error("", e);
        } finally {
            closePrepareStatement(preparedStatement);
        }

        return Mobile_Operations;
    }

    @Override
    public Optional<MobileOperations> getEntityById(Long id) {
        final String FIND_BY_ID = "SELECT * FROM bank_terminal.mobile_operations WHERE id='" + id + "'";

        MobileOperations mobOperations = null;
        PreparedStatement preparedStatement = null;
        try {
            try {
                ResultSet resultSet = null;
                try {
                    preparedStatement = getPrepareStatement(FIND_BY_ID);
                    resultSet = preparedStatement.executeQuery();

                    while (resultSet.next()) {
                        mobOperations = new MobileOperations();

                        mobOperations.setMobileOperationId(resultSet.getInt("id"));
                        mobOperations.setMobilePhone(resultSet.getString("mobile_phone"));
                        mobOperations.setClientName(resultSet.getString("name"));
                        mobOperations.setClientSurname(resultSet.getString("surname"));
                        mobOperations.setSum(resultSet.getString("Sum"));
                    }

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

        return Optional.ofNullable(mobOperations);
    }

    @Override
    public MobileOperations update(MobileOperations entity) {
        final String UPDATE_Mobile_Operation = "UPDATE bank_terminal.mobile_operations SET mobile_phone = '" + entity.getMobilePhone()
                + "', name = '" + entity.getClientName()
                + "', surname =  '" + entity.getClientSurname()
                + "', Sum =  '" + entity.getSum()
                + "' WHERE id = " + entity.getMobileOperationId();

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getPrepareStatement(UPDATE_Mobile_Operation);
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
        final String DELETE_Mobile_Operation = "DELETE FROM bank_terminal.mobile_operations WHERE id = " + id;

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getPrepareStatement(DELETE_Mobile_Operation);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            logger.error("", throwables);
        } finally {
            closePrepareStatement(preparedStatement);
        }

        return true;
    }

    @Override
    public boolean create(MobileOperations entity) {
        final String INSERT_Mobile_Operation = "INSERT INTO bank_terminal.mobile_operations (mobile_phone, name, surname, Sum) values ('"
                + entity.getMobilePhone()
                + "', '" + entity.getClientName()
                + "', '" + entity.getClientSurname()
                + "', '" + entity.getSum() + "')";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getPrepareStatement(INSERT_Mobile_Operation);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            logger.error("", throwables);
        } finally {
            closePrepareStatement(preparedStatement);
        }

        return true;
    }
}
