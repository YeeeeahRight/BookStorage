package com.epam.storage.model.comparator;

import com.epam.storage.model.Book;

import java.util.Comparator;

public class YearCreationBookComparator implements Comparator<Book> {
    @Override
    public int compare(Book firstBook, Book secondBook) {
        int firstYear = firstBook.getYearCreation();
        int secondYear = secondBook.getYearCreation();
        return firstYear - secondYear;
    }
}
