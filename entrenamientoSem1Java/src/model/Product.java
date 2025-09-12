package model;

import javax.swing.*;
import java.util.ArrayList;

public class Product {
    static ArrayList<String> products = new ArrayList<>();
    static ArrayList<Double> prices = new ArrayList<>();


    public static void addProduct(String product, double price) {
        products.add(product);
        prices.add(price);
    }

    public static void producInput() {
        String productName = JOptionPane.showInputDialog("Enter the product name: ");
        if (productName == null || productName.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid name.");
            return;
        }
        String productPrice = JOptionPane.showInputDialog("Enter the product price: ");
        try {
            double decimalPrice = Double.parseDouble(productPrice);
            if (decimalPrice <= 0) {
                JOptionPane.showInputDialog("The price can't be lower than 0");
                return;
            }

            addProduct(productName, decimalPrice);

        } catch (NumberFormatException e) {
            System.out.println(e);
            JOptionPane.showInputDialog("Invalid price. It must be a number");
        }
    }
}