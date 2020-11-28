package DataBase;

import java.sql.*;
import java.sql.PreparedStatement;

public class DatabaseHandler extends Configs {

    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException{
        String url = "jdbc:mysql://localhost:3306/terminal?serverTimezone=UTC";
        String username = "root";
        String password = "Gomer0013";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(url, username, password);

        return dbConnection;
    }
    public void signUpUser(String name,String surname,String login,String password)
    {
        String insert;
        insert = "INSERT INTO" + Const.USER_TABLE + "(" +
                Const.USERS_NAME  + Const.USERS_SURNAME  + Const.USERS_LOGIN  + Const.USERS_PASSWORD + ")" +
                "VALUES(?,?,?,?)";


        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, name);
            prSt.setString(2, surname);
            prSt.setString(3, login);
            prSt.setString(4, password);

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}



//        try {
//        Statement statement = dbConnection.createStatement();
//        int rows = statement.executeUpdate("INSERT terminal(name,surname ,login,password) VALUES ('sdcac', 'dscdc','sdcdcsd','sdcsdc')," +
//        "('sdcac', 'dscdc','sdcdcsd','sdcsdc'), ('sdcac', 'dscdc','sdcdcsd','sdcsdc')");
//        System.out.printf("Added %d rows", rows);
//        }
//
//        catch(Exception ex){
//        System.out.println("Connection failed...");
//
//        System.out.println(ex);
//        }




//try{
//        String url = "jdbc:mysql://localhost:3306/terminal?serverTimezone=UTC";
//        String username = "root";
//        String password = "Gomer0013";
//        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//
//        try (Connection conn = DriverManager.getConnection(url, username, password)){
//
//        Statement statement = conn.createStatement();
//        int rows = statement.executeUpdate("INSERT terminal(name,surname ,login,password) VALUES ('sdcac', 'dscdc','sdcdcsd','sdcsdc')," +
//        "('sdcac', 'dscdc','sdcdcsd','sdcsdc'), ('sdcac', 'dscdc','sdcdcsd','sdcsdc')");
//        System.out.printf("Added %d rows", rows);
//        }
//        }
//        catch(Exception ex){
//        System.out.println("Connection failed...");
//
//        System.out.println(ex);
//        }