package com.interview.shoppingbasket;

import java.util.*;

public class Basket {
    private List<BasketItem> items = new ArrayList<>();

    public void add(String productCode, String productName, int quantity) {
        BasketItem basketItem = new BasketItem();
        basketItem.setProductCode(productCode);
        basketItem.setProductName(productName);
        basketItem.setQuantity(quantity);

        items.add(basketItem);
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public void consolidateItems() {
        // Exercise - implement this function
        List<BasketItem> mergedItems = new ArrayList<>();

        search: for (BasketItem basketItem : getItems()) {
            if(!mergedItems.isEmpty()) {
                for (BasketItem mergedBasketItem: mergedItems) {
                    if(mergedBasketItem.getProductCode().equals(basketItem.getProductCode())){
                        mergedBasketItem.setQuantity(mergedBasketItem.getQuantity()+ basketItem.getQuantity());
                        continue search;
                    }
                }
            }
            mergedItems.add(basketItem);
        }
    }
}
