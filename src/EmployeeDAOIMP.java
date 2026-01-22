import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDAOIMP implements EmployeeDAO {

    // ================= CREATE =================
    @Override
    public void addEmployee(EmployeeDTO emp) {
        String sql = "INSERT INTO employees (name, email, department, salary) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, emp.getName());
            ps.setString(2, emp.getEmail());
            ps.setString(3, emp.getDepartment());
            ps.setDouble(4, emp.getSalary());

            ps.executeUpdate();
            System.out.println("Employee added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= READ =================
    @Override
    public void getAllEmployees() {
        String sql = "SELECT emp_id, name, email, department, salary FROM employees";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("\n--- Employee List ---");
            System.out.println("ID | Name | Email | Department | Salary");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("emp_id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("email") + " | " +
                        rs.getString("department") + " | " +
                        rs.getDouble("salary")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= READ (Find by ID) =================
    @Override
    public void getEmployeeById(int empId) {
        String sql = "SELECT emp_id, name, email, department, salary FROM employees WHERE emp_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, empId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("\n--- Employee Details ---");
                System.out.println("ID         : " + rs.getInt("emp_id"));
                System.out.println("Name       : " + rs.getString("name"));
                System.out.println("Email      : " + rs.getString("email"));
                System.out.println("Department : " + rs.getString("department"));
                System.out.println("Salary     : " + rs.getDouble("salary"));
            } else {
                System.out.println("Employee not found with ID: " + empId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= UPDATE =================
    @Override
    public void updateEmployee(EmployeeDTO emp) {

        String fetchSql = "SELECT name, email, department, salary FROM employees WHERE emp_id = ?";
        String updateSql = "UPDATE employees SET name = ?, email = ?, department = ?, salary = ? WHERE emp_id = ?";

        try (Connection con = DBConnection.getConnection()) {

            // 1️⃣ Fetch existing data
            PreparedStatement fetchPs = con.prepareStatement(fetchSql);
            fetchPs.setInt(1, emp.getEmpId());
            ResultSet rs = fetchPs.executeQuery();

            if (!rs.next()) {
                System.out.println("Employee not found!");
                return;
            }

            String name = emp.getName() != null && !emp.getName().isEmpty()
                    ? emp.getName() : rs.getString("name");

            String email = emp.getEmail() != null && !emp.getEmail().isEmpty()
                    ? emp.getEmail() : rs.getString("email");

            String department = emp.getDepartment() != null && !emp.getDepartment().isEmpty()
                    ? emp.getDepartment() : rs.getString("department");

            double salary = emp.getSalary() > 0
                    ? emp.getSalary() : rs.getDouble("salary");

            // 2️⃣ Update with merged data
            PreparedStatement updatePs = con.prepareStatement(updateSql);

            updatePs.setString(1, name);
            updatePs.setString(2, email);
            updatePs.setString(3, department);
            updatePs.setDouble(4, salary);
            updatePs.setInt(5, emp.getEmpId());

            updatePs.executeUpdate();
            System.out.println("Employee updated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // ================= DELETE =================
    @Override
    public void deleteEmployee(int empId) {
        String sql = "DELETE FROM employees WHERE emp_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, empId);

            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Employee deleted successfully!");
            else
                System.out.println("Employee not found!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
