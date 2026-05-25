public class EmployeeController {

    Employee[] employees;
    int count;

    EmployeeController(int size) {

        employees = new Employee[size];
        count = 0;
    }

    void addEmployee(int id, String name, double salary) {

        employees[count++] =
                new Employee(id, name, salary);
    }

    Employee[] getEmployees() {
        return employees;
    }

    int getCount() {
        return count;
    }

    Employee findEmployee(int id) {

        for (int i = 0; i < count; i++) {

            if (employees[i].id == id) {
                return employees[i];
            }
        }

        return null;
    }

    String updateSalary(int id, double newSalary) {

        Employee e = findEmployee(id);

        if (e == null)
            return "Employee Not Found";

        e.salary = newSalary;

        return "Salary Updated Successfully";
    }

    String deleteEmployee(int id) {

        for (int i = 0; i < count; i++) {

            if (employees[i].id == id) {

                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }

                count--;

                return "Employee Deleted Successfully";
            }
        }

        return "Employee Not Found";
    }
}
