package Entity;

public class Employee{
    private String employeeId;
    private String employeeName;
    private String employeePosition;
    private int employeeSalary;
 
    public Employee() {}
 
    public Employee(String employeeId, String employeeName, String employeePosition, int employeeSalary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeePosition = employeePosition;
        this.employeeSalary = employeeSalary;
    }
 
    public void setEmployeeId(String employeeId){
        this.employeeId = employeeId;
    }
	
	public String getEmployeeId(){
        return employeeId;
    }
 
    public void setEmployeeName(String employeeName){
        this.employeeName = employeeName;
    }
	
	public String getEmployeeName(){
        return employeeName;
    }
 
    public void setEmployeePosition(String employeePosition){
        this.employeePosition = employeePosition;
    }
	
	public String getEmployeePosition(){
        return employeePosition;
    }
 
    public void setEmployeeSalary(int employeeSalary){
        this.employeeSalary = employeeSalary;
    }
	
	public int getEmployeeSalary(){
        return employeeSalary;
    }
 
    public void showAll(){
        System.out.println("Employee Id: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Employee Position: " + employeePosition);
        System.out.println("Employee Salary: " + employeeSalary);
    }
		
	public String getEmployeeAsString()
	{ 
	String ssss ="Employee Id : "+employeeId +"\n"+ 
	"Employee Name : "+employeeName+"\n"+ 		
	"Employee Position : "+employeePosition+"\n"+ 		
	"Employee Salary : "+employeeSalary; 	
	return ssss; 	
	}
}