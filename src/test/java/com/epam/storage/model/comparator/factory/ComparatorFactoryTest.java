package com.epam.storage.model.comparator.factory;

import com.epam.storage.data.dao.enums.BookFieldType;
import com.epam.storage.exceptions.UnknownFieldTypeException;
import com.epam.storage.model.comparator.AuthorBookComparator;
import com.epam.storage.model.comparator.YearCreationBookComparator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

public class ComparatorFactoryTest {
    private final ComparatorFactory creator = new ComparatorFactory();

    @Test
    public void testCreateShouldCreateAuthorBookComparatorWhenBookFieldIsAuthor() throws UnknownFieldTypeException {
        //when
        Comparator comparator = creator.create(BookFieldType.AUTHOR);
        //then
        Assert.assertTrue(comparator instanceof AuthorBookComparator);
    }

    @Test
    public void testCreateShouldCreateYearCreationBookComparatorWhenBookFieldIsYearCreation() throws UnknownFieldTypeException {
        //when
        Comparator comparator = creator.create(BookFieldType.YEAR_CREATION);
        //then
        Assert.assertTrue(comparator instanceof YearCreationBookComparator);
    }

}