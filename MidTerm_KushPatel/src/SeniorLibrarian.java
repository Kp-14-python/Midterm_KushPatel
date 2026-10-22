//SeniorLibrarian extending Librarian to demonstrate multilevel inheritance
public class SeniorLibrarian extends Librarian {
    private final String specialization;
    private final double seniorityAllowance;

    public SeniorLibrarian(String personId, String name, String phoneNumber, String staffId, String department, double monthlySalary, int dailyIssueLimit, int booksProcessed, String specialization, double seniorityAllowance) {
        super(personId, name, phoneNumber, staffId, department, monthlySalary, dailyIssueLimit, booksProcessed);
        this.specialization = (specialization != null && !specialization.trim().isEmpty()) ? specialization : "General";
        this.seniorityAllowance = Math.max(0, seniorityAllowance);
    }

    public String getSpecialization() { 
    	return specialization; 
    	}
    public double getSeniorityAllowance() { 
    	return seniorityAllowance; 
    	}
//This same function i use in Member class. That's way i use override method
    @Override
    public double calculateMonthlyCompensation() {
        // Processing allowance + seniority allowance[cite: 1, 2]
        return super.calculateMonthlyCompensation() + seniorityAllowance;
    }

    @Override
    public String getRoleDescription() {
        return "Senior Librarian (" + specialization + ")";
    }
//This is from interface.
    @Override
    public void generateReport() {
        System.out.println("=== Senior Librarian Comprehensive Report (" + name + ") ===");
        System.out.println("Specialization: " + specialization + " , Seniority Allowance: $" + String.format("%.2f", seniorityAllowance));
    }

    @Override
    public void displayStaffDetails() {
        displayBasicDetails();
        System.out.println("Senior Librarian");
        displayBasicDetails();
        System.out.println("Staff ID: " + staffId);
        System.out.println("Role: Senior Librarian");
        System.out.println("Department: " + department);
        System.out.println("Specialization: " + specialization);
        System.out.println("Base Salary: $" + String.format("%.2f", monthlySalary));
        System.out.println("Seniority Allowance: $" + String.format("%.2f", seniorityAllowance));
        System.out.println("Total Comp: $" + String.format("%.2f", calculateMonthlyCompensation()));
    }
}