public interface EmployeeDAO {

    // CREATE
    void addEmployee(EmployeeDTO emp);

    // READ
    void getAllEmployees();

    void getEmployeeById(int empId);

    // UPDATE
    void updateEmployee(EmployeeDTO emp);

    // DELETE
    void deleteEmployee(int empId);
}
