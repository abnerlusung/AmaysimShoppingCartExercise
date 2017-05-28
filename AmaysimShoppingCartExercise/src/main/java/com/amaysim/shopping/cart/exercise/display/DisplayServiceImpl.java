package com.amaysim.shopping.cart.exercise.display;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.amaysim.shopping.cart.exercise.domain.Display;
import com.amaysim.shopping.cart.exercise.domain.Product;

/**
 *
 *
 */
public class DisplayServiceImpl
    implements DisplayService {

    public String print(List<Product> list) {

        Map<String, Display> displays = new HashMap<String, Display>();

        for (Product product : list) {
            add(product, displays);
        }

        return getDisplay(displays);

    }

    private String getDisplay(Map<String, Display> displays) {

        StringBuffer message = new StringBuffer();
        Set<String> keys = displays.keySet();

        for (Iterator<String> iterator = keys.iterator(); iterator.hasNext();) {
            String key = (String) iterator.next();
            Display display = displays.get(key);
            message.append(display.getCount());
            message.append(" x ");
            message.append(display.getName());
            if (iterator.hasNext()) {
                message.append("\n");
            }
        }

        return message.toString();
    }

    private void add(Product product, Map<String, Display> displays) {

        Display display;
        if (isExist(product.getCode(), displays)) {
            display = displays.get(product.getCode());
            display.setCount(display.getCount() + 1);
        } else {
            display = new Display();
            display.setCount(1);
            display.setName(product.getName());
        }

        displays.put(product.getCode(), display);
    }

    private boolean isExist(String code, Map<String, Display> displays) {

        boolean existing = false;

        if (displays.get(code) != null) {
            existing = true;
        }

        return existing;
    }

}
