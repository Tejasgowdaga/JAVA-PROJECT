import java.util.Scanner;

public class EmployeeManagementApp {

    public static void main(String[] args) {

        // Interface reference, implementation object (BEST PRACTICE)
        EmployeeDAO dao = new EmployeeDAOIMP();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Employee Management System ====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee Details");
            System.out.println("4. Delete Employee");
            System.out.println("5. Find Employee by ID");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine(); // consume newline

                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter department: ");
                    String department = sc.nextLine();

                    System.out.print("Enter salary: ");
                    double salary = sc.nextDouble();

                    EmployeeDTO empDTO =
                            new EmployeeDTO(name, email, department, salary);

                    dao.addEmployee(empDTO);
                    break;

                case 2:
                    dao.getAllEmployees();
                    break;

                case 3:
                    System.out.print("Enter employee ID: ");
                    int updateEmpId = sc.nextInt();
                    sc.nextLine(); // consume newline

                    System.out.print("Enter new name (press Enter to skip): ");
                    String updatedName = sc.nextLine();

                    System.out.print("Enter new email (press Enter to skip): ");
                    String updatedEmail = sc.nextLine();

                    System.out.print("Enter new department (press Enter to skip): ");
                    String updatedDepartment = sc.nextLine();

                    System.out.print("Enter new salary (press Enter to skip): ");
                    String salaryInput = sc.nextLine();

                    double updatedSalary = 0; // default → means "no update"
                    if (!salaryInput.isEmpty()) {
                        updatedSalary = Double.parseDouble(salaryInput);
                    }

                    EmployeeDTO updatedEmployee = new EmployeeDTO();
                    updatedEmployee.setEmpId(updateEmpId);
                    updatedEmployee.setName(updatedName);
                    updatedEmployee.setEmail(updatedEmail);
                    updatedEmployee.setDepartment(updatedDepartment);
                    updatedEmployee.setSalary(updatedSalary);

                    dao.updateEmployee(updatedEmployee);
                    break;


                case 4:
                    System.out.print("Enter employee ID: ");
                    int deleteId = sc.nextInt();
                    dao.deleteEmployee(deleteId);
                    break;

                case 5:
                    System.out.print("Enter employee ID: ");
                    int searchId = sc.nextInt();
                    dao.getEmployeeById(searchId);
                    break;

                case 6:
                    System.out.println("Exiting Employee Management System...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
