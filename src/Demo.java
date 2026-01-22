//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//public class Demo {
//    public static void main(String[] args) {
//        String sql = "SELECT name FROM employees"; // Only select the name column
//        String uri = "jdbc:postgresql://localhost:5432/employee_db";
//        String username = "postgres";
//        String password = "password";
//
//        try {
//            // Establish connection
//            Connection con = DriverManager.getConnection(uri, username, password);
//
//            // Create statement
//            Statement st = con.createStatement();
//
//            // Execute query
//            ResultSet rs = st.executeQuery(sql);
//
//            // Loop through the result set and print names
//            while (rs.next()) {
//                String name = rs.getString("name"); // You can also use rs.getString(1)
//                System.out.println(name);
//            }
//
//            // Close resources
//            rs.close();
//            st.close();
//            con.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
