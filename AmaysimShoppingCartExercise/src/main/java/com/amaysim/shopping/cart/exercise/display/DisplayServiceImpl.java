package com.amaysim.shopping.cart.exercise.display;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.amaysim.shopping.cart.exercise.catalogue.CatalogueService;

/**
 * Responsible for creating the display for the list of products purchased
 */
public class DisplayServiceImpl
    implements DisplayService {

    private CatalogueService catalogueService;

    public DisplayServiceImpl(CatalogueService catalogue) {
        this.catalogueService = catalogue;
    }

    public CatalogueService getCatalogueService() {

        return catalogueService;
    }

    @Autowired
    public void setCatalogueService(CatalogueService catalogueService) {

        this.catalogueService = catalogueService;
    }

    public String print(Map<String, Integer> list) {

        StringBuffer message = new StringBuffer();
        Set<String> keys = list.keySet();

        for (Iterator<String> iterator = keys.iterator(); iterator.hasNext();) {
            String key = (String) iterator.next();
            message.append(list.get(key));
            message.append(" x ");
            message.append(catalogueService.get(key)
                .getName());
            if (iterator.hasNext()) {
                message.append("\n");
            }
        }

        return message.toString();

    }

    @Override
    public String print(Map<String, Integer> purchasedItems, Map<String, Integer> freeItems) {

        StringBuffer displayList = new StringBuffer();
        displayList.append(this.print(purchasedItems));
        displayList.append("\n");
        for (Map.Entry<String, Integer> entry : freeItems.entrySet()) {
            displayList.append(entry.getValue());
            displayList.append(" x ");
            displayList.append(catalogueService.get(entry.getKey())
                .getName());
        }

        return displayList.toString();
    }

}
