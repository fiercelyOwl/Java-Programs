
public class Customer {
    private static int customerCounter = 1000; // starting customer number
    private int customerNumber;
    private String customerName;
    private String contactNumber;
    private String sickness;
    private String exerciseName;

    public Customer(String customerName, String contactNumber, String sickness, String exerciseName) {

        if (customerName == null || customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR: Customer name cannot be null or empty!");
        }
        if (contactNumber == null || contactNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR: Contact number cannot be null or empty!");
        }
        if (sickness == null || sickness.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR: Sickness cannot be null or empty!");
        }
        if (exerciseName == null || exerciseName.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR: Exercise name cannot be null or empty!");
        }

        this.customerNumber = customerCounter++;
        this.customerName = customerName;
        this.contactNumber = contactNumber;
        this.sickness = sickness;
        this.exerciseName = exerciseName;
    }


    public int getCustomerNumber() {
        return customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getSickness() {
        return sickness;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    @Override
    public String toString() {
        return "Customer #" + customerNumber + " - " + customerName;
    }
}