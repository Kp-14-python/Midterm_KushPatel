//LibraryAssistant demonstrating hierarchical inheritance from LibraryStaff
public class LibraryAssistant extends LibraryStaff {
    private final String shiftType;
    private final double shiftAllowance;

    public LibraryAssistant(String personId, String name, String phoneNumber, String staffId, String department, double monthlySalary, String shiftType, double shiftAllowance) {
        super(personId, name, phoneNumber, staffId, department, monthlySalary);
        this.shiftType = (shiftType != null && !shiftType.trim().isEmpty()) ? shiftType : "Morning";
        this.shiftAllowance = Math.max(0, shiftAllowance);
    }

    public String getShiftType() { 
    	return shiftType; 
    	}
    public double getShiftAllowance() { 
    	return shiftAllowance; 
    	}

    @Override
    public double calculateMonthlyCompensation() {
        return monthlySalary + shiftAllowance;
    }

    @Override
    public String getRoleDescription() {
        return "Library Assistant (" + shiftType + " Shift)";
    }

    @Override
    public void displayStaffDetails() {
        displayBasicDetails();
        System.out.println("Library Assistant");
        displayBasicDetails();
        System.out.println("Staff ID: " + staffId);
        System.out.println("Role: Library Assistant");
        System.out.println("Department: " + department);
        System.out.println("Shift: " + shiftType);
        System.out.println("Shift Allowance: $" + String.format("%.2f", shiftAllowance));
        System.out.println("Total Comp: $" + String.format("%.2f", calculateMonthlyCompensation()));
    }
}