package com.mycompany.util;

import com.mycompany.exception.ConnectionPoolException;
import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class ConnectionPool {
    private Vector<Connection> availableConns = new Vector<Connection>();
    private Vector<Connection> usedConns = new Vector<Connection>();

    private final int INIT_COUNT_CNT = 10;
    private final String USERNAME = "root";
    private final String PASSWORD = "Gomer0013";
    private final String URL = "jdbc:mysql://localhost:3306/bank_terminal?serverTimezone=UTC";//mysql?serverTimezone=UTC";

    public static final ConnectionPool CONNECTION_POOL = new ConnectionPool();

    /**
     * попробовать без регистрации райвера
     */
    private ConnectionPool() {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < INIT_COUNT_CNT; i++) {
            availableConns.addElement(getConnection());
        }
    }

    private Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public synchronized Connection retrieve() throws SQLException {
        Connection newConn = null;
        if (availableConns.size() == 0) {
            newConn = getConnection();
        } else {
            newConn = (Connection) availableConns.lastElement();
            availableConns.removeElement(newConn);
        }
        usedConns.addElement(newConn);
        return newConn;
    }

    public synchronized void putback(Connection c) throws ConnectionPoolException {
        if (c != null) {
            if (usedConns.removeElement(c)) {
                availableConns.addElement(c);
            } else {
                throw new ConnectionPoolException("Connection not in the usedConns");
            }
        }
    }

    public int getAvailableConnsCnt() {
        return availableConns.size();
    }
}
