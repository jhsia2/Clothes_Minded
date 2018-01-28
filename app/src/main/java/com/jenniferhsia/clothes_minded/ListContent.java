package com.jenniferhsia.clothes_minded;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class ListContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Item> ITEMS = new ArrayList<Item>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Item> ITEM_MAP = new HashMap<String, Item>();

    /*static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createItem(i));
        }
    }*/

    static {
        String[] strArr = {"Cotton", "Nylon", "Polyester"};
        float[] floatArr = {90.0f, 7.0f, 3.0f};
        Item item1 = new Item("Dress", "Blue", "S", strArr, floatArr, 65);
        addItem(item1);
        makeDetails("Dress");

        String[] strArr2 = {"Wool", "Cotton"};
        float[] floatArr2 = {75.0f, 25.0f};
        Item item2 = new Item("Pants", "Red", "M", strArr2, floatArr2, 25);
        addItem(item2);
        makeDetails("Pants");
    }

    private static void addItem(Item item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.name, item);
    }


    private static String makeDetails(String name) {
        StringBuilder builder = new StringBuilder();
        Item demo = ITEM_MAP.get(name);
        Map<String, Float> composition = demo.composition;
        Iterator<Map.Entry<String,Float>> itr = composition.entrySet().iterator();
        while(itr.hasNext())
        {
            Map.Entry<String, Float> entry = itr.next();
            builder.append("\nMaterial = " + entry.getKey() +
                    "(" + entry.getValue() + ")");
        }
        return builder.toString();
    }
    
}
