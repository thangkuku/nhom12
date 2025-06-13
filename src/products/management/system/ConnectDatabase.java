package products.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/productmanagement";
            String user = "root"; // 
            String pass = "";

            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Kết nối thành công!");

        } catch (SQLException e) {
            System.out.println("Kết nối thất bại!");
            e.printStackTrace();
        }

        return conn;
    }
}
