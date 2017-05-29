package com.amaysim.shopping.cart.exercise;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.amaysim.shopping.cart.exercise.compute.ComputeService;
import com.amaysim.shopping.cart.exercise.display.DisplayService;

public class CartServiceImpl
    implements CartService {

    @Autowired
    private DisplayService displayService;

    @Autowired
    private ComputeService computeService;

    public DisplayService getDisplayService() {

        return displayService;
    }

    public void setDisplayService(DisplayService displayService) {

        this.displayService = displayService;
    }

    public ComputeService getComputeService() {

        return computeService;
    }

    public void setComputeService(ComputeService computeService) {

        this.computeService = computeService;
    }

    private Map<String, Integer> list;

    private String promoCode;

    public CartServiceImpl() {
        this.list = new HashMap<String, Integer>();
    }

    public CartServiceImpl(ComputeService computeService, DisplayService displayService) {
        this.list = new HashMap<String, Integer>();
        this.computeService = computeService;
        this.displayService = displayService;
    }

    public void addProduct(String itemCode) {

        if (itemCode == null) {
            // throw exception
        }

        boolean is2gb = itemCode.equalsIgnoreCase("ult_medium");
        addToList(itemCode);

        if (is2gb) {
            addToList("1gb");
        }
    }

    private void addToList(String itemCode) {

        int count = 0;
        if (list.get(itemCode) != null) {
            count = list.get(itemCode);
            count++;
            list.put(itemCode, (Integer) count);
        } else {
            list.put(itemCode, 1);
        }
    }

    public String getDisplay() {

        return displayService.print(list);
    }

    public String getTotalAmount() {

        NumberFormat formatter = NumberFormat.getNumberInstance();
        double total = computeService.getTotalAmount(list);

        if (promoCode != null) {
            total = 0.9 * total;
        }

        return formatter.format(total) + "";
    }

    public void addPromoCode(String promoCode) {

        if (!"I<3AMAYSIM".equalsIgnoreCase(promoCode)) {
            // throw exception
        }

        this.promoCode = promoCode;
    }

    @Override
    public void reset() {

        this.list = new HashMap<String, Integer>();
        this.promoCode = null;

    }

}
