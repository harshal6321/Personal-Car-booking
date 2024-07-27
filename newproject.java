import java.sql.*;
import java.util.Scanner;

public class newproject {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/car";
    private static final String username = "root";
    private static final String password = "Harshal@6321";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            while (true) {
                System.out.println();
                System.out.println("---++-------------+++++-----WELLCOME CARTAXI APPLICATION-----+++++-------------++---");
//                Scanner scanner = new Scanner(System.in);



                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter Full Name :-");
                String customer_fullname = scanner.next();
                scanner.nextLine();

                System.out.println("Enter Contact_Number:-");
                String Contact_Number = scanner.next();
                scanner.nextLine();

                System.out.println("Enter Pic-Up add:-");
                String Picup_Address = scanner.next();
                scanner.nextLine();

                System.out.println("Enter Dropping add:-");
                String Droping_Address = scanner.next();
                scanner.nextLine();

                System.out.println("Choose Dropping AND Pic-Up");
                String Dropping_AND_Picup = scanner.next();
                scanner.nextLine();

                System.out.println("Enter You State");
                String Customer_State = scanner.next();


                String query = "INSERT INTO cartaxi (customer_fullname, customer_contactnum, picup_address, droping_address, dropping_and_picup, costomer_state) VALUES ('" + customer_fullname + "', " + Contact_Number + ", '" + Picup_Address + "', '" + Droping_Address + "', '" + Dropping_AND_Picup + "', '" + Customer_State + "')";
                try (Statement statement = connection.createStatement()) {
                    int rowAffected = statement.executeUpdate(query);
                    if (rowAffected > 0) {
                        System.out.println("Car Book SuccessFully");
                    } else {
                        System.out.println("Car Not Booked");
                    }
                } catch (SQLException E) {
                    E.printStackTrace();
                }
                System.out.println("-----------+++++----------Thank You For Using This Application---------+++++---------");
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}





