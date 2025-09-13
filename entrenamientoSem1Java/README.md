Java Inventory App - RIWI Week 1 Training

This is a small Java console + GUI project created as part of RIWI’s
Java Week 1 training.
It demonstrates basic concepts of Java programming such as classes,
static methods, collections (ArrayList, HashMap), loops, switch case, user input validation
and simple GUI dialogs with JOptionPane.

✨ Features

-   Add new product: Insert a product with name, price and stock.
    Validates input and avoids duplicates.
-   List inventory: Shows all products with price and stock.
-   Buy product: Lets the user pick a product from the current stock,
    choose quantity, and add it to the cart.
-   Order by price: Displays the cheapest and the most expensive
    product.
-   Search product by name: Find products containing a keyword
    (case-insensitive).
-   Check Out: Generates a purchase ticket with all items and total,
    then clears the cart.

🛠 How to Run

1.  Make sure you have Java 17+ installed.

2.  Clone or download this repository.

3.  Compile the source files:

        javac Main.java controller/MenuController.java model/Product.java service/CalculatorService.java

4.  Run the application:

        java Main

You will see GUI dialogs (JOptionPane) for all interactions.

------------------------------------------------------------------------

This project was developed as a learning exercise during the first week
of Java training at RIWI.
