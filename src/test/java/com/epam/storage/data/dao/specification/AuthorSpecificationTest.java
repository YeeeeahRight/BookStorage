package com.epam.storage.data.dao.specification;

import com.epam.storage.data.dao.specification.impl.AuthorSpecification;
import com.epam.storage.exceptions.DaoException;
import com.epam.storage.model.Book;
import org.junit.Assert;
import org.junit.Test;

public class AuthorSpecificationTest {

    private static final Book BOOK = new Book("title", "author", "publisher", 2020, 10);
    private final AuthorSpecification specification = new AuthorSpecification();

    @Test
    public void testMatchesFieldShouldMatchWhenBookFieldAuthorEqualsIgnoreCaseValue() throws DaoException {
        //given
        String value = "Author";
        //when
        boolean actual = specification.matchesField(BOOK, value);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testMatchesFieldShouldNotMatchWhenBookFieldAuthorNotEqualsValue() throws DaoException {
        //given
        String value = "A";
        //when
        boolean actual = specification.matchesField(BOOK, value);
        //then
        Assert.assertFalse(actual);
    }
}