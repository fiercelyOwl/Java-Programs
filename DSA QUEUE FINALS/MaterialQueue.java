import java. util.*;


public class MaterialQueue {
    private Queue<EquipmentQueueItem> equipmentQueue;
    private int itemCounter;

    public static class EquipmentQueueItem {
        private Customer customer;
        private Equipment equipment;
        private int sequenceNumber;

        public EquipmentQueueItem(Customer customer, Equipment equipment, int sequenceNumber) {
            this.customer = customer;
            this.equipment = equipment;
            this.sequenceNumber = sequenceNumber;
        }

        public Customer getCustomer() {
            return customer;
        }

        public Equipment getEquipment() {
            return equipment;
        }

        public int getSequenceNumber() {
            return sequenceNumber;
        }
    }


    public MaterialQueue() {
        this.equipmentQueue = new LinkedList<>();
        this.itemCounter = 0;
    }

    public void enqueueEquipment(Customer customer, Equipment equipment) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        if (equipment == null) {
            throw new IllegalArgumentException("Equipment cannot be null");
        }

        itemCounter++;
        equipmentQueue.offer(new EquipmentQueueItem(customer, equipment, itemCounter));
    }

    public EquipmentQueueItem dequeueEquipment() {
        return equipmentQueue.poll();
    }

    public EquipmentQueueItem peekEquipment() {
        return equipmentQueue.peek();
    }

    public boolean isEmpty() {
        return equipmentQueue.isEmpty();
    }

    public int getQueueSize() {
        return equipmentQueue.size();
    }

    public void displayQueue() {
        if (equipmentQueue.isEmpty()) {
            System.out.println("Equipment queue is empty.");
            return;
        }

        System.out.println("\n=== EQUIPMENT QUEUE ===");
        int position = 1;
        for (EquipmentQueueItem item : equipmentQueue) {
            System.out.println("Position " + position + ": " +
                    item.customer.getCustomerName() + " - " +
                    item.equipment.getEquipmentName());
            position++;
        }
    }

    public List<EquipmentQueueItem> getQueueItems() {
        return new ArrayList<>(equipmentQueue);
    }
}


