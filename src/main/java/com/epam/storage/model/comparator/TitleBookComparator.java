package com.epam.storage.model.comparator;

import com.epam.storage.model.Book;

import java.util.Comparator;

public class TitleBookComparator implements Comparator<Book> {

    @Override
    public int compare(Book firstBook, Book secondBook) {
        String titleOne = firstBook.getTitle();
        String titleTwo = secondBook.getTitle();
        if ((titleOne == null) && (titleTwo == null)) {
            return 0;
        }
        if (titleOne == null) {
            return -1;
        }
        if (titleTwo == null) {
            return 1;
        }
        return titleOne.compareToIgnoreCase(titleTwo);
    }
}
