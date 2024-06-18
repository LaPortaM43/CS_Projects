package edu.monmouth.hw6;

import java.util.Comparator;

import edu.monmouth.book.Book;

public class BookPrice implements Comparator<Book> {

    @Override
    public int compare(Book book1, Book book2) {
        // Compare books based on their price (lowest to highest)
        if (book1.getPrice() < book2.getPrice()) {
            return -1;
        } else if (book1.getPrice() > book2.getPrice()) {
            return 1;
        } else {
            return 0;
        }
    }
}

