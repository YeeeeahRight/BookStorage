package com.epam.storage.data.dao.specification;


import com.epam.storage.data.dao.specification.impl.PagesSpecification;
import com.epam.storage.exceptions.DaoException;
import com.epam.storage.model.Book;
import org.junit.Assert;
import org.junit.Test;

public class PagesSpecificationTest {

    private static final Book BOOK = new Book("title", "author", "publisher", 2020, 10);
    private final PagesSpecification specification = new PagesSpecification();

    @Test
    public void testMatchesFieldShouldMatchWhenBookPagesEqualsValue() throws DaoException {
        //given
        int value = 10;
        //when
        boolean actual = specification.matchesField(BOOK, value);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testMatchesFieldShouldNotMatchWhenBookPagesIsNotEqualsValue() throws DaoException {
        //given
        int value = 0;
        //when
        boolean actual = specification.matchesField(BOOK, value);
        //then
        Assert.assertFalse(actual);
    }

    @Test(expected = DaoException.class)//then
    public void testMatchesFieldShouldThrowExceptionWhenValueIsEqualsNull() throws DaoException {
        //when
        specification.matchesField(BOOK, null);
    }

}