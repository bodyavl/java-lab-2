package org.lab;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static long getISBN(Scanner in) {
        String message = "The value was not valid, please, ISBN should be 10 or 13 numbers";
        while (in.hasNext()) {
            if (in.hasNextLong()) {
                String val = in.nextLine();
                if (val.length() == 10 || val.length() == 13) {
                    return Long.parseLong(val);
                }
                else {
                    System.out.println(message);
                }
            } else {
                System.out.println(message);
                in.nextLine();
            }
        }
        return -1;
    }
    public static int getNumberInputInRange(Scanner in, int range) {
        String message = String.format("The value was not valid, please, enter number in range (0-%s): ", range);
        while (in.hasNext()) {
            if (in.hasNextInt()) {
                int val = Integer.parseInt(in.nextLine());
                if (val >= 1 && val <= range) {
                    return val;
                }
                else {
                    System.out.println(message);
                }
            } else {
                System.out.println(message);
                in.nextLine();
            }
        }
        return -1;
    }
    public static void displayBook(Book book) {
        if (book == null) {
            System.out.println("No book was found with this data");
            return;
        }
        System.out.printf("Title: %s\n", book.title);
        System.out.printf("Author: %s\n", book.author);
        System.out.printf("ISBN: %s\n", book.ISBN);
        System.out.printf("Release Year: %s\n", book.releaseYear);
    }
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while (true){
            System.out.print("Enter a number of action:\n1 - Add book\n2 - Search book by title\n3 - Remove book by ISBN\n4 - Show all books\n5 - Exit application\n");
            int action = getNumberInputInRange(scanner, 5);
            switch (action) {
                case 1 -> {
                    System.out.println("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.println("Enter ISBN: ");
                    long ISBN = getISBN(scanner);
                    System.out.println("Enter release year: ");
                    int releaseYear = getNumberInputInRange(scanner, 2023);
                    displayBook(library.AddBook(new Book(title, author, ISBN, releaseYear)));
                }
                case 2 -> {
                    System.out.println("Enter title: ");
                    String bookTitle = scanner.nextLine();
                    displayBook(library.GetBookByTitle(bookTitle));
                }
                case 3 -> {
                    System.out.println("Enter ISBN: ");
                    long bookISBN = Long.parseLong(scanner.nextLine());
                    Book removedBook = library.RemoveBookByISBN(bookISBN);
                    if (removedBook != null) System.out.println("Removed Book: ");
                    displayBook(removedBook);
                }
                case 4 -> {
                    ArrayList<Book> books = library.ShowBooks();
                    if (books.isEmpty()) {
                        System.out.println("No books yet");
                        break;
                    }
                    for (Book book : books) {
                        displayBook(book);
                        System.out.println();
                    }
                }
                case 5 -> {
                    isRunning = false;
                }
            }
            if (!isRunning) break;
            System.out.println("Continue? yes/no");
            String answer = scanner.nextLine();
            if(answer.equalsIgnoreCase("no")) break;

        }

    }
}