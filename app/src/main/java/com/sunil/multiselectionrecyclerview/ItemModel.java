package com.sunil.multiselectionrecyclerview;

/**
 * Created by sunil on 12/17/16.
 */

public class ItemModel {

    private int id;
    private String name;
    private boolean isSelected;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
