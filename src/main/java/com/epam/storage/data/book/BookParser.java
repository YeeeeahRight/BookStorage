package com.epam.storage.data.book;

import com.epam.storage.model.Book;

public class BookParser {
    private static final String LINE_SEPARATOR = "\\s+";

    public Book parse(String line) {
        String[] bookFields = line.split(LINE_SEPARATOR);
        String title = bookFields[0];
        String author = bookFields[1];
        String publisher = bookFields[2];
        int year = Integer.parseInt(bookFields[3]);
        int numPages = Integer.parseInt(bookFields[4]);
        return new Book(title, author, publisher, year, numPages);
    }
}
