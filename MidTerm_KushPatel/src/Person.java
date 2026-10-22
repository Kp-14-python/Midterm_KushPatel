
//This is the abstract class of Person
public abstract class Person {
	    private static int personCount = 0;
//This variables are protected (name, personID and phonenumber are protected).
	    protected final String personId;
	    protected final String name;
	    protected final String phoneNumber;
//This is the Exception like blank, Empty or datatype is different it will throw the error. 
	    public Person(String personId, String name, String phoneNumber) {
	        if (personId == null || personId.trim().isEmpty() ||
	            name == null || name.trim().isEmpty() ||
	            phoneNumber == null || phoneNumber.trim().isEmpty()) {
	            throw new IllegalArgumentException("Person details (ID, name, phone number) cannot be null or empty.");
	        }
	        //This are the variables i am taking 
	        this.personId = personId;
	        this.name = name;
	        this.phoneNumber = phoneNumber;
	        personCount++; 
	    }

	    public static int getPersonCount() {
	        return personCount;
	    }
//I just return this function so i can call in my main method
	    public String getPersonId() { return personId; }
	    public String getName() { return name; }
	    public String getPhoneNumber() { return phoneNumber; }

	    public abstract String getRoleDescription();
//I am just display name, personId and phonenumber 
	    public void displayBasicDetails() {
	    	System.out.println("Person ID: " + personId);
	        System.out.println("Name: " + name);
	        System.out.println("Phone: " + phoneNumber);
	    }

	    @Override
	    public String toString() {
	        return "Person{id='" + personId + "', name='" + name + "', phone='" + phoneNumber + "'}";
	    }

}
