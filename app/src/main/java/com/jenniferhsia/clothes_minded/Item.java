package com.jenniferhsia.clothes_minded;

import java.util.HashMap;

/**
 * Created by jenniferhsia on 1/27/18.
 */

public class Item {
    public final String name;
    public final String color;
    public final String size;
    public final HashMap<String, Float> composition = new HashMap<>();
    public final double price;



    public Item(String name, String color, String size, String[] strArr, float[] fltArr, double price) {
        this.name = name;
        this.color = color;
        this.size = size;
        this.price = price;
        for(int i = 0; i < strArr.length; i++) {
            this.composition.put(strArr[i], fltArr[i]);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
