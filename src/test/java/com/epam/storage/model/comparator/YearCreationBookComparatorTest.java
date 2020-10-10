package com.epam.storage.model.comparator;

import com.epam.storage.model.Book;
import org.junit.Assert;
import org.junit.Test;

public class YearCreationBookComparatorTest {

    private static final Book FIRST_BOOK = new Book(null, null, null, 2000, 0);
    private static final Book SECOND_BOOK = new Book(null, null, null, 2020, 0);
    private static final Book THIRD_BOOK = new Book(null, null, null, 2000, 0);

    private final YearCreationBookComparator comparator = new YearCreationBookComparator();

    @Test
    public void testCompareShouldReturnNegativeWhenYearOneIsLessThanYearTwo() {
        //when
        int actual = comparator.compare(FIRST_BOOK, SECOND_BOOK);
        //then
        Assert.assertTrue(actual < 0);
    }

    @Test
    public void testCompareShouldReturnPositiveWhenYearOneIsLessThanYearTwo() {
        //when
        int actual = comparator.compare(SECOND_BOOK, FIRST_BOOK);
        //then
        Assert.assertTrue(actual > 0);
    }

    @Test
    public void testCompareShouldReturnZeroWhenYearOneIsEqualsYearThree() {
        //when
        int actual = comparator.compare(THIRD_BOOK, FIRST_BOOK);
        //then
        Assert.assertTrue(actual == 0);
    }

}