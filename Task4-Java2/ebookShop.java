package session32;
import java.sql.*;
public class ebookShop {
    public static void main(String[] args) {
        try (
                Connection myla = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop","root","");
                Statement tiger= myla.createStatement();
        ){
            String strSelect = "select id, author, title, price, qty from books";
            System.out.println("The SQl statement is:"+strSelect+"\n");
            ResultSet corp = tiger.executeQuery(strSelect);

            System.out.println("The records selected are:");
            int rowCount=0;
            while (corp.next()){
                int id = corp.getInt("id");
                String author = corp.getString("author");
                String title = corp.getString("title");
                double price = corp.getDouble("price");
                int qty= corp.getInt("qty");
                System.out.println(id+","+author+","+title+","+price+","+qty);
                ++rowCount;
                if (author=="Nguyen Huy Thuat"){
                    System.out.println(title+","+price);
                }
            }
            System.out.println("Total number of records = "+rowCount);
            System.out.println("");
            //bai1
            String strSelect2= "select title,price from books where author = 'Nguyen Huy Thuat' ";
            System.out.println("The SQL statement is:"+strSelect2+"\n");
            ResultSet corp2 =tiger.executeQuery(strSelect2);
            int rowCount1=0;
            while (corp2.next()){
                String title = corp2.getString("title");
                double price = corp2.getDouble("price");
                System.out.println(title+","+price);
                ++rowCount1;
            }
            //y 3
            String strSelect3="select title, author, price, qty from books where author='Nguyen Huy Thuat' or price>=30 order by price DESC, id ASC";
            System.out.println("The SQL statement is:"+strSelect3);
            ResultSet corp3=tiger.executeQuery(strSelect3);
            int rowCount2=0;
            while (corp3.next()){
                String author = corp3.getString("author");
                String title = corp3.getString("title");
                double price = corp3.getDouble("price");
                int qty= corp3.getInt("qty");
                System.out.println(author+","+title+","+price+","+qty);
                ++rowCount2;
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
