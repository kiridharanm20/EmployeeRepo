import java.util.Scanner;

class EmployeeView {

    Scanner sc = new Scanner(System.in);

    // Menu
    void menu() {

        System.out.println("\n--- Employee Menu ---");
        System.out.println("1. Add Employee");
        System.out.println("2. Display Employees");
        System.out.println("3. Search Employee");
        System.out.println("4. Update Salary");
        System.out.println("5. Delete Employee");
        System.out.println("6. Exit");
    }

    // Get Menu Choice
    int getChoice() {

        System.out.print("Enter Choice: ");
        return sc.nextInt();
    }

    // Get Employee Details
    Employee getEmployee() {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        return new Employee(id, name, salary);
    }

    // Get ID
    int getId() {

        System.out.print("Enter ID: ");
        return sc.nextInt();
    }

    // Get Salary
    double getSalary() {

        System.out.print("Enter New Salary: ");
        return sc.nextDouble();
    }
}