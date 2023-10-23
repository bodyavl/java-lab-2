package org.lab.testing;

import org.junit.jupiter.api.Test;
import org.lab.Book;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTests {

    @Test
    public void testCreateBook () {
        final String title = "title";
        final String author = "author";
        final long ISBN = 0;
        final int releaseYear = 0;
        Book book = new Book(title, author, ISBN, releaseYear);
        assertEquals(book.title, title,"book.title should equal 'title'");
        assertEquals(book.author, author,"book.author should equal 'author'");
        assertEquals(book.ISBN, ISBN,"book.ISBN should equal 'ISBN'");
        assertEquals(book.releaseYear, releaseYear,"book.releaseYear should equal 'releaseYear'");
    }
}
