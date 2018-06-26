package com.sears.android.dlm.Models;

public class VerticalModel {

    private String image;
    private String title;
    private boolean noTitle;

    public String getImage() {
        return image;
    }

    public VerticalModel(String image, String title, boolean noTitle) {
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

    public void setImage(String image) {
        this.image = image;
    }

}
