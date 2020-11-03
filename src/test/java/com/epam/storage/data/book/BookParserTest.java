package com.epam.storage.data.book;

import com.epam.storage.model.Book;
import org.junit.Assert;
import org.junit.Test;

public class BookParserTest {
    private static final String LINE = "title author publisher 2020 100";
    private static final String INVALID_LINE = "first second last";
    private static final Book BOOK = new Book("title", "author", "publisher", 2020, 100);

    private final BookParser bookParser = new BookParser();

    @Test
    public void testParseShouldParseWhenLineIsCorrect() {
        //when
        Book actual = bookParser.parse(LINE);
        //then
        Assert.assertEquals(BOOK, actual);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)//then
    public void testParseShouldThrowExceptionWhenLineIsIncorrect() {
        //when
        bookParser.parse(INVALID_LINE);
    }

}