package ElectricityBilling;

import java.util.Scanner;

class ElectricityBill {
    private String customerName;
    private int unitsConsumed;

    public ElectricityBill(String customerName, int unitsConsumed) {
        this.customerName = customerName;
        this.unitsConsumed = unitsConsumed;
    }

    public void calculateBill() {
        double ratePerUnit = 0.12; // Example rate per unit, you can change it as needed
        double totalBill = unitsConsumed * ratePerUnit;

        System.out.println("\nElectricity Bill for " + customerName);
        System.out.println("Units Consumed: " + unitsConsumed);
        System.out.println("Rate per Unit: $" + ratePerUnit);
        System.out.println("Total Bill: $" + totalBill);
    }
}

public class ElectricityBillingSystem  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter units consumed: ");
        int unitsConsumed = scanner.nextInt();

        ElectricityBill electricityBill = new ElectricityBill(customerName, unitsConsumed);
        electricityBill.calculateBill();
    }
}
