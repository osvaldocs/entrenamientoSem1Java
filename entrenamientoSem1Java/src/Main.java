import controller.MenuController;
import model.Product;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Product.addProduct("Mountain bike", 980000, 10);
        Product.addProduct("Folding electric bike", 3100000, 5);
        MenuController.welcomeMessage();
        MenuController.showMenu();
    }
}