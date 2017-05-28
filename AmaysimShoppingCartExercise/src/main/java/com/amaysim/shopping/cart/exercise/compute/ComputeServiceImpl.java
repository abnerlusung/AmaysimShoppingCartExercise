package com.amaysim.shopping.cart.exercise.compute;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.amaysim.shopping.cart.exercise.catalogue.CatalogueServiceImpl;
import com.amaysim.shopping.cart.exercise.domain.ProductChecker;
import com.amaysim.shopping.cart.exercise.rule.Offer;
import com.amaysim.shopping.cart.exercise.rule.RuleOne;
import com.amaysim.shopping.cart.exercise.rule.RuleTwo;

public class ComputeServiceImpl
    implements ComputeService {

    private CatalogueServiceImpl catalogueService = new CatalogueServiceImpl();

    private List<Offer> offers;

    public ComputeServiceImpl() {
        super();
        this.offers = new ArrayList<Offer>();
        this.offers.add(new RuleOne());
        this.offers.add(new RuleTwo());

    }

    @Override
    public double getTotalAmount(Map<String, Integer> list) {

        double total = 0.0;
        List<ProductChecker> checklist = createCheckList(list);

        if (offers != null && offers.size() > 0) {
            for (Offer offer : offers) {
                if (offer.check(list)) {
                    total += offer.apply(list, checklist);
                }
            }
        }

        if (hasUncheck(checklist)) {
            total += getAmountToBePaidForUncheck(checklist);
        }

        return total;
    }

    private boolean hasUncheck(List<ProductChecker> checklist) {

        boolean hasUncheck = false;

        for (ProductChecker p : checklist) {
            if (!p.isCheck()) {
                hasUncheck = true;
            }
        }

        return hasUncheck;
    }

    private double getAmountToBePaidForUncheck(List<ProductChecker> checklist) {

        double amountToBePaid = 0.0;

        for (ProductChecker p : checklist) {
            if (!p.isCheck()) {
                double price = catalogueService.get(p.getCode())
                    .getPrice();
                amountToBePaid += price;
            }
        }

        return amountToBePaid;
    }

    private List<ProductChecker> createCheckList(Map<String, Integer> list) {

        List<ProductChecker> checklist = new ArrayList<ProductChecker>();
        for (String key : list.keySet()) {
            int count = list.get(key);
            int ctr = 0;
            while (ctr < count) {
                checklist.add(new ProductChecker(key, null, 0.0));
                ctr++;
            }
        }

        return checklist;
    }

}
