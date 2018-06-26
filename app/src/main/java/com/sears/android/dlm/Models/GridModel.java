package com.sears.android.dlm.Models;

public class GridModel {
    private String[] icons;
    private String[] nameList;

    public GridModel(String[] iconId, String[] nameList) {
        this.icons = iconId;
        this.nameList = nameList;
    }

    public String[] getIconId() {
        return icons;
    }

    public void setIconId(String[] icons) {
        this.icons = icons;
    }

    public String[] getNameList() {
        return nameList;
    }

    public void setNameList(String[] nameList) {
        this.nameList = nameList;
    }
}

