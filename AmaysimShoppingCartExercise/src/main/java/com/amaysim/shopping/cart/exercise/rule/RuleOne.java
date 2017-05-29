package com.amaysim.shopping.cart.exercise.rule;

import java.util.List;
import java.util.Map;

import com.amaysim.shopping.cart.exercise.catalogue.CatalogueServiceImpl;
import com.amaysim.shopping.cart.exercise.domain.ProductChecker;

public class RuleOne
    implements Offer {

    private final int PRODUCT_COUNT_TO_BE_PAID = 2;

    private final int PRODUCT_COUNT_CRITERIA = 3;

    private CatalogueServiceImpl catalogueService;

    public CatalogueServiceImpl getCatalogueService() {

        return catalogueService;
    }

    public void setCatalogueService(CatalogueServiceImpl catalogueService) {

        this.catalogueService = catalogueService;
    }

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

        int count = 0;
        int threes;
        double price = catalogueService.get("ult_small")
            .getPrice();
        double amountToBePaid;
        int ctr = 1;
        int ctrFlag;

        if (list.get("ult_small") != null) {
            count = list.get("ult_small");
        }
        threes = count / PRODUCT_COUNT_CRITERIA;
        amountToBePaid = price * PRODUCT_COUNT_TO_BE_PAID * threes;
        ctrFlag = PRODUCT_COUNT_CRITERIA * threes;

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
