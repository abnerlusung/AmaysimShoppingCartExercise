package com.amaysim.shopping.cart.exercise.rule;

import java.util.List;
import java.util.Map;

import com.amaysim.shopping.cart.exercise.domain.ProductChecker;

public class RuleFour
    implements Offer {

    @Override
    public boolean check() {

        return false;
    }

    @Override
    public boolean check(Map<String, Integer> list) {

        boolean hasProduct = false;
        int count = 0;
        if (list.get("ult_medium") != null) {
            count = list.get("ult_medium");
        }

        if (count > 0) {
            hasProduct = true;
        }

        return hasProduct;
    }

    @Override
    public Double getNewAmount(Map<String, Integer> list, List<ProductChecker> checklist) {

        return null;
    }
}
