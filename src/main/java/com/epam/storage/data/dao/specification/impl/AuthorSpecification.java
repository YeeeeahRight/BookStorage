package com.epam.storage.data.dao.specification.impl;

import com.epam.storage.data.dao.specification.AbstractSpecification;
import com.epam.storage.model.Book;

public class AuthorSpecification extends AbstractSpecification<String> {

    @Override
    public boolean matchesField(Book book, String value) {
        String author = book.getAuthor();
        return author.equalsIgnoreCase(value);
    }
}
