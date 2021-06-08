package net.kensaigm.dp;

import java.util.List;

public class FacadeJdbcDemo {
    public static void main(String[] args) {

        JdbcFacade jdbcFacade = new JdbcFacade();

        int tableStatus = jdbcFacade.createTable();

        if (tableStatus != 0){
            System.out.println("Table created.");
        } else {
            System.out.println("Unable to create table.");
        }

        int tableInsert = jdbcFacade.insertIntoTable();

        if (tableInsert != 0){
            System.out.println("Record inserted.");
        } else {
            System.out.println("Unable to insert record.");
        }

        List<Address> addresses = jdbcFacade.getAddresses();

        for (Address address : addresses){
            System.out.println(address.getId() + "\t" + address.getStreetName()
            + "\t" + address.getCity() + "\t" + address.getState()
            + "\t" + address.getZip());
        }
    }
}
