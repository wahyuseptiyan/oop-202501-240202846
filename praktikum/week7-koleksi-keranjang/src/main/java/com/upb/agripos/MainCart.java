package com.upb.agripos;

public class MainCart {
    public static void main(String[] args) {
        System.out.println("Hello, I am [WAHYU SEPTIYAN]-[240202846] (Week7)");

        Product p1 = new Product("WKK", "Beras Galur", 45000);
        Product p2 = new Product("KWW", "Pupuk Urea", 55000);

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.printCart();

        cart.removeProduct(p1);
        cart.printCart();
    }
}