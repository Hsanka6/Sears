package com.sears.android.dlm.Models;

public class HorizontalModel {



    private String image;
    private String title;
    private String price;
    private boolean isReduced;
    private String reducedPrice;

    public HorizontalModel(String image, String title, String price, boolean isReduced, String reducedPrice) {
        this.image = image;
        this.title = title;
        this.price = price;
        this.isReduced = isReduced;
        this.reducedPrice = reducedPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isReduced() {
        return isReduced;
    }

    public void setReduced(boolean reduced) {
        isReduced = reduced;
    }

    public String getReducedPrice() {
        return reducedPrice;
    }

    public void setReducedPrice(String reducedPrice) {
        this.reducedPrice = reducedPrice;
    }
}
