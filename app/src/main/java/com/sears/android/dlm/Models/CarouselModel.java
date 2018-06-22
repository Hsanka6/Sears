package com.sears.android.dlm.Models;

public class CarouselModel {
    public String[] getSampleImages() {
        return sampleImages;
    }

    public void setSampleImages(String[] sampleImages) {
        this.sampleImages = sampleImages;
    }

    public CarouselModel(String[] sampleImages) {
        this.sampleImages = sampleImages;
    }

    private String[] sampleImages;

}
