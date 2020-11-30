package DataBase;

import java.sql.PreparedStatement;
import java.sql.*;

public class DatabaseHandler extends Configs{

  Connection dbConnection;

  public Connection getDbConnection(){
      String url = "jdbc:mysql://localhost:3306/terminal?serverTimezone=UTC";
      try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          dbConnection=DriverManager.getConnection(url,dbUser,dbPass);
      } catch (ClassNotFoundException e) {
          e.printStackTrace();
      } catch (SQLException e1) {
          e1.printStackTrace();
      }
      return  dbConnection;
  }

public void signUpUser(String name,String surname,String login,String password){
  String insert = "INSERT INTO "+ Const.USER_TABLE+
          "("+Const.USERS_NAME+","+Const.USERS_SURNAME+","+Const.USERS_LOGIN+","+Const.USERS_PASSWORD+")"+"VALUES(?,?,?,?)";

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

    public String SelectUser(String insert){
        try {
            Statement St = getDbConnection().createStatement();
            ResultSet rs = St.executeQuery(insert);
String Name = rs.getString(1);
            return Name;
        } catch (SQLException e2) {
            e2.printStackTrace();
        }

    }

}

