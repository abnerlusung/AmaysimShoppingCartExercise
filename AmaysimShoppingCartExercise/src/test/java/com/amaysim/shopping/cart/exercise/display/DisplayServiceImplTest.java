package com.amaysim.shopping.cart.exercise.display;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amaysim.shopping.cart.exercise.catalogue.CatalogueService;
import com.amaysim.shopping.cart.exercise.domain.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:com/amaysim/shopping/cart/exercise/display/DisplayServiceImplTest.xml")
public class DisplayServiceImplTest {

    @Autowired
    private CatalogueService catalogue;

    private DisplayService displayService;

    @Before
    public void setup() {

        displayService = new DisplayServiceImpl(catalogue);

        EasyMock.reset(catalogue);
    }

    @Test
    public void test_print() {

        EasyMock.expect(catalogue.get("ult_small"))
            .andReturn(new Product("ult_small", "Unlimited 1GB", 24.90));
        EasyMock.replay(catalogue);
        String displayList = displayService.print(prepareList());
        assertNotNull(displayList);
        assertEquals(displayList, "1 x Unlimited 1GB");

        EasyMock.verify(catalogue);
    }

    private Map<String, Integer> prepareList() {

        Map<String, Integer> list = new HashMap<String, Integer>();

        list.put("ult_small", 1);

        return list;
    }

}
