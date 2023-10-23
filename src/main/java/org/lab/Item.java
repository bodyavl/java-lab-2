package org.lab;

abstract public class Item {
public String title;
    public String uuid;
    public Boolean isBorrowed;

    public Item(String uuid, String title) {
        this.uuid = uuid;
        this.title = title;
        this.isBorrowed = false;
    }

    abstract void borrowItem();

    abstract void returnItem();

}

