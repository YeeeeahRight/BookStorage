package com.epam.storage.model.comparator;

import com.epam.storage.model.Book;

import java.util.Comparator;

public class AuthorBookComparator implements Comparator<Book> {

    @Override
    public int compare(Book firstBook, Book secondBook) {
        String firstAuthor = firstBook.getAuthor();
        String secondAuthor = secondBook.getAuthor();
        if ((firstAuthor == null) && (secondAuthor == null)) {
            return 0;
        }
        if (firstAuthor == null) {
            return -1;
        }
        if (secondAuthor == null) {
            return 1;
        }
        return firstAuthor.compareToIgnoreCase(secondAuthor);
    }
}
