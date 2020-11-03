package com.epam.storage.data.dao.impl;

import com.epam.storage.data.dao.enums.BookFieldType;
import com.epam.storage.data.dao.specification.AbstractSpecification;
import com.epam.storage.data.dao.specification.factory.SpecificationFactory;
import com.epam.storage.exceptions.UnknownFieldTypeException;
import com.epam.storage.model.comparator.factory.ComparatorFactory;
import com.epam.storage.data.dao.Dao;
import com.epam.storage.exceptions.DaoException;
import com.epam.storage.model.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookDao implements Dao {
    private static final String EXISTING_BOOK_MESSAGE = "This book is already exist";
    private static final String NOT_EXISTING_BOOK_MESSAGE = "There are no such book.";
    private final SpecificationFactory specificationFactory = new SpecificationFactory();
    private final ComparatorFactory comparatorfactory = new ComparatorFactory();
    private final List<Book> books = new ArrayList<>();

    @Override
    public void add(Book book) throws DaoException {
        if (books.contains(book)) {
            throw new DaoException(EXISTING_BOOK_MESSAGE);
        }
        books.add(book);
    }

    @Override
    public void add(List<Book> books) throws DaoException {
        for (Book currentBook : books) {
            add(currentBook);
        }
    }

    @Override
    public void remove(Book book) throws DaoException {
        if (!books.contains(book)) {
            throw new DaoException(NOT_EXISTING_BOOK_MESSAGE);
        }
        books.remove(book);
    }

    @Override
    public <T> List<Book> findByTag(BookFieldType field, T name) throws UnknownFieldTypeException, DaoException {
        AbstractSpecification specification = specificationFactory.create(field);
        return specification.find(books, name);
    }


    @Override
    public void sortByTag(BookFieldType field) throws UnknownFieldTypeException {
        Comparator<Book> comparator = comparatorfactory.create(field);
        Collections.sort(books, comparator);
    }

    public int size() {
        return books.size();
    }
}
