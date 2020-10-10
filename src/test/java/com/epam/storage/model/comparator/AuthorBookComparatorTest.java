package com.epam.storage.model.comparator;

import com.epam.storage.model.Book;
import org.junit.Assert;
import org.junit.Test;

public class AuthorBookComparatorTest {

    private static final Book FIRST_BOOK = new Book(null, "a", null, 0, 0);
    private static final Book SECOND_BOOK = new Book(null, "b", null, 0, 0);
    private static final Book THIRD_BOOK = new Book(null, "a", null, 0, 0);
    private static final Book AUTHOR_NULL = new Book(null, null, null, 0, 0);

    private final AuthorBookComparator comparator = new AuthorBookComparator();

    @Test
    public void testCompareShouldReturnNegativeWhenAuthorNullCompareAuthorNotNull() {
        //when
        int actual = comparator.compare(AUTHOR_NULL, FIRST_BOOK);
        //then
        Assert.assertTrue(actual < 0);
    }

    @Test
    public void testCompareShouldReturnPositiveWhenAuthorNotNullCompareAuthorNull() {
        //when
        int actual = comparator.compare(FIRST_BOOK, AUTHOR_NULL);
        //then
        Assert.assertTrue(actual > 0);
    }

    @Test
    public void testCompareShouldReturnZeroWhenAuthorNullCompareAuthorNull() {
        //when
        int actual = comparator.compare(AUTHOR_NULL, AUTHOR_NULL);
        //then
        Assert.assertTrue(actual == 0);
    }

    @Test
    public void testCompareShouldReturnNegativeWhenAuthorOneIsLessThanAuthorTwo() {
        //when
        int actual = comparator.compare(FIRST_BOOK, SECOND_BOOK);
        //then
        Assert.assertTrue(actual < 0);
    }

    @Test
    public void testCompareShouldReturnPositiveWhenAuthorOneIsLessThanAuthorTwo() {
        //when
        int actual = comparator.compare(SECOND_BOOK, FIRST_BOOK);
        //then
        Assert.assertTrue(actual > 0);
    }

    @Test
    public void testCompareShouldReturnZeroWhenAuthorOneIsEqualsAuthorThree() {
        //when
        int actual = comparator.compare(THIRD_BOOK, FIRST_BOOK);
        //then
        Assert.assertTrue(actual == 0);
    }

}