package com.amaysim.shopping.cart.exercise;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.amaysim.shopping.cart.exercise.catalogue.CatalogueService;
import com.amaysim.shopping.cart.exercise.compute.ComputeService;
import com.amaysim.shopping.cart.exercise.display.DisplayService;
import com.amaysim.shopping.cart.exercise.rule.RuleFour;
import com.amaysim.shopping.cart.exercise.rule.RuleThree;

public class CartServiceImpl
    implements CartService {

    @Autowired
    private CatalogueService catalogueService;

    @Autowired
    private DisplayService displayService;

    @Autowired
    private ComputeService computeService;

    @Autowired
    private RuleFour freeRule;

    private RuleThree promoRule;

    public RuleThree getPromoRule() {

        return promoRule;
    }

    public void setPromoRule(RuleThree promoRule) {

        this.promoRule = promoRule;
    }

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

    public CatalogueService getCatalogueService() {

        return catalogueService;
    }

    public void setCatalogueService(CatalogueService catalogueService) {

        this.catalogueService = catalogueService;
    }

    private Map<String, Integer> freeItems;

    private Map<String, Integer> purchasedItems;

    public CartServiceImpl() {
        super();
        this.purchasedItems = new HashMap<String, Integer>();
        this.freeItems = new HashMap<String, Integer>();
    }

    public CartServiceImpl(ComputeService computeService, DisplayService displayService,
                           CatalogueService catalogueService) {
        super();
        this.purchasedItems = new HashMap<String, Integer>();
        this.freeItems = new HashMap<String, Integer>();
        this.computeService = computeService;
        this.displayService = displayService;
        this.catalogueService = catalogueService;
    }

    public void addProduct(String itemCode) {

        if (itemCode == null) {
            // throw exception
        }

        addToList(itemCode, purchasedItems);

        if (freeRule.check(purchasedItems)) {
            addToList("ult_medium", freeItems);
        }

    }

    private void addToList(String itemCode, Map<String, Integer> list) {

        if (!catalogueService.isExist(itemCode)) {
            // throw exception
        }
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

        String displayList;

        if (freeItems.isEmpty()) {
            displayList = displayService.print(purchasedItems);
        } else {
            displayList = displayService.print(purchasedItems, freeItems);
        }

        return displayList;
    }

    public String getTotalAmount() {

        NumberFormat formatter = NumberFormat.getNumberInstance();
        double total = computeService.getTotalAmount(purchasedItems);

        if (promoRule != null && promoRule.check()) {
            total = 0.9 * total;
        }

        return formatter.format(total) + "";
    }

    public void addPromoCode(String promoCode) {

        if (!RuleThree.promoCode.equalsIgnoreCase(promoCode)) {
            // throw exception
        }

        promoRule = new RuleThree(promoCode);
    }

    @Override
    public void reset() {

        this.purchasedItems = new HashMap<String, Integer>();

    }

}
