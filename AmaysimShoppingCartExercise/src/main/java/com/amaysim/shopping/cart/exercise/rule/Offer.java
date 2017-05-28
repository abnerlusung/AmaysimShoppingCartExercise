package com.amaysim.shopping.cart.exercise.rule;

import java.util.List;
import java.util.Map;

import com.amaysim.shopping.cart.exercise.domain.ProductChecker;

public interface Offer {

    boolean check(Map<String, Integer> list);

    Double apply(Map<String, Integer> list, List<ProductChecker> checklist);
}
