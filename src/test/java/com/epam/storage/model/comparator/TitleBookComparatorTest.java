package com.epam.storage.model.comparator;

import com.epam.storage.model.Book;
import org.junit.Assert;
import org.junit.Test;

public class TitleBookComparatorTest {

    private static final Book FIRST_BOOK = new Book("a", null, null, 0, 0);
    private static final Book SECOND_BOOK = new Book("b", null, null, 0, 0);
    private static final Book THIRD_BOOK = new Book("a", null, null, 0, 0);
    private static final Book TITLE_NULL = new Book(null, null, null, 0, 0);

    private final TitleBookComparator comparator = new TitleBookComparator();

    @Test
    public void testCompareShouldReturnNegativeWhenTitleNullCompareTitleNotNull() {
        //when
        int actual = comparator.compare(TITLE_NULL, FIRST_BOOK);
        //then
        Assert.assertTrue(actual < 0);
    }

    @Test
    public void testCompareShouldReturnPositiveWhenTitleNotNullCompareTitleNull() {
        //when
        int actual = comparator.compare(FIRST_BOOK, TITLE_NULL);
        //then
        Assert.assertTrue(actual > 0);
    }

    @Test
    public void testCompareShouldReturnZeroWhenTitleNullCompareTitleNull() {
        //when
        int actual = comparator.compare(TITLE_NULL, TITLE_NULL);
        //then
        Assert.assertTrue(actual == 0);
    }

    @Test
    public void testCompareShouldReturnNegativeWhenTitleOneIsLessThanTitleTwo() {
        //when
        int actual = comparator.compare(FIRST_BOOK, SECOND_BOOK);
        //then
        Assert.assertTrue(actual < 0);
    }

    @Test
    public void testCompareShouldReturnPositiveWhenTitleOneIsLessThanTitleTwo() {
        //when
        int actual = comparator.compare(SECOND_BOOK, FIRST_BOOK);
        //then
        Assert.assertTrue(actual > 0);
    }

    @Test
    public void testCompareShouldReturnZeroWhenTitleOneIsEqualsTitleThree() {
        //when
        int actual = comparator.compare(THIRD_BOOK, FIRST_BOOK);
        //then
        Assert.assertTrue(actual == 0);
    }

}