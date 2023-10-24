package org.lab.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.lab.Book;
import org.lab.Patron;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatronTests {
    Patron patron;

    @BeforeEach
    public void init() {
        patron = new Patron("1234", "John");
    }
    @Test
    public void testPatronConstructor() {
        assertEquals(patron.uuid, "1234");
        assertEquals(patron.name, "John");
    }

    @Test
    public void testBorrowItem() {
        patron.borrowItem(new Book("1234", "The Hobbit", "J.R.R. Tolkien"));
        assertEquals(patron.borrowedItems.size(), 1);
    }

    @Test
    public void testReturnItem() {
        Book book = new Book("1234", "The Hobbit", "J.R.R. Tolkien");
        patron.borrowItem(book);
        patron.returnItem(book);
        assertEquals(patron.borrowedItems.size(), 0);
    }

}
