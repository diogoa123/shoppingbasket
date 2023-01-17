package com.interview.shoppingbasket;

import java.util.List;

public class RetailPriceCheckoutStep implements CheckoutStep {
    private PricingService pricingService;
    private PromotionsService promotionsService;
    private double retailTotal;

    public RetailPriceCheckoutStep(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    @Override
    public void execute(CheckoutContext checkoutContext) {
        Basket basket = checkoutContext.getBasket();
        retailTotal = 0.0;

        for (BasketItem basketItem: basket.getItems()) {
            int quantity = basketItem.getQuantity();
            double price = pricingService.getPrice(basketItem.getProductCode());
            basketItem.setProductRetailPrice(price);
            retailTotal += quantity*price;
        }

       /* List<Promotion> promotionList = promotionsService.getPromotions(basket);
        if(!promotionList.isEmpty()) {
            for (Promotion promotion : promotionList) {
                for (BasketItem basketItem : basket.getItems()) {
                    applyPromotion(promotion, basketItem, pricingService.getPrice(basketItem.getProductCode()));
                }
            }
        }*/


        checkoutContext.setRetailPriceTotal(retailTotal);

    }

    public double applyPromotion(Promotion promotion, BasketItem item, double price) {
        //applyPromotion in the BasketItem? should be the basket because of the twoforone fixed promo in some products, confused as to what i'm "able" to change to resolve the problem
        return retailTotal;
    }
}
