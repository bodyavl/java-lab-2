package org.lab.testing;

import org.junit.jupiter.api.Test;
import org.lab.DVD;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DVDTests {
    @Test
    public void testDVDConstructor() {
        DVD dvd = new DVD("1234", "The Hobbit", 120);
        assertEquals("1234", dvd.uuid);
        assertEquals("The Hobbit", dvd.title);
        assertEquals(120, dvd.duration);
    }

    @Test
    public void testDVDBorrow() {
        DVD dvd = new DVD("1234", "The Hobbit", 120);
        dvd.borrowItem();
        assertEquals(true, dvd.isBorrowed);
    }

    @Test
    public void testDVDReturn() {
        DVD dvd = new DVD("1234", "The Hobbit", 120);
        dvd.returnItem();
        assertEquals(false, dvd.isBorrowed);
    }
}
