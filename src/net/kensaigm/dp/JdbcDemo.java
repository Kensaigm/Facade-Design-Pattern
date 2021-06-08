package net.kensaigm.dp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {
    public static void main(String[] args) {
        net.kensaigm.dp.DbSingleton instance = net.kensaigm.dp.DbSingleton.getInstance();

        try {
            Connection conn = instance.getConnection();
            Statement statement = conn.createStatement();
            int count = statement.executeUpdate("CREATE TABLE Address (ID INT, StreetName VARCHAR(40),"
                     + " City VARCHAR(25), State CHAR(2), Zip CHAR(10))");

            System.out.println("Table created.");
            statement.close();

            statement = conn.createStatement();
            count = statement.executeUpdate("INSERT INTO Address (ID, StreetName, City, State, Zip) "
            + "VALUES (1, '42 Main Street', 'Sandwich', 'IL', '60548')");
            System.out.println(count + " record(s) created.");
            statement.close();

            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Address");

            while(rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3)
                + " " + rs.getString(4) + " " + rs.getString(5));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

    }

}
