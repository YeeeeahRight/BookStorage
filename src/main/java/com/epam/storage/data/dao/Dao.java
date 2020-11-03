package com.epam.storage.data.dao;

import com.epam.storage.data.dao.enums.BookFieldType;
import com.epam.storage.exceptions.UnknownFieldTypeException;
import com.epam.storage.exceptions.DaoException;
import com.epam.storage.model.Book;

import java.util.List;

public interface Dao {
    void add(Book book) throws DaoException;
    void add(List<Book> books) throws DaoException;
    void remove(Book book) throws DaoException;
    <T> List<Book> findByTag(BookFieldType fieldType, T name) throws UnknownFieldTypeException, DaoException;
    void sortByTag(BookFieldType fieldType) throws UnknownFieldTypeException;
}
