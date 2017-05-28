package com.amaysim.shopping.cart.exercise.domain;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amaysim.shopping.cart.exercise.catalogue.CatalogueServiceImpl;
import com.amaysim.shopping.cart.exercise.compute.ComputeService;
import com.amaysim.shopping.cart.exercise.compute.ComputeServiceImpl;
import com.amaysim.shopping.cart.exercise.display.DisplayService;
import com.amaysim.shopping.cart.exercise.display.DisplayServiceImpl;

/**
 * 
 * 
 */
public class Cart {

    private CatalogueServiceImpl catalogueService = new CatalogueServiceImpl();

    private DisplayService displayService = new DisplayServiceImpl();

    private ComputeService computeService = new ComputeServiceImpl();

    private List<Product> list;

    private Map<String, Integer> list2;

    private String promoCode;

    public Cart() {
        this.list = new ArrayList<Product>();
        this.list2 = new HashMap<String, Integer>();
    }

    public void addProduct(String itemCode) {

        if (itemCode == null) {
            // throw exception
        }

        int count = 0;

        if (list2.get(itemCode) != null) {
            count = list2.get(itemCode);
            count++;
            list2.put(itemCode, (Integer) count);
        } else {
            list2.put(itemCode, 1);
        }

        list.add(catalogueService.get(itemCode));

    }

    public void addProduct(String itemCode, String promoCode) {

        if (itemCode == null || promoCode == null) {
            // throw exception
        }

        list.add(catalogueService.get(itemCode));
        this.promoCode = promoCode;
    }

    public String getDisplay() {

        return displayService.print(list);
    }

    public String getTotalAmount() {

        NumberFormat formatter = NumberFormat.getNumberInstance();
        double total = computeService.getTotalAmount(list2);

        if (promoCode != null) {
            total = 0.9 * total;
        }

        return formatter.format(total) + "";
    }

}
