package com.amaysim.shopping.cart.exercise;

import com.amaysim.shopping.cart.exercise.domain.Cart;

public class ShoppingCartRunner {

    private Cart cart;

    public ShoppingCartRunner() {
        super();
        this.cart = new Cart();
    }

    public static void main(String[] args) {

        // ShoppingCartRunner shoppingCartRunner1 = new ShoppingCartRunner();
        // shoppingCartRunner1.add("ult_small");
        // shoppingCartRunner1.add("ult_small");
        // shoppingCartRunner1.add("ult_small");
        // shoppingCartRunner1.add("ult_large");
        // shoppingCartRunner1.total();
        // shoppingCartRunner1.items();

        // ShoppingCartRunner shoppingCartRunner2 = new ShoppingCartRunner();
        // shoppingCartRunner2.add("ult_small");
        // shoppingCartRunner2.add("ult_small");
        // shoppingCartRunner2.add("ult_large");
        // shoppingCartRunner2.add("ult_large");
        // shoppingCartRunner2.add("ult_large");
        // shoppingCartRunner2.add("ult_large");
        // shoppingCartRunner2.total();
        // shoppingCartRunner2.items();

        ShoppingCartRunner shoppingCartRunner3 = new ShoppingCartRunner();
        shoppingCartRunner3.add("ult_small");
        shoppingCartRunner3.add("ult_medium");
        shoppingCartRunner3.add("ult_medium");
        shoppingCartRunner3.total();
        shoppingCartRunner3.items();
        //
        // ShoppingCartRunner shoppingCartRunner4 = new ShoppingCartRunner();
        // shoppingCartRunner4.add("ult_small");
        // shoppingCartRunner4.add("1gb", RuleFour.promo);
        // shoppingCartRunner4.total();
        // shoppingCartRunner4.items();
    }

    public void add(String productCode) {

        cart.addProduct(productCode);

    }

    public void add(String productCode, String promoCode) {

        cart.addProduct(productCode, promoCode);
    }

    public void total() {

        System.out.println("======================");

        System.out.println(cart.getTotalAmount());
    }

    public void items() {

        System.out.println(cart.getDisplay());
        System.out.println("======================");
    }
}
