package org.lab.testing;

import org.junit.jupiter.api.Test;
import org.lab.Book;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTests {

    @Test
    public void testBookConstructor() {
        Book book = new Book("1234", "The Hobbit", "J.R.R. Tolkien");
        assertEquals("1234", book.uuid);
        assertEquals("The Hobbit", book.title);
        assertEquals("J.R.R. Tolkien", book.author);
    }

    @Test
    public void testBookBorrow() {
        Book book = new Book("1234", "The Hobbit", "J.R.R. Tolkien");
        book.borrowItem();
        assertEquals(true, book.isBorrowed);
    }

    @Test
    public void testBookReturn() {
        Book book = new Book("1234", "The Hobbit", "J.R.R. Tolkien");
        book.returnItem();
        assertEquals(false, book.isBorrowed);
    }

}
