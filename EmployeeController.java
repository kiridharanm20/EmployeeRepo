
import java.sql.*;
public class EmployeeController {
    Connection con;
    EmployeeController() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employee_db",
                    "root",
                    "Welcome@123"
            );

            System.out.println("Database Connected");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Add Employee
    void addEmployee(Employee e) {

        try {

            String query =
                    "INSERT INTO employee VALUES (?, ?, ?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, e.id);
            ps.setString(2, e.name);
            ps.setDouble(3, e.salary);

            ps.executeUpdate();

            System.out.println("Employee Added");

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    // Display Employees
    void displayEmployees() {

        try {

            String query = "SELECT * FROM employee";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            System.out.println("\nEmployee Details:");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " - " +
                        rs.getString("name") + " - ₹" +
                        rs.getDouble("salary")
                );
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Search Employee
    void searchEmployee(int id) {

        try {

            String query =
                    "SELECT * FROM employee WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " - " +
                        rs.getString("name") + " - ₹" +
                        rs.getDouble("salary")
                );

            } else {
                System.out.println("Employee Not Found");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Update Salary
    void updateSalary(int id, double salary) {

        try {

            String query =
                    "UPDATE employee SET salary=? WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setDouble(1, salary);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Salary Updated");
            else
                System.out.println("Employee Not Found");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Delete Employee
    void deleteEmployee(int id) {

        try {

            String query =
                    "DELETE FROM employee WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Employee Deleted");
            else
                System.out.println("Employee Not Found");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
