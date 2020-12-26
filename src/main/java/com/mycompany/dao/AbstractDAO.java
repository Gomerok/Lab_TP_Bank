package com.mycompany.dao;

import com.mycompany.domain.Entity;
import com.mycompany.exception.ConnectionPoolException;
import com.mycompany.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDAO<K, E extends Entity> {
    private ConnectionPool connectionPool;
    private Connection connection;

    public AbstractDAO() throws SQLException {
        connectionPool = ConnectionPool.CONNECTION_POOL;
        connection = connectionPool.retrieve();
    }

    public abstract List<E> getAll();
    public abstract Optional<E> getEntityById(K id);
    public abstract E update(E entity);
    public abstract boolean delete(K id);
    public abstract boolean create(E entity);

    protected void returnConnectionInPool() throws ConnectionPoolException {
        connectionPool.putback(connection);
    }

    protected PreparedStatement getPrepareStatement(String sql) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ps;
    }

    protected void closePrepareStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
