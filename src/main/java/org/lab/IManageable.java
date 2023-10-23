package org.lab;

import java.util.ArrayList;

public interface IManageable {
    void add(Item item);
    void remove(String uuid);
    ArrayList<Item> listAvailable();
    ArrayList<Item> listBorrowed();
}
