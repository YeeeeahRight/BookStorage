package com.epam.storage.data.dao;

import com.epam.storage.data.dao.impl.BookDao;
import com.epam.storage.exceptions.DaoException;
import com.epam.storage.model.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BookDaoTest {
    public static final Book FIRST_BOOK = new Book("title1", "author1", "publisher1", 2001, 100);
    public static final Book SECOND_BOOK = new Book("title2", "author2", "publisher2", 2001, 100);
    public static final Book BOOK_REMOVED = new Book("title", "author", "publisher", 2001, 100);

    private static final List<Book> BOOKS = Arrays.asList(FIRST_BOOK, SECOND_BOOK);

    @Test
    public void testAddShouldAddBook() throws DaoException {
        //given
        BookDao bookDao = new BookDao();
        int initialSize = bookDao.size();
        //when
        bookDao.add(FIRST_BOOK);
        int resultSize = bookDao.size();
        //then
        Assert.assertEquals(initialSize + 1, resultSize);
    }

    @Test
    public void testAddShouldAddListBook() throws DaoException {
        //given
        BookDao bookDao = new BookDao();
        int initialSize = bookDao.size();
        //when
        bookDao.add(BOOKS);
        int resultSize = bookDao.size();
        //then
        Assert.assertEquals(initialSize + BOOKS.size(), resultSize);
    }

    @Test(expected = DaoException.class)//then
    public void testAddShouldThrowExceptionWhenBookDaoContainsAppendedBook() throws DaoException {
        //given
        BookDao bookDao = new BookDao();
        bookDao.add(FIRST_BOOK);
        //when
        bookDao.add(FIRST_BOOK);
    }

    @Test(expected = DaoException.class)//then
    public void testAddShouldThrowExceptionWhenBookDaoContainsAppendedBookFromList() throws DaoException {
        //given
        BookDao bookDao = new BookDao();
        bookDao.add(FIRST_BOOK);
        //when
        bookDao.add(BOOKS);
    }

    @Test
    public void testRemoveShouldRemoveBook() throws DaoException {
        //given
        BookDao bookDao = new BookDao();
        bookDao.add(BOOKS);
        int initialSize = bookDao.size();
        //when
        bookDao.remove(FIRST_BOOK);
        //then
        int resultSize = bookDao.size();
        Assert.assertEquals(initialSize, resultSize + 1);
    }

    @Test(expected = DaoException.class)//then
    public void testRemoveShouldThrowExceptionWhenBookDaoNotContainsRemovedBook() throws DaoException {
        //given
        BookDao bookDao = new BookDao();
        bookDao.add(BOOKS);
        //when
        bookDao.remove(BOOK_REMOVED);
    }
}