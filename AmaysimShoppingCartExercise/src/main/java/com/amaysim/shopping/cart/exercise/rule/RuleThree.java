package com.amaysim.shopping.cart.exercise.rule;

import java.util.List;
import java.util.Map;

import com.amaysim.shopping.cart.exercise.domain.ProductChecker;

public class RuleThree
    implements Offer {

    public static final String promoCode = "I<3AMAYSIM";

    private String myPromoCode;

    public RuleThree(String promoCode) {
        super();
        this.myPromoCode = promoCode;
    }

    @Override
    public Double getNewAmount(Map<String, Integer> list, List<ProductChecker> checklist) {

        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean check() {

        boolean isValid = false;
        if (promoCode.equalsIgnoreCase(myPromoCode)) {
            isValid = true;
        }
        return isValid;
    }

    @Override
    public boolean check(Map<String, Integer> list) {

        // TODO Auto-generated method stub
        return false;
    }

}
