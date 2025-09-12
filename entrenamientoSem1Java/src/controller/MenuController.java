package controller;
import javax.swing.JOptionPane;
import model.Product;






public class MenuController {
    public static void welcomeMessage() {
        JOptionPane.showMessageDialog(null, "Hello Admin, welcome back! What do you need for today?");
    }

    ;

    public static void showMenus() {
        JOptionPane.showMessageDialog(null, "");
    }


    public static void showMenu() {
                  String[] opciones = {"Add new product", "List inventory", "Buy product", "Order by price", "Search product by name", "Check Out", "Exit program"};
                  int opcion;

                  do {
                      opcion = JOptionPane.showOptionDialog(
                          null,
                          "Seleccione una operación:",
                          "Menú Calculadora",
                          JOptionPane.DEFAULT_OPTION,
                          JOptionPane.INFORMATION_MESSAGE,
                          null,
                          opciones,
                          opciones[0]
                      );

                      switch (opcion) {
                          case 0: // Add product
                              Product.producInput();
                              break;
                          case 1: // List inventory
                              System.out.println("");
                              break;
                          case 6: // Salir
                          case JOptionPane.CLOSED_OPTION:
                              JOptionPane.showMessageDialog(null, "See you!.");
                              break;
                          default:
                              JOptionPane.showMessageDialog(null, "Invalid option.");
                              break;
                      }

                  } while (opcion != 6 && opcion != JOptionPane.CLOSED_OPTION);
              }


}
















