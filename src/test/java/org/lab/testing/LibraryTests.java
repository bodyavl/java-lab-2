package org.lab.testing;

import org.junit.jupiter.api.*;
import org.lab.Book;
import org.lab.Library;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LibraryTests {
    private static final Library library = new Library();
    private static final Book mockBook = new Book("title", "author", 0, 0);

    @Test

    public void testAddBook() {
        Book book = library.AddBook(mockBook);
        assertEquals(mockBook, book);
    }

    @Test

    public void testGetBookByTitle() {
        Book book = library.GetBookByTitle(mockBook.title);
        assertEquals(mockBook, book);
    }

    @Test

    public void testShowBooks() {
        ArrayList<Book> books = library.ShowBooks();
        if(!books.contains(mockBook))
            throw new AssertionError("Book should be in library");
    }

    @Test

    public void testRemoveBookByISBN() {
        var book = library.RemoveBookByISBN(mockBook.ISBN);
        if(library.ShowBooks().contains(mockBook))
            throw new AssertionError("Book should be removed from library");
    }
}
