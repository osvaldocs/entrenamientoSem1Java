package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Product {
    static ArrayList<String> products = new ArrayList<>();
    static ArrayList<Double> prices = new ArrayList<>();
    static HashMap<String, Integer> stock= new HashMap<>();


    public static void addProduct(String product, double price, int quantity) {
        products.add(product);
        prices.add(price);
        stock.put(product, quantity);
    }

    public static void producInput() {
        String productName = JOptionPane.showInputDialog("Enter the product name:");
        if (productName == null || productName.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid name.");
            return;
        }

        // evitar duplicados
        if (products.contains(productName)) {
            JOptionPane.showMessageDialog(null, "Product already exists.");
            return;
        }

        String productPrice = JOptionPane.showInputDialog("Enter the product price:");
        double decimalPrice;
        try {
            decimalPrice = Double.parseDouble(productPrice);
            if (decimalPrice <= 0) {
                JOptionPane.showMessageDialog(null, "The price must be greater than 0");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid price. It must be a number");
            return;
        }

        String productStock = JOptionPane.showInputDialog("Enter the product stock:");
        int quantity;
        try {
            quantity = Integer.parseInt(productStock);
            if (quantity < 0) {
                JOptionPane.showMessageDialog(null, "Stock must be zero or positive");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid stock. It must be an integer");
            return;
        }

        addProduct(productName, decimalPrice, quantity);
        JOptionPane.showMessageDialog(null, "Product added correctly");
    }


    public static void showProducts() {
        if (products.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No products available");
            return;
        }
        StringBuilder sb = new StringBuilder("Inventory:\n");
        for (int i = 0; i < products.size(); i++) {
            String name = products.get(i);
            double price = prices.get(i);
            int quantity = stock.getOrDefault(name, 0);
            sb.append((i + 1) + ". " + name + " - $" + price + " - Stock: " + quantity + "\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public static boolean reduceStock(String productName, int quantity) {
        if (!stock.containsKey(productName)) {
            return false;
        }
        int current = stock.get(productName);
        if (current < quantity) {
            return false;
        }
        stock.put(productName, current - quantity);
        return true;
    }

    public static double getPrice(String productName) {
        int index = products.indexOf(productName);
        return prices.get(index);
    }

    public static String[] getAvailableProducts() {
        java.util.List<String> disponibles = new java.util.ArrayList<>();
        for (String nombre : products) {
            int stockActual = stock.getOrDefault(nombre, 0);
            if (stockActual > 0) {
                disponibles.add(nombre + " (Stock: " + stockActual + ")");
            }
        }
        return disponibles.toArray(new String[0]);
    }

    public static String getCheapestAndMostExpensive() {
        if (products.isEmpty()) {
            return "No products available.";
        }

        double minPrice = prices.get(0);
        double maxPrice = prices.get(0);
        String minName = products.get(0);
        String maxName = products.get(0);

        for (int i = 1; i < prices.size(); i++) {
            double price = prices.get(i);
            String name = products.get(i);
            if (price < minPrice) {
                minPrice = price;
                minName = name;
            }
            if (price > maxPrice) {
                maxPrice = price;
                maxName = name;
            }
        }

        return "Cheapest: " + minName + " ($" + minPrice + ")\n"
                + "Most expensive: " + maxName + " ($" + maxPrice + ")";
    }

    public static String searchProductsByName(String query) {
        if (products.isEmpty()) {
            return "No products available.";
        }

        if (query == null || query.trim().isEmpty()) {
            return "Please enter a search term.";
        }

        StringBuilder sb = new StringBuilder("Search results:\n");
        String lowerQuery = query.toLowerCase();
        boolean found = false;

        for (int i = 0; i < products.size(); i++) {
            String name = products.get(i);
            if (name.toLowerCase().contains(lowerQuery)) {
                double price = prices.get(i);
                int stockActual = stock.getOrDefault(name, 0);
                sb.append(name)
                        .append(" - $").append(price)
                        .append(" (Stock: ").append(stockActual).append(")\n");
                found = true;
            }
        }

        if (!found) {
            return "No products match your search.";
        }

        return sb.toString();
    }


}