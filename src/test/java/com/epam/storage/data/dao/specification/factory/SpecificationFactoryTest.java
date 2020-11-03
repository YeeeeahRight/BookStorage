package com.epam.storage.data.dao.specification.factory;

import com.epam.storage.data.dao.enums.BookFieldType;
import com.epam.storage.data.dao.specification.*;
import com.epam.storage.data.dao.specification.impl.AuthorSpecification;
import com.epam.storage.data.dao.specification.impl.YearCreationSpecification;
import com.epam.storage.exceptions.UnknownFieldTypeException;
import org.junit.Assert;
import org.junit.Test;

public class SpecificationFactoryTest {

    private final SpecificationFactory factory = new SpecificationFactory();

    @Test
    public void testCreateShouldReturnAuthorSpecificationWhenBookFieldAuthor() throws UnknownFieldTypeException {
        //when
        AbstractSpecification specification = factory.create(BookFieldType.AUTHOR);
        //then
        Assert.assertTrue(specification instanceof AuthorSpecification);
    }

    @Test
    public void testCreateShouldReturnYearSpecificationWhenBookFieldYear() throws UnknownFieldTypeException {
        //when
        AbstractSpecification specification = factory.create(BookFieldType.YEAR_CREATION);
        //then
        Assert.assertTrue(specification instanceof YearCreationSpecification);
    }

}