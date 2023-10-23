package org.lab;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Main {

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
    }
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while (true){
            System.out.print("Enter a number of action:\n1 - Add item\n2 - Remove item\n3 - Register Patron\n4 - Give item to patron\n5 - Show available items\n6 - Show borrowed items and their patrons\n7 - Exit\n");
            int action = getNumberInputInRange(scanner, 7);
            switch (action) {
                case 1 -> {
                    System.out.print("Enter a number of item:\n1 - Book\n2 - DVD");
                    int item = getNumberInputInRange(scanner, 2);
                    System.out.print("Enter a title: ");
                    String title = scanner.nextLine();

                    switch (item) {
                        case 1 -> {
                            System.out.print("Enter a author: ");
                            String author = scanner.nextLine();
                            Book book = new Book(UUID.randomUUID().toString(), title, author);
                            library.add(book);
                        }
                        case 2 -> {
                            System.out.print("Enter a length: ");
                            int length = getNumberInputInRange(scanner, 1000);
                            DVD dvd = new DVD(UUID.randomUUID().toString(), title, length);
                            library.add(dvd);
                        }
                    }
                }
                case 2 -> {
                    for(Item item : library.listAvailable()) {
                        System.out.printf("Title: %s\n", item.title);
                        System.out.printf("UUID: %s\n", item.uuid);
                    }
                    System.out.print("Enter a uuid: ");
                    String uuid = scanner.nextLine();
                    library.remove(uuid);
                }
                case 3 -> {
                    System.out.print("Enter a name: ");
                    String name = scanner.nextLine();
                    Patron patron = new Patron(UUID.randomUUID().toString(), name);
                    library.registerPatron(patron);
                }
                case 4 -> {
                    System.out.print("Items: ");
                    for(Item item : library.listAvailable()) {
                        System.out.printf("Title: %s\n", item.title);
                        System.out.printf("UUID: %s\n", item.uuid);
                    }
                    System.out.println();
                    System.out.print("Patrons: ");
                    for(Patron patron : library.getPatrons()) {
                        System.out.printf("Name: %s\n", patron.name);
                        System.out.printf("UUID: %s\n", patron.uuid);
                    }

                    System.out.print("Enter an item uuid: ");
                    String itemUUID = scanner.nextLine();
                    System.out.print("Enter an patron uuid: ");
                    String patronUUID = scanner.nextLine();
                    Patron patron = null;
                    for (Patron p : library.getPatrons()) {
                        if (p.uuid.equals(patronUUID)) {
                            patron = p;
                            break;
                        }
                    }
                    if (patron == null) {
                        System.out.println("No patron was found with this data");
                        break;
                    }
                    Item item = null;
                    for (Item i : library.getItems()) {
                        if (i.uuid.equals(itemUUID)) {
                            item = i;
                            break;
                        }
                    }
                    if (item == null) {
                        System.out.println("No item was found with this data");
                        break;
                    }
                    if (item.isBorrowed) {
                        System.out.println("Item is already borrowed");
                    }

                    library.lendItem(patron, item);
                }
                case 5 -> {
                    if(library.listAvailable().isEmpty()) System.out.println("No available items");

                    for(Item item : library.listAvailable()) {
                        System.out.printf("Title: %s\n", item.title);
                        System.out.printf("UUID: %s\n\n", item.uuid);
                    }
                }
                case 6 -> {
                    if(library.listBorrowed().isEmpty()) System.out.println("No borrowed items");
                    for(Item item : library.listBorrowed()) {
                        System.out.printf("Title: %s\n", item.title);
                        System.out.printf("UUID: %s\n", item.uuid);
                        for (Patron patron : library.getPatrons()) {
                            if (patron.borrowedItems.contains(item)) {
                                System.out.printf("Patron: %s\n\n", patron.name);
                                System.out.printf("Patron UUID: %s\n\n", patron.uuid);

                                break;
                            }
                        }
                    }
                }
                case 7 -> {
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