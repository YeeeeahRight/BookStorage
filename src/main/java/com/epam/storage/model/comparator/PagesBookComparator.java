package com.epam.storage.model.comparator;

import com.epam.storage.model.Book;

import java.util.Comparator;

public class PagesBookComparator implements Comparator<Book> {
    @Override
    public int compare(Book firstBook, Book secondBook) {
        int firstPages = firstBook.getPages();
        int secondPages = secondBook.getPages();
        return firstPages - secondPages;
    }
}
