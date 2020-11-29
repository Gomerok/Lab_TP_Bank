package DataBase;

import java.sql.*;
import java.sql.PreparedStatement;

public class DatabaseHandler extends Configs {

    Connection dbConnection;

//    public Connection getDbConnection(){
//           // throws ClassNotFoundException, SQLException{
//        String url = "jdbc:mysql://localhost:3306/terminal?serverTimezone=UTC";
//        String username = "root";
//        String password = "Gomer0013";
//        System.out.println("Check1");
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            dbConnection = DriverManager.getConnection(url, username, password);
//            System.out.println("Check2");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return dbConnection;
//    }

    public void signUpUser(String name,String surname,String login,String password)
    {
        System.out.println("Check3");
        String url = "jdbc:mysql://localhost:3306/terminal?serverTimezone=UTC";
        String username = "root";
        String pasword = "Gomer0013";
        System.out.println("Check1");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection(url, username, pasword);
            System.out.println("Check2");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            String insert = "INSERT INTO users (name,surname,login,password) VALUES(?,?,?,?)";
//        insert = "INSERT INTO" + Const.USER_TABLE + "(" +
//                Const.USERS_NAME  + Const.USERS_SURNAME  + Const.USERS_LOGIN  + Const.USERS_PASSWORD + ")" +
//                "VALUES(?,?,?,?)";
            System.out.println("Check4");
            PreparedStatement prSt = dbConnection.prepareStatement(insert);
            prSt.setString(1, name);
            prSt.setString(2, surname);
            prSt.setString(3, login);
            prSt.setString(4, password);
            System.out.println("Check4444");
            prSt.executeUpdate();
            System.out.println("Check666");
//prSt.close();
        } catch (SQLException e)
        {
            System.out.println("Check666999");
            e.printStackTrace();
        }
        System.out.println("Check5");
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