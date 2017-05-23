package com.amaysim.shopping.cart.exercise.domain;

import java.util.ArrayList;
import java.util.List;

import com.amaysim.shopping.cart.exercise.services.CatalogueService;

public class Cart {

    private CatalogueService catalogueService = new CatalogueService();

    private List<Product> list;

    private String promoCode;

    private double totalAmout;

    public Cart() {
        this.list = new ArrayList<Product>();
        this.totalAmout = 0.0;
    }

    public void add(String itemCode) {

        if (itemCode == null) {
            // throw exception
        }

        list.add(catalogueService.get(itemCode));

    }

    public void add(String itemCode, String promoCode) {

        if (itemCode == null || promoCode == null) {
            // throw exception
        }

        list.add(catalogueService.get(itemCode));
        this.promoCode = promoCode;
    }

    public List<Product> getDisplayList() {

        return this.list;
    }

    public String getTotalAmount() {

        double total = 0.0;

        for (Product product : this.getDisplayList()) {
            total += product.getPrice();
        }

        if (promoCode != null) {
            total = 0.9 * total;
        }

        return total + "";
    }
}
