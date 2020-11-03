package com.epam.storage.model.comparator;

import com.epam.storage.model.Book;

import java.util.Comparator;

public class PublisherBookComparator implements Comparator<Book> {

    @Override
    public int compare(Book firstBook, Book secondBook) {
        String firstPublisher = firstBook.getPublisher();
        String secondPublisher = secondBook.getPublisher();
        if ((firstPublisher == null) && (secondPublisher == null)) {
            return 0;
        }
        if (firstPublisher == null) {
            return -1;
        }
        if (secondPublisher == null) {
            return 1;
        }
        return firstPublisher.compareToIgnoreCase(secondPublisher);
    }
}
