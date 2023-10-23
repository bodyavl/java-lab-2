package org.lab;

import java.util.ArrayList;

public class Library implements IManageable {
    private final ArrayList<Item> items;

    private final ArrayList<Patron> patrons;

    public Library() {
        items = new ArrayList<Item>();
        patrons = new ArrayList<Patron>();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Patron> getPatrons() {
        return patrons;
    }

    @Override
    public void add(Item item) {
        items.add(item);
    }

    @Override
    public void remove(String uuid) {
        for (Item item : items) {
            if (item.uuid.equals(uuid)) {
                items.remove(item);
                break;
            }
        }
    }

    @Override
    public ArrayList<Item> listAvailable() {
        ArrayList<Item> availableItems = new ArrayList<Item>();
        for (Item item : items) {
            if (!item.isBorrowed) {
                availableItems.add(item);
            }
        }
        return availableItems;
    }

    @Override
    public ArrayList<Item> listBorrowed() {
        ArrayList<Item> borrowedItems = new ArrayList<Item>();
        for (Item item : items) {
            if (item.isBorrowed) {
                borrowedItems.add(item);
            }
        }
        return borrowedItems;
    }

    public void registerPatron(Patron patron) {
        patrons.add(patron);
    }

    public void lendItem(Patron patron, Item item) {
        patron.borrowItem(item);
    }

    public void returnItem(Patron patron, Item item) {
        patron.returnItem(item);
    }

}
