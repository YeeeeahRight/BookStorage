package com.epam.storage.data.dao.specification;


import com.epam.storage.data.dao.specification.impl.YearCreationSpecification;
import com.epam.storage.exceptions.DaoException;
import com.epam.storage.model.Book;
import org.junit.Assert;
import org.junit.Test;

public class YearCreationSpecificationTest {

    private static final Book BOOK = new Book("title", "author", "publisher", 2020, 20);
    private final YearCreationSpecification specification = new YearCreationSpecification();

    @Test
    public void testMatchesFieldShouldMatchWhenBookYearCreationIsEqualsValue() throws DaoException {
        //given
        int value = 2020;
        //when
        boolean actual = specification.matchesField(BOOK, value);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testMatchesFieldShouldNotMatchWhenBookYearCreationIsNotEqualsValue() throws DaoException {
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