package com.amaysim.shopping.cart.exercise;

import java.util.ArrayList;
import java.util.List;

import com.amaysim.shopping.cart.exercise.domain.Product;
import com.amaysim.shopping.cart.exercise.services.DisplayService;
import com.amaysim.shopping.cart.exercise.storage.ShoppingCatalogue;

public class ShoppingCartRunner {

    private List<Product> list;

    private ShoppingCatalogue shoppingCatalogue = new ShoppingCatalogue();

    private DisplayService displayService = new DisplayService();

    private List<Rule> rules = new ArrayList<Rule>();

    public ShoppingCartRunner() {
        super();
        this.list = new ArrayList<Product>();
    }

    public static void main(String[] args) {

        ShoppingCartRunner shoppingCartRunner1 = new ShoppingCartRunner();
        shoppingCartRunner1.add("ult_small");
        shoppingCartRunner1.add("ult_small");
        shoppingCartRunner1.add("ult_small");
        shoppingCartRunner1.add("ult_large");
        shoppingCartRunner1.total();
        shoppingCartRunner1.items();

        ShoppingCartRunner shoppingCartRunner2 = new ShoppingCartRunner();
        shoppingCartRunner2.add("ult_small");
        shoppingCartRunner2.add("ult_small");
        shoppingCartRunner2.add("ult_large");
        shoppingCartRunner2.add("ult_large");
        shoppingCartRunner2.add("ult_large");
        shoppingCartRunner2.add("ult_large");
        shoppingCartRunner2.total();
        shoppingCartRunner2.items();

        ShoppingCartRunner shoppingCartRunner3 = new ShoppingCartRunner();
        shoppingCartRunner3.add("ult_small");
        shoppingCartRunner3.add("ult_medium");
        shoppingCartRunner3.add("ult_medium");
        shoppingCartRunner3.total();
        shoppingCartRunner3.items();

        ShoppingCartRunner shoppingCartRunner4 = new ShoppingCartRunner();
        shoppingCartRunner4.add("ult_large");
        shoppingCartRunner4.add("1gb");
        shoppingCartRunner4.total();
        shoppingCartRunner4.items();
    }

    public void add(String productCode) {

        list.add(shoppingCatalogue.get(productCode));

    }

    public void add(String productCode, String promoCode) {

        list.add(shoppingCatalogue.get(productCode));
    }

    public void total() {

        System.out.println("======================");
        double total = 0.0;

        for (Product product : list) {
            total += product.getPrice();
        }

        System.out.println("$" + total);
    }

    public void items() {

        displayService.print(list);
        System.out.println("======================");
    }
}
