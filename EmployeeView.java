import java.util.Scanner;

public class EmployeeView {

    Scanner sc = new Scanner(System.in);

    void showMenu() {

        System.out.println("\n--- Employee Menu ---");
        System.out.println("1. Display Employees");
        System.out.println("2. Search Employee");
        System.out.println("3. Update Salary");
        System.out.println("4. Delete Employee");
        System.out.println("5. Exit");
    }

    int getChoice() {

        System.out.print("Enter choice: ");
        return sc.nextInt();
    }

    int getId(String msg) {

        System.out.print(msg);
        return sc.nextInt();
    }

    double getSalary(String msg) {

        System.out.print(msg);
        return sc.nextDouble();
    }

    void displayEmployees(Employee[] employees, int count) {

        System.out.println("\nEmployee Details:");

        for (int i = 0; i < count; i++) {

            System.out.println(
                    employees[i].id + " - " +
                    employees[i].name + " - ₹" +
                    employees[i].salary
            );
        }
    }

    void showMessage(String msg) {
        System.out.println(msg);
    }
}
