package com.epam.storage.data.dao.specification;


import com.epam.storage.data.dao.specification.impl.PublisherSpecification;
import com.epam.storage.exceptions.DaoException;
import com.epam.storage.model.Book;
import org.junit.Assert;
import org.junit.Test;

public class PublisherSpecificationTest {

    private static final Book BOOK = new Book("title", "author", "publisher", 2020, 20);
    private final PublisherSpecification specification = new PublisherSpecification();

    @Test
    public void testMatchesFieldShouldMatchWhenBookPublisherEqualsIgnoreCaseValue() throws DaoException {
        //given
        String value = "Publisher";
        //when
        boolean actual = specification.matchesField(BOOK, value);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testMatchesFieldShouldNotMatchWhenBookPublisherIsNotEqualsValue() throws DaoException {
        //given
        String value = "A";
        //when
        boolean actual = specification.matchesField(BOOK, value);
        //then
        Assert.assertFalse(actual);
    }
}