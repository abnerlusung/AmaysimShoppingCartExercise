package com.amaysim.shopping.cart.exercise.compute;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amaysim.shopping.cart.exercise.catalogue.CatalogueService;
import com.amaysim.shopping.cart.exercise.domain.Product;
import com.amaysim.shopping.cart.exercise.rule.Offer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:com/amaysim/shopping/cart/exercise/compute/ComputeServiceImplTest.xml")
public class ComputeServiceImplTest {

    @Autowired
    private CatalogueService catalogue;

    @Autowired
    @Qualifier("ruleOne")
    private Offer offer;

    private ComputeService computeService;

    @Before
    public void setup() {

        EasyMock.reset(catalogue, offer);
        List<Offer> offers = new ArrayList<Offer>();
        offers.add(offer);
        computeService = new ComputeServiceImpl(catalogue, offers);
    }

    @Test
    public void test_getTotalAmount() {

        EasyMock.expect(offer.check(prepareList()))
            .andReturn(false);
        EasyMock.expect(catalogue.get("ult_small"))
            .andReturn(new Product("ult_small", "dummy name", 123.45));
        EasyMock.replay(catalogue, offer);
        double amount = computeService.getTotalAmount(prepareList());
        assertEquals(String.valueOf(amount), "123.45");
        EasyMock.verify(catalogue, offer);
    }

    private Map<String, Integer> prepareList() {

        Map<String, Integer> list = new HashMap<String, Integer>();

        list.put("ult_small", 1);

        return list;
    }

}
