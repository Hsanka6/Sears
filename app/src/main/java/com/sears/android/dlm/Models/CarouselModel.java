package com.sears.android.dlm.Models;

public class CarouselModel {
    public int[] getSampleImages() {
        return sampleImages;
    }

    public void setSampleImages(int[] sampleImages) {
        this.sampleImages = sampleImages;
    }

    public CarouselModel(int[] sampleImages) {
        this.sampleImages = sampleImages;
    }

    private int[] sampleImages;

}
