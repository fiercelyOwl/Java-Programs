
public class Equipment {
    private String equipmentName;
    private double price;

    public Equipment(String equipmentName, double price) {
        if (equipmentName == null || equipmentName.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR: Equipment name cannot be null or empty!");
        }
        if (price < 0) {
            throw new IllegalArgumentException("ERROR: Equipment price cannot be negative!");
        }
        this.equipmentName = equipmentName;
        this.price = price;
    }


    public String getEquipmentName() {
        return equipmentName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return equipmentName + " - ₱" + String.format("%.2f", price);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Equipment equipment = (Equipment) obj;
        return equipmentName.equals(equipment.equipmentName);
    }

    @Override
    public int hashCode() {
        return equipmentName.hashCode();
    }
}