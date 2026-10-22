
public abstract class LibraryStaff extends Person{
	//This are the values i am taking 
	    private static int staffCount = 0;

	    protected final String staffId;
	    protected final String department;
	    protected final double monthlySalary;

	    public LibraryStaff(String personId, String name, String phoneNumber, String staffId, String department, double monthlySalary) {
	        //This values i am takeing from parent class. I use super methode.
	    	super(personId, name, phoneNumber);
	    	//This is the exception statement.
	        if (staffId == null || staffId.trim().isEmpty() || department == null || department.trim().isEmpty()) {
	            throw new IllegalArgumentException("Staff ID and Department cannot be null or empty.");
	        }
	        if (monthlySalary < 0) {
	            throw new IllegalArgumentException("Monthly salary cannot be negative.");
	        }
	        //I am taking some new values in this class. I use 'this' method
	        this.staffId = staffId;
	        this.department = department;
	        this.monthlySalary = monthlySalary;
	        staffCount++;
	    }

	    public static int getStaffCount() {
	        return staffCount;
	    }
//This is the value which i am just returning each value in functions.
	    public String getStaffId() { 
	    	return staffId; 
	    	}
	    public String getDepartment() { 
	    	return department; 
	    	}
	    public double getMonthlySalary() { 
	    	return monthlySalary; 
	    	}
//This is not interface, This is abstract class 
	    public abstract double calculateMonthlyCompensation();

	    public void displayStaffDetails() {
	        displayBasicDetails(); //This is the object we are calling from Person class.
	        System.out.println("Staff ID: " + staffId);
	        System.out.println("Department: " + department);
	        System.out.println("Base salary: $" + String.format("%.2f", monthlySalary));
	    }
}


