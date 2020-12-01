package DataBase;

import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseHandler extends Configs {

    Connection dbConnection;

    public Connection getDbConnection() {
        String url = "jdbc:mysql://localhost:3306/terminal?serverTimezone=UTC";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection(url, dbUser, dbPass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return dbConnection;
    }

    public void signUpUser(String name, String surname, String login, String password) {
        String insert = "INSERT INTO " + Const.USER_TABLE +
                "(" + Const.USERS_NAME + "," + Const.USERS_SURNAME + "," + Const.USERS_LOGIN + "," + Const.USERS_PASSWORD + ")" + "VALUES(?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);

            prSt.setString(1, name);
            prSt.setString(2, surname);
            prSt.setString(3, login);
            prSt.setString(4, password);
            prSt.executeUpdate();
            prSt.close();

        } catch (SQLException e2) {
            e2.printStackTrace();
        }

    }

    public ArrayList<String> SelectUser(String insert, int n, String namer) {

        ArrayList<String> uspas = new ArrayList<>();


        try {
            if (n == 1) {
                PreparedStatement prepStat = getDbConnection().prepareStatement(insert);
                ResultSet rs = prepStat.executeQuery();
                while (rs.next()) {
                    uspas.add(0, rs.getString("name"));
                    uspas.add(1, rs.getString("password"));
                }
            } else {
                PreparedStatement preparedStatement = getDbConnection().prepareStatement("SELECT name,password FROM terminal.users where (name=?)");
                preparedStatement.setString(1, namer);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    uspas.add(0, resultSet.getString("name"));
                    uspas.add(1, resultSet.getString("password"));
                }
            }
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
        System.out.println(uspas.get(0));
        System.out.println(uspas.get(1));

        return uspas;
    }

}

