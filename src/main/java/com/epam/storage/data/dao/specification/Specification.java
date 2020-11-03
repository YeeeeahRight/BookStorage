package com.epam.storage.data.dao.specification;

import com.epam.storage.exceptions.DaoException;
import com.epam.storage.model.Book;

import java.util.List;

public interface Specification<T> {
    List<Book> find(List<Book> books, T value) throws DaoException;
}
