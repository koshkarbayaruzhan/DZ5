package main;

import prototype.*;

public class PrototypeMain {

    public static void main(String[] args) {

        Order base = new Order();
        base.addProduct(new Product("Laptop", 350000, 1));
        base.addDiscount(new Discount("New Year", 10));
        base.setDeliveryCost(2000);
        base.setPaymentMethod("Card");

        Order clone = base.clone();
        clone.setPaymentMethod("Cash");

        System.out.println("ORIGINAL:\n" + base);
        System.out.println("------------");
        System.out.println("CLONE:\n" + clone);
    }
}
