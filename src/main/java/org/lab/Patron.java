package org.lab;

import java.util.ArrayList;

public class Patron {
    public String name;
    public String uuid;
    public ArrayList<Item> borrowedItems;

    public Patron(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
        this.borrowedItems = new ArrayList<Item>();
    }

    public void borrowItem(Item item) {
        item.borrowItem();
        borrowedItems.add(item);
    }

    public void returnItem(Item item) {
        item.returnItem();
        borrowedItems.remove(item);
    }
}
