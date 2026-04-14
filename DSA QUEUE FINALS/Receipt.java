import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {
    private int receiptNumber;
    private static int receiptCounter = 5000;
    private Customer customer;
    private List<Equipment> equipment;
    private LocalDateTime transactionTime;
    private double totalCost;

    public Receipt(Customer customer, List<Equipment> equipment) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        if (equipment == null || equipment.isEmpty()) {
            throw new IllegalArgumentException("Equipment list cannot be null or empty");
        }

        this.receiptNumber = receiptCounter++;
        this.customer = customer;
        this.equipment = new ArrayList<>(equipment);
        this.transactionTime = LocalDateTime.now();
        calculateTotal();
    }

    private void calculateTotal() {
        totalCost = 0;
        for (Equipment item : equipment) {
            totalCost += item.getPrice();
        }
    }

    public String generateReceipt() {
        StringBuilder receipt = new StringBuilder();

        receipt.append("\n");
        receipt.append("==============================================================\n");
        receipt.append("|          EXERCISE MATERIALS PURCHASE RECEIPT               |\n");
        receipt.append("==============================================================\n");
        receipt.append("\n");

        receipt.append("Receipt Number      : #").append(receiptNumber).append("\n");
        receipt.append("Customer Number     : #").append(customer.getCustomerNumber()).append("\n");
        receipt.append("Customer Name       : ").append(customer.getCustomerName()).append("\n");
        receipt.append("Contact Number      : ").append(customer.getContactNumber()).append("\n");
        receipt.append("Health Condition    : ").append(customer.getSickness()).append("\n");
        receipt.append("Exercise Name       :  ").append(customer.getExerciseName()).append("\n");
        receipt.append("Transaction Date    : ").append(formatDateTime(transactionTime)).append("\n");

        receipt.append("\n");
        receipt.append("────────────────────────────────────────────────────────────\n");
        receipt.append("EXERCISE MATERIALS\n");
        receipt.append("────────────────────────────────────────────────────────────\n");

        int itemNumber = 1;
        for (Equipment item : equipment) {
            receipt.append(String.format("%2d. %-40s ₱%8.2f\n",
                    itemNumber,
                    item.getEquipmentName(),
                    item. getPrice()));
            itemNumber++;
        }

        receipt.append("────────────────────────────────────────────────────────────\n");
        receipt.append(String.format("TOTAL                                          ₱%8.2f\n", totalCost));
        receipt.append("────────────────────────────────────────────────────────────\n");

        receipt.append("\nThank you for your purchase!\n");
        receipt.append("Please keep this receipt for your records.\n");
        receipt.append("\n");
        receipt.append("==============================================================\n");
        receipt.append("|                    END OF RECEIPT                          |\n");
        receipt.append("==============================================================\n");

        return receipt.toString();
    }

    public void printReceipt() {
        System.out.println(generateReceipt());
    }

    private String formatDateTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH: mm:ss");
        return dateTime.format(formatter);
    }

    public int getReceiptNumber() {
        return receiptNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Equipment> getEquipment() {
        return new ArrayList<>(equipment);
    }

    public double getTotalCost() {
        return totalCost;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    @Override
    public String toString() {
        return "Receipt #" + receiptNumber + " for " + customer.getCustomerName();
    }
}