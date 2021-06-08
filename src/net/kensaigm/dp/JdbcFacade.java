package net.kensaigm.dp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcFacade {

    DbSingleton instance = null;

    public JdbcFacade(){
        instance = DbSingleton.getInstance();
    }

    public int createTable() {
        int count = 0;
        try {
            Connection conn = instance.getConnection();
            Statement statement = conn.createStatement();
            count = statement.executeUpdate("CREATE TABLE Address (ID INT, StreetName VARCHAR(40),"
                    + " City VARCHAR(25), State CHAR(2), Zip CHAR(10))");
            // statement.close();
            // conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return count;
    }

    public int insertIntoTable(){
        int count = 0;
        try {
            Connection conn = instance.getConnection();
            Statement statement = conn.createStatement();
            count = statement.executeUpdate("INSERT INTO Address (ID, StreetName, City, State, Zip) "
                    + "VALUES (1, '42 Main Street', 'Sandwich', 'IL', '60548')");
            // statement.close();
            // conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return count;
    }

    public List<Address> getAddresses(){
        List<Address> addresses = new ArrayList<>();

        try {
            Connection conn = instance.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Address");

            while(rs.next()){
                System.out.println(rs.getString(1) + "\t" + rs.getString(2)
                        + "\t" + rs.getString(3) + "\t" + rs.getString(4)
                        + "\t" + rs.getString(5));
                Address address = new Address();
                address.setId(rs.getString(1));
                address.setStreetName(rs.getString(2));
                address.setCity(rs.getString(3));
                address.setState(rs.getString(4));
                address.setZip(rs.getString(5));

                addresses.add(address);
            }

            // rs.close();
            // statement.close();
            // conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

        return addresses;
    }
}
