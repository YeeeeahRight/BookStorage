package com.epam.storage.model.comparator;

import com.epam.storage.model.Book;
import org.junit.Assert;
import org.junit.Test;

public class PagesBookComparatorTest {

    private static final Book FIRST_BOOK = new Book(null, null, null, 0, 10);
    private static final Book SECOND_BOOK = new Book(null, null, null, 0, 20);
    private static final Book THIRD_BOOK = new Book(null, null, null, 0, 10);

    private final PagesBookComparator comparator = new PagesBookComparator();

    @Test
    public void testCompareShouldReturnNegativeWhenPagesOneIsLessThanNumPagesTwo() {
        //when
        int actual = comparator.compare(FIRST_BOOK, SECOND_BOOK);
        //then
        Assert.assertTrue(actual < 0);
    }

    @Test
    public void testCompareShouldReturnPositiveWhenPagesOneIsLessThanPagesTwo() {
        //when
        int actual = comparator.compare(SECOND_BOOK, FIRST_BOOK);
        //then
        Assert.assertTrue(actual > 0);
    }

    @Test
    public void testCompareShouldReturnZeroWhenPagesOneIsEqualsPagesThree() {
        //when
        int actual = comparator.compare(THIRD_BOOK, FIRST_BOOK);
        //then
        Assert.assertTrue(actual == 0);
    }

}