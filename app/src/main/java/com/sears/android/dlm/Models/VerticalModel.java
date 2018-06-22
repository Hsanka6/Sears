package com.sears.android.dlm.Models;

public class VerticalModel {

    private int image;
    private String title;
    private boolean noTitle;

    public int getImage() {
        return image;
    }

    public VerticalModel(int image, String title, boolean noTitle) {
        this.image = image;
        this.title = title;
        this.noTitle = noTitle;
    }

    public String getTitle() {
        return title;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isNoTitle() {
        return noTitle;
    }

    public void setNoTitle(boolean noTitle) {
        this.noTitle = noTitle;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
