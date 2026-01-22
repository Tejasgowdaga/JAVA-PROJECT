public class EmployeeDTO {

    private int empId;
    private String name;
    private String email;
    private String department;
    private double salary;

    // No-arg constructor (important for frameworks & flexibility)
    public EmployeeDTO() {
    }

    // Constructor without ID (used while creating employee)
    public EmployeeDTO(String name, String email, String department, double salary) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
    }

    // Constructor with ID (used while updating employee)
    public EmployeeDTO(int empId, String name, String email, String department, double salary) {
        this.empId = empId;
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
