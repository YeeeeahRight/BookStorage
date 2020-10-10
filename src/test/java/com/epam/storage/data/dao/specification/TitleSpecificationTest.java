package com.epam.storage.data.dao.specification;

import com.epam.storage.data.dao.specification.impl.TitleSpecification;
import com.epam.storage.exceptions.DaoException;
import com.epam.storage.model.Book;
import org.junit.Assert;
import org.junit.Test;

public class TitleSpecificationTest {

    private static final Book BOOK = new Book("title", "author", "publisher", 2020, 10);
    private final TitleSpecification specification = new TitleSpecification();

    @Test
    public void testMatchesFieldShouldMatchWhenBookTitleEqualsIgnoreCaseValue() throws DaoException {
        //given
        String value = "title";
        //when
        boolean actual = specification.matchesField(BOOK, value);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testMatchesFieldShouldNotMatchWhenBookTitleIsNotEqualsValue() throws DaoException {
        //given
        String value = "A";
        //when
        boolean actual = specification.matchesField(BOOK, value);
        //then
        Assert.assertFalse(actual);
    }
}