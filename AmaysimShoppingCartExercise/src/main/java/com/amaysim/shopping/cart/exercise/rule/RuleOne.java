package com.amaysim.shopping.cart.exercise.rule;

import java.util.List;
import java.util.Map;

import com.amaysim.shopping.cart.exercise.catalogue.CatalogueServiceImpl;
import com.amaysim.shopping.cart.exercise.domain.ProductChecker;

public class RuleOne
    implements Offer {

    private CatalogueServiceImpl catalogueService = new CatalogueServiceImpl();

    private final int PRODUCT_COUNT_TO_BE_PAID = 2;

    private final int PRODUCT_COUNT_CRITERIA = 3;

    @Override
    public boolean check(Map<String, Integer> list) {

        boolean isValid = false;

        if (isFirstMonth() && isProductCount(list)) {
            isValid = true;
        }

        return isValid;
    }

    @Override
    public Double apply(Map<String, Integer> list, List<ProductChecker> checklist) {

        int count = list.get("ult_small");
        int threes = count / PRODUCT_COUNT_CRITERIA;
        double price = catalogueService.get("ult_small")
            .getPrice();
        double amountToBePaid = price * PRODUCT_COUNT_TO_BE_PAID * threes;
        int ctr = 1;
        int ctrFlag = PRODUCT_COUNT_CRITERIA * threes;
        for (ProductChecker p : checklist) {
            if (ctr <= ctrFlag && p.getCode()
                .equalsIgnoreCase("ult_small")) {
                p.setCheck(true);
                ctr++;
            }
        }

        return amountToBePaid;
    }

    private boolean isFirstMonth() {

        return true;
    }

    private boolean isProductCount(Map<String, Integer> list) {

        boolean isValid = true;
        int count;
        if (list.get("ult_small") != null) {
            count = list.get("ult_small");
            if (count >= PRODUCT_COUNT_CRITERIA) {
                isValid = true;
            }
        }

        return isValid;
    }

}
