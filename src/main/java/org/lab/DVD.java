package org.lab;

public class DVD extends Item{
    public int duration;
    public DVD(String uuid, String title, int duration) {
        super(uuid, title);
        this.duration = duration;
    }

    @Override
    public void borrowItem() {
        this.isBorrowed = true;
    }
    @Override
    public void returnItem() {
        this.isBorrowed = false;
    }
}
