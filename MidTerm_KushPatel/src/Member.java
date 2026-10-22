//Member class demonstrating single inheritance from Person
public class Member extends Person {
	    private static int memberCount = 0;

	    private final String memberNumber;
	    private final int age;
	    private final String membershipType;
	    private double outstandingFees;

	    public Member(String personId, String name, String phoneNumber, String memberNumber, int age) {
	        this(personId, name, phoneNumber, memberNumber, age, "Standard", 0.0);
	    }

	    public Member(String personId, String name, String phoneNumber, String memberNumber, int age, String membershipType, double outstandingFees) {
	        super(personId, name, phoneNumber); //This value i am calling from parent class
	        //This is the exception. 
	        if (age < 0) {
	            throw new IllegalArgumentException("Invalid age provided: " + age);
	        }
	        if (memberNumber == null || memberNumber.trim().isEmpty()) {
	            throw new IllegalArgumentException("Member number cannot be null or empty.");
	        }
	        //Taking some variable in this member class 
	        this.memberNumber = memberNumber;
	        this.age = age;
	        this.membershipType = (membershipType != null && !membershipType.trim().isEmpty()) ? membershipType : "Standard";
	        this.outstandingFees = Math.max(0.0, outstandingFees);
	        memberCount++;
	    }

	    public static int getMemberCount() {
	        return memberCount;
	    }
//Those are the functions which return values so I can call in main function
	    public String getMemberNumber() { 
	    	return memberNumber; 
	    	}
	    public int getAge() {
	    	return age; 
	    	}
	    public String getMembershipType() { 
	    	return membershipType;
	    	}
	    public double getOutstandingFees() {
	    	return outstandingFees; 
	    	}

	    public void setOutstandingFees(double outstandingFees) {
	        this.outstandingFees = Math.max(0.0, outstandingFees);
	    }

	    // Overloaded registerMember methods
	    //After I put fill all values like personalId, name. It will show the print statement.
	    public static Member registerMember(String personId, String name, String phone, String memberNum, int age) {
	        System.out.println("Basic registration completed for member: " + name);
	        return new Member(personId, name, phone, memberNum, age);
	    }
	    //After I put fill all values like personalId, name. It will show the print statement.
	    public static Member registerMember(String personId, String name, String phone, String memberNum, int age, String membershipType) {
	        System.out.println(" Advanced registration (" + membershipType + ") completed for member: " + name);
	        return new Member(personId, name, phone, memberNum, age, membershipType, 0.0);
	    }

	    @Override
	    public String getRoleDescription() {
	        return "Library Member (" + membershipType + ")";
	    }

	    public void displayMemberDetails() {
	        displayBasicDetails();
	        System.out.println("Member number: " + memberNumber);
	        System.out.println("Age:" + age  );
	        System.out.println("Type:" +membershipType   );
	        System.out.println("Outstanding fees: $" + String.format("%.2f", outstandingFees));
	        
	    }
//This Override function comes from Person class.
	    @Override
	    public String toString() {
	        return "Member{memberNumber='" + memberNumber + "', name='" + name + "', type='" + membershipType + "', fees=$" + outstandingFees + "}";
	    }
	}
