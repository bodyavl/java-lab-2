package org.lab.testing;

import org.junit.jupiter.api.*;
import org.lab.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LibraryTests {
    Library library;

    @BeforeEach
    public void init() {
        library = new Library();
    }

    @Test
    public void testAddItem() {
        library.add(new Book("1234", "The Hobbit", "J.R.R. Tolkien"));
        assertEquals(library.getItems().size(), 1);
    }

    @Test
    public void testRemoveItem() {
        Book book = new Book("1234", "The Hobbit", "J.R.R. Tolkien");
        library.add(book);
        library.remove(book.uuid);
        assertEquals(library.getItems().size(), 0);
    }

    @Test
    public void testRegisterPatron() {
        library.registerPatron(new Patron("1234", "John"));
        assertEquals(library.getPatrons().size(), 1);
    }

    @Test
    public void testListAvailable() {
        DVD dvd = new DVD("1234", "The Hobbit", 500);
        library.add(dvd);
        ArrayList<Item> availableItems = library.listAvailable();
        assertEquals(availableItems.size(), 1);
    }

    @Test
    public void testLendItem() {
        Book book = new Book("1234", "The Hobbit", "J.R.R. Tolkien");
        Patron patron = new Patron("1234", "John");
        library.registerPatron(patron);
        library.add(book);
        library.lendItem(patron, book);
        assertEquals(library.listAvailable().size(), 0);
        assertEquals(library.listBorrowed().size(), 1);
    }

    @Test
    public void testReturnItem() {
        Book book = new Book("1234", "The Hobbit", "J.R.R. Tolkien");
        Patron patron = new Patron("1234", "John");
        library.registerPatron(patron);
        library.add(book);
        library.lendItem(patron, book);
        library.returnItem(patron, book);
        assertEquals(library.listBorrowed().size(), 0);
    }

}
