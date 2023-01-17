package com.interview.shoppingbasket;

public class Promotion {
    // Not yet implemented
    private String promotionType;
    private String productCode;

    public Promotion(String promotionType, String productCode) {
        this.promotionType = promotionType;
        this.productCode = productCode;
    }

    public double applyPromo(Promotion promotion,boolean moreThanOne){
        if(promotion.promotionType.equals("TWOFORONE") && moreThanOne){
            return 0.5;
        }
        if(promotion.promotionType.equals("FIFTYPERCENT")){
            return 0.5;
        }
        if(promotion.promotionType.equals("TENPERCENT")){
            return 0.1;
        }
        return 1;
    }
}