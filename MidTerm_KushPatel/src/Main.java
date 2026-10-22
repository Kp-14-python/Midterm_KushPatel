
public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   MAPLE LEAF PUBLIC LIBRARY - MANAGEMENT SYSTEM   ");
        System.out.println("==================================================\n");

        try {
            // 1. Register Members using Overloaded registerMember methods
            System.out.println("--- 1. MEMBER REGISTRATION & VALIDATION ---");
            Member m1 = Member.registerMember("P001", "Alice Smith", "555-0101", "M1001", 25);
            Member m2 = Member.registerMember("P002", "Bob Jones", "555-0202", "M1002", 40, "Premium");

            System.out.println();
            m1.displayMemberDetails();
            System.out.println();
            m2.displayMemberDetails();

            // 2. Create Staff Members
            System.out.println("\n--- 2. STAFF CREATION ---");
            Librarian librarian = new Librarian("P003", "Carol White", "555-0303", "S2001", "Circulation", 3000.0, 50, 120);
            SeniorLibrarian seniorLibrarian = new SeniorLibrarian("P004", "Dr. David Brown", "555-0404", "S2002", "Acquisitions", 4500.0, 100, 200, "Rare Manuscripts", 800.0);
            LibraryAssistant assistant = new LibraryAssistant("P005", "Emma Green", "555-0505", "S2003", "Front Desk", 2200.0, "Evening", 300.0);

            librarian.displayStaffDetails();
            System.out.println();
            seniorLibrarian.displayStaffDetails();
            System.out.println();
            assistant.displayStaffDetails();

            // 3. Static Counters Display
            System.out.println("\n--- 3. SYSTEM STATISTIC COUNTERS ---");
            System.out.println("Total Persons Created: " + Person.getPersonCount());
            System.out.println("Total Members Created: " + Member.getMemberCount());
            System.out.println("Total Staff Created:   " + LibraryStaff.getStaffCount());

            // 4. Method Overloading: Late Fee Calculations
            System.out.println("\n--- 4. LATE FEE CALCULATIONS (OVERLOADING) ---");
            int overdueDays = 5;
            double defaultFee = librarian.calculateLateFee(overdueDays);
            double customFee = librarian.calculateLateFee(overdueDays, 1.50);

            System.out.println("Overdue Days: " + overdueDays);
            System.out.println("Late fee at default rate ($1.00/day): $" + String.format("%.2f", defaultFee));
            System.out.println("Late fee at custom rate ($1.50/day):  $" + String.format("%.2f", customFee));

            // Test validation error handling for negative days
            try {
                librarian.calculateLateFee(-3);
            } catch (IllegalArgumentException e) {
                System.out.println("[CAUGHT EXPECTED EXCEPTION] " + e.getMessage());
            }

            // 5. Monthly Compensation Calculations
            System.out.println("\n--- 5. MONTHLY COMPENSATION CALCULATIONS ---");
            System.out.println("Librarian (" + librarian.getName() + ") Compensation: $" + String.format("%.2f", librarian.calculateMonthlyCompensation()));
            System.out.println("Senior Librarian (" + seniorLibrarian.getName() + ") Compensation: $" + String.format("%.2f", seniorLibrarian.calculateMonthlyCompensation()));
            System.out.println("Library Assistant (" + assistant.getName() + ") Compensation: $" + String.format("%.2f", assistant.calculateMonthlyCompensation()));

            // 6. Runtime Polymorphism Demonstration
            System.out.println("\n--- 6. RUNTIME POLYMORPHISM ---");
            LibraryStaff[] staffList = { librarian, seniorLibrarian, assistant };
            for (LibraryStaff staff : staffList) {
                System.out.println("Role: " + staff.getRoleDescription() + " | Monthly Compensation: $" + String.format("%.2f", staff.calculateMonthlyCompensation()));
            }

            // 7. Interfaces Demonstration
            System.out.println("\n--- 7. INTERFACES DEMONSTRATION ---");
            librarian.reserveBook("BK-9988");
            librarian.reserveBook(""); // Unsuccessful reservation test
            System.out.println();
            librarian.generateReport();
            System.out.println();
            seniorLibrarian.generateReport();

            
        } catch (Exception e) {
            System.err.println("[ERROR] An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }

    }
}