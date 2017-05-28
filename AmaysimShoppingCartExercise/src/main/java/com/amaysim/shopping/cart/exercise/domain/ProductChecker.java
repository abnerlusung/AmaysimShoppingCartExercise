package com.amaysim.shopping.cart.exercise.domain;

public class ProductChecker
    extends Product {

    private boolean isCheck;

    public ProductChecker(String code, String name, double price) {
        super(code, name, price);
        this.isCheck = false;
    }

    public boolean isCheck() {

        return isCheck;
    }

    public void setCheck(boolean isCheck) {

        this.isCheck = isCheck;
    }

}
