package com.example.jack_cheng.redux_demo.model.dto;

import java.util.List;

/**
 * Created by jack_cheng on 2017/1/10.
 */

public class FakeDataDTO {
    private String productName;
    private List<String> ColorName;
    private boolean isSoldOut;


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<String> getColorName() {
        return ColorName;
    }

    public void setColorName(List<String> colorName) {
        ColorName = colorName;
    }

    public boolean isSoldOut() {
        return isSoldOut;
    }

    public void setSoldOut(boolean soldOut) {
        isSoldOut = soldOut;
    }
}
