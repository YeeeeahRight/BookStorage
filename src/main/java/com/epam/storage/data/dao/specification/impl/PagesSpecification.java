package com.epam.storage.data.dao.specification.impl;

import com.epam.storage.data.dao.specification.AbstractSpecification;
import com.epam.storage.exceptions.DaoException;
import com.epam.storage.model.Book;

public class PagesSpecification extends AbstractSpecification<Integer> {

    @Override
    public boolean matchesField(Book book, Integer value) throws DaoException {
        int pages = book.getPages();
        if (value == null) {
            throw new DaoException(NULL_VALUE);
        }
        return value.equals(pages);
    }
}
