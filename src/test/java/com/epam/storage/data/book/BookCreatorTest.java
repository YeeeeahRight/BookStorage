package com.epam.storage.data.book;

import com.epam.storage.model.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BookCreatorTest {
    private static final String FIRST_LINE = "firstTitle firstAuthor firstPublisher 2000 100";
    private static final String SECOND_LINE = "secondTitle secondAuthor secondPublisher 2010 110";
    private static final List<String> LINES = Arrays.asList(FIRST_LINE, SECOND_LINE);

    private static final Book FIRST_BOOK = new Book("firstTitle", "firstAuthor",
            "firstPublisher", 2000, 100);
    private static final Book SECOND_BOOK = new Book("secondTitle", "secondAuthor",
            "secondPublisher", 2010, 110);
    private static final List<Book> BOOKS = Arrays.asList(FIRST_BOOK, SECOND_BOOK);

    private static final String INVALID_LINE = "first second third";
    private static final List<String> INVALID_LINES = Arrays.asList(INVALID_LINE);

    private final BookParser bookParser = new BookParser();
    private final BookCreator bookCreator = new BookCreator(bookParser);

    @Test
    public void testCreateBooksShouldCreateWhenLinesAreCorrect() {
        //when
        List<Book> actual = bookCreator.createBooks(LINES);
        //then
        Assert.assertEquals(BOOKS, actual);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)//then
    public void testCreateBooksShouldThrowExceptionWhenLineIsIncorrect() {
        //when
        bookCreator.createBooks(INVALID_LINES);
    }


}