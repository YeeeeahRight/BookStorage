package com.epam.storage.model.comparator;

import com.epam.storage.model.Book;
import org.junit.Assert;
import org.junit.Test;

public class PublisherBookComparatorTest {

    private static final Book FIRST_BOOK = new Book(null, null, "a", 0, 0);
    private static final Book SECOND_BOOK = new Book(null, null, "b", 0, 0);
    private static final Book THIRD_BOOK = new Book(null, null, "a", 0, 0);
    private static final Book NULL_BOOK = new Book(null, null, null, 0, 0);

    private final PublisherBookComparator comparator = new PublisherBookComparator();

    @Test
    public void testCompareShouldReturnNegativeWhenPublisherNullComparePublisherNotNull() {
        //when
        int actual = comparator.compare(NULL_BOOK, FIRST_BOOK);
        //then
        Assert.assertTrue(actual < 0);
    }

    @Test
    public void testCompareShouldReturnPositiveWhenPublisherNotNullComparePublisherNull() {
        //when
        int actual = comparator.compare(FIRST_BOOK, NULL_BOOK);
        //then
        Assert.assertTrue(actual > 0);
    }

    @Test
    public void testCompareShouldReturnZeroWhenPublisherNullComparePublisherNull() {
        //when
        int actual = comparator.compare(NULL_BOOK, NULL_BOOK);
        //then
        Assert.assertTrue(actual == 0);
    }

    @Test
    public void testCompareShouldReturnNegativeWhenPublisherOneIsLessThanPublisherTwo() {
        //when
        int actual = comparator.compare(FIRST_BOOK, SECOND_BOOK);
        //then
        Assert.assertTrue(actual < 0);
    }

    @Test
    public void testCompareShouldReturnPositiveWhenPublisherOneIsLessThanPublisherTwo() {
        //when
        int actual = comparator.compare(SECOND_BOOK, FIRST_BOOK);
        //then
        Assert.assertTrue(actual > 0);
    }

    @Test
    public void testCompareShouldReturnZeroWhenPublisherOneIsEqualsPublisherThree() {
        //when
        int actual = comparator.compare(THIRD_BOOK, FIRST_BOOK);
        //then
        Assert.assertTrue(actual == 0);
    }

}