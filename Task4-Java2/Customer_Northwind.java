package session42;
import java.sql.*;
import java.util.Scanner;

public class Customer_Northwind {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind","root","");
                Statement stmt= conn.createStatement();
        ){
            String strSelect = "select CustomerId, CompanyName, ContactName, ContactTitle, Address from customers";
            System.out.println("The SQl statemetnt is:"+strSelect+"\n");
            ResultSet rest = stmt.executeQuery(strSelect);

            System.out.println("The records selected are:");
            int rowCount=0;
            while (rest.next()){
                String customerid = rest.getString("CustomerId");
                String companyname = rest.getString("CompanyName");
                String contactname = rest.getString("ContactName");
                String contacttitle = rest.getString("ContactTitle");
                String address= rest.getString("Address");
                System.out.println(customerid+" , "+companyname+" , "+contactname+" , "+contacttitle+" , "+address);
                ++rowCount;
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}

