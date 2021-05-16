package session42;
import java.sql.*;
public class Product_Northwind {
    public static void main(String[] args) {
        try(
                Connection nht= DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind","root","");
                Statement thn= nht.createStatement();
        ){
            String select ="select ProductID, ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice from products";
            System.out.println("The SQL statement is: "+select+"\n");
            ResultSet htn= thn.executeQuery(select);
            int count =0;
            while (htn.next()){
                int productid= htn.getInt("ProductID");
                String productname= htn.getString("ProductName");
                int supplierid= htn.getInt("SupplierID");
                int categoryid =htn.getInt("CategoryID");
                String quantityperunit= htn.getString("QuantityPerUnit");
                double unitprice= htn.getDouble("UnitPrice");
                count++;
                System.out.println(productid+" ,"+productname+" ,"+supplierid+" ,"+categoryid+" ,"+quantityperunit+" ,"+unitprice);
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}

