package prototype;

import java.util.ArrayList;
import java.util.List;

public class Order implements Cloneable {

    private List<Product> products = new ArrayList<>();
    private List<Discount> discounts = new ArrayList<>();
    private double deliveryCost;
    private String paymentMethod;

    public void addProduct(Product p) {
        products.add(p);
    }

    public void addDiscount(Discount d) {
        discounts.add(d);
    }

    public void setDeliveryCost(double cost) {
        this.deliveryCost = cost;
    }

    public void setPaymentMethod(String method) {
        this.paymentMethod = method;
    }

    @Override
    public Order clone() {
        try {
            Order copy = (Order) super.clone();
            copy.products = new ArrayList<>();
            for (Product p : products) {
                copy.products.add(p.clone());
            }

            copy.discounts = new ArrayList<>();
            for (Discount d : discounts) {
                copy.discounts.add(d.clone());
            }

            return copy;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Products: " + products +
                "\nDiscounts: " + discounts +
                "\nDelivery: " + deliveryCost +
                "\nPayment: " + paymentMethod;
    }
}
