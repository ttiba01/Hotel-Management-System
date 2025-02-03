package Files;
import java.io.*;
import java.util.Scanner;
import Entity.*;
import EntityList.*;
import GUI.RegistrationFormEmployee;
import java.io.IOException;
import GUI.EmployeeManagementPage;

public class FileIOemployee{
	
	public static boolean checkUser(String userName,String pass){
		boolean flag = false;
		try{
			Scanner fsc = new Scanner(new File("./Files/user.txt"));
			while(fsc.hasNextLine()){
				String line = fsc.nextLine();
				String data[] = line.split(";");
				if(userName.equals(data[0]) && pass.equals(data[2])){
					flag = true;
					break;
				}
			}
			fsc.close();
		}
		catch(Exception ex){
			System.out.println("Cannot Read File");
		}
		return flag;
	}
	
	Employee ee = new Employee();
	public static void writeEmployeeInFile(Employee ee){
		try{
			FileWriter fw = new FileWriter(new File("./Files/employee.txt" ),true);
			String line = ee.getEmployeeId()+";"+ee.getEmployeeName()+";"+ee.getEmployeePosition()+";"+ee.getEmployeeSalary()+"\n";
			fw.write(line);
			fw.flush();
			fw.close();
		}
		catch(Exception ex){
			System.out.println("File Not Found");
		}
	}
	
	
	
	public static void loadEmployeeFromFile(EmployeeList employeeList) {
    try {
        Scanner sc = new Scanner(new File("./Files/employee.txt"));
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] data = line.split(";");
            Employee tempE = new Employee(data[0], data[1], data[2], Integer.parseInt(data[3]));
            employeeList.insert(tempE);  
        }
        sc.close();
    } catch (Exception ex) {
        System.out.println("Cannot Read File");
    }
}

     public static void removeEmployeeFromFile(String employeeId) {
    String filePath = "./Files/employee.txt";
    File inputFile = new File(filePath);
    File tempFile = new File("./Files/tempBooks.txt"); // Ensure temp file is in the same directory

    try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
         BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

        String presentLine;

        while ((presentLine = reader.readLine()) != null) {
            String[] employeeDetails = presentLine.split(";");
            if (!employeeDetails[0].equals(employeeId)) {
                writer.write(presentLine + System.lineSeparator());
            }
        }

    } catch (IOException e) {
        System.out.println("An error occurred: ");
    }
    if (inputFile.delete()) {
        if (!tempFile.renameTo(inputFile)) {
            System.out.println("Error: Could not rename temp file to original file name.");
        }
    } else {
        System.out.println("Error: Could not delete the original file.");
    }
}

}