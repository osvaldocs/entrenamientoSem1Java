package service;

import model.Product;

import java.util.HashMap;
import java.util.Map;

public class CalculatorService {

    private static Map<String, Integer> cart = new HashMap<>(); // producto → cantidad
    private static double totalSales = 0;

    public static void addToCart(String productName, int quantity, double unitPrice) {
        // acumula cantidad en el carrito
        int current = cart.getOrDefault(productName, 0);
        cart.put(productName, current + quantity);

        // acumula el total $
        totalSales += unitPrice * quantity;
    }

    public static double getTotalSales() {
        return totalSales;
    }

    public static Map<String,Integer> getCart() {
        return cart;
    }

    public static void clearCart() {
        cart.clear();
        totalSales = 0;
    }

    public static boolean buyProduct(String productName, int quantity) {
        if (Product.reduceStock(productName, quantity)) {
            double price = Product.getPrice(productName);
            addToCart(productName, quantity, price);
            return true;
        }
        return false;
    }

    public static String generateTicket() {
        if (cart.isEmpty()) {
            return "Your cart is empty.";
        }

        StringBuilder sb = new StringBuilder("=== Purchase Ticket ===\n\n");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String product = entry.getKey();
            int qty = entry.getValue();
            double unitPrice = Product.getPrice(product);
            double lineTotal = unitPrice * qty;
            sb.append(product)
                    .append(" x").append(qty)
                    .append(" @ $").append(unitPrice)
                    .append(" = $").append(lineTotal)
                    .append("\n");
        }
        sb.append("\nTotal: $").append(totalSales);

        return sb.toString();
    }

}
