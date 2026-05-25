public class Main {
    public static void main(String[] args) {

        EmployeeController controller =
                new EmployeeController(10);

        EmployeeView view =
                new EmployeeView();

        controller.addEmployee(101, "Kiran", 30000);
        controller.addEmployee(102, "Arun", 35000);
        controller.addEmployee(103, "Priya", 40000);

        while (true) {

            view.showMenu();

            int choice = view.getChoice();

            switch (choice) {

                case 1:

                    view.displayEmployees(
                            controller.getEmployees(),
                            controller.getCount()
                    );

                    break;

                case 2:

                    int searchId =
                            view.getId("Enter Employee ID: ");

                    if (controller.findEmployee(searchId) != null)
                        view.showMessage("Employee Found");
                    else
                        view.showMessage("Employee Not Found");

                    break;

                case 3:

                    int updateId =
                            view.getId("Enter Employee ID: ");

                    double salary =
                            view.getSalary("Enter New Salary: ");

                    view.showMessage(
                            controller.updateSalary(updateId, salary)
                    );

                    break;

                case 4:

                    int deleteId =
                            view.getId("Enter Employee ID: ");

                    view.showMessage(
                            controller.deleteEmployee(deleteId)
                    );

                    break;

                case 5:

                    System.out.println("Exiting...");
                    return;

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}
