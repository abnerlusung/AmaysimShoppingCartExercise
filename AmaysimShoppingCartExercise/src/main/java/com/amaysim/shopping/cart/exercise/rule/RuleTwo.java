package com.amaysim.shopping.cart.exercise.rule;

import java.util.List;
import java.util.Map;

import com.amaysim.shopping.cart.exercise.domain.ProductChecker;

public class RuleTwo
    implements Offer {

    private final int PRODUCT_COUNT_CRITERIA = 4;

    private final double NEW_PRICE = 39.9;

    @Override
    public boolean check(Map<String, Integer> list) {

        boolean isValid = false;

        if (isFirstMonth() && isProductCount(list)) {
            isValid = true;
        }

        return isValid;
    }

    @Override
    public Double getNewAmount(Map<String, Integer> list, List<ProductChecker> checklist) {

        int count = 0;
        double amountToBePaid;

        if (list.get("ult_large") != null) {
            count = list.get("ult_large");
        }

        amountToBePaid = count * NEW_PRICE;

        for (ProductChecker p : checklist) {
            if ("ult_large".equalsIgnoreCase(p.getCode())) {
                p.setCheck(true);
            }
        }

        return amountToBePaid;
    }

    private boolean isFirstMonth() {

        return true;
    }

    private boolean isProductCount(Map<String, Integer> list) {

        boolean isValid = false;
        int count;
        if (list.get("ult_large") != null) {
            count = list.get("ult_large");
            if (count >= PRODUCT_COUNT_CRITERIA) {
                isValid = true;
            }
        }
        return isValid;
    }

    @Override
    public boolean check() {

        // TODO Auto-generated method stub
        return false;
    }

}
