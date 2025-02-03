package EntityList;
import Entity.Employee;

public class EmployeeList {
    private Employee employees[];

    public EmployeeList() {
        employees = new Employee[10]; 
    }

    public EmployeeList(int size) {
        employees = new Employee[size]; 
    }

    public void insert(Employee ee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = ee;
                System.out.println("Successfully Inserted :)");
                return;  
            }
        }
        System.out.println("Insertion Failed :(");
    }

    public Employee getById(String employeeId) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getEmployeeId().equals(employeeId)) {
                System.out.println("Employee found :)");
                return employees[i]; 
            }
        }
        System.out.println("No employee with this ID :(");
        return null;
    }

    public void removeById(String employeeId) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getEmployeeId().equals(employeeId)) {
                employees[i] = null; 
                System.out.println("Successfully Removed.");
                return; 
            }
        }
        System.out.println("Failed to Remove. (Recheck Id)!");
    }

    public void showAll() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println("--------------------------------");
                employees[i].showAll();
                System.out.println("--------------------------------");
            }
        }
    }

    public String getAllEmployeeAsString() {
        String allEmployee = "";
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                allEmployee += "--------------\n" +
                    employees[i].getEmployeeAsString() + "\n" +
                    "--------------\n";
            }
        }
        return allEmployee;  
    }
}
