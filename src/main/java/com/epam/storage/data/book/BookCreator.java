package com.epam.storage.data.book;

import com.epam.storage.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookCreator {
    private final BookParser bookParser;

    public BookCreator(BookParser bookParser) {
        this.bookParser = bookParser;
    }

    public List<Book> createBooks(List<String> lines) {
        List<Book> books = new ArrayList<>();
        for (String line : lines) {
            Book book = bookParser.parse(line);
            books.add(book);
        }
        return books;
    }
}
