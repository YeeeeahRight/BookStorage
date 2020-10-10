package com.epam.storage.data.dao.specification;

import com.epam.storage.exceptions.DaoException;
import com.epam.storage.model.Book;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSpecification<T> implements Specification<T> {
    protected static final String NULL_VALUE = "Value is null.";

    public abstract boolean matchesField(Book book, T value) throws DaoException;

    @Override
    public List<Book> find(List<Book> books, T value) throws DaoException {
        List<Book> searchedBooks = new ArrayList<>();
        for (Book book : books) {
            if (matchesField(book, value)) {
                searchedBooks.add(book);
            }
        }
        return searchedBooks;
    }
}
