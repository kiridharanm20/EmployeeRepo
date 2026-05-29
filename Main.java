public class Main {

    public static void main(String[] args) {

        EmployeeController controller =
                new EmployeeController();

        EmployeeView view =
                new EmployeeView();

        while (true) {

            view.menu();

            int ch = view.getChoice();

            switch (ch) {

                case 1:

                    Employee e = view.getEmployee();

                    controller.addEmployee(e);

                    break;

                case 2:

                    controller.displayEmployees();

                    break;

                case 3:

                    controller.searchEmployee(view.getId());

                    break;

                case 4:

                    int id = view.getId();

                    double sal = view.getSalary();

                    controller.updateSalary(id, sal);

                    break;

                case 5:

                    controller.deleteEmployee(view.getId());

                    break;

                case 6:

                    System.out.println("Exiting...");
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}