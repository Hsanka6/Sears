package com.sears.android.dlm.Models;

public class GridModel {
    private int[] iconId;
    private String[] nameList;

    public GridModel(int[] iconId, String[] nameList) {
        this.iconId = iconId;
        this.nameList = nameList;
    }

    public int[] getIconId() {
        return iconId;
    }

    public void setIconId(int[] iconId) {
        this.iconId = iconId;
    }

    public String[] getNameList() {
        return nameList;
    }

    public void setNameList(String[] nameList) {
        this.nameList = nameList;
    }
}

