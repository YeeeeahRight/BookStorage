package com.epam.storage.application;

import com.epam.storage.data.dao.enums.BookFieldType;
import com.epam.storage.data.dao.impl.BookDao;
import com.epam.storage.data.acquirer.DataAcquirer;
import com.epam.storage.data.book.BookCreator;
import com.epam.storage.data.book.BookParser;
import com.epam.storage.data.acquirer.factory.DataAcquirerFactory;
import com.epam.storage.data.acquirer.factory.impl.FileDataAcquirerFactory;
import com.epam.storage.exceptions.DaoException;
import com.epam.storage.exceptions.InputDataException;
import com.epam.storage.exceptions.UnknownFieldTypeException;
import com.epam.storage.model.Book;
import org.apache.log4j.Logger;

import java.util.List;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            processApplication();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    private static void processApplication() throws InputDataException, DaoException, UnknownFieldTypeException {
        LOGGER.info("Start Main");

        LOGGER.info("Read data from file");
        DataAcquirerFactory dataAcquirerCreator = new FileDataAcquirerFactory();
        DataAcquirer dataAcquirer = dataAcquirerCreator.createAcquirer();
        List<String> data = dataAcquirer.getData();

        LOGGER.info("Create list of books");
        BookParser bookParser = new BookParser();
        BookCreator bookCreator = new BookCreator(bookParser);
        List<Book> booksList = bookCreator.createBooks(data);

        LOGGER.info("Create BookDAO and add books");
        BookDao bookDao = new BookDao();
        bookDao.add(booksList);

        LOGGER.info("Sort BookDAO by year creation");
        bookDao.sortByTag(BookFieldType.YEAR_CREATION);

        LOGGER.info("Find books by year creation");
        List<Book> searchedBooks = bookDao.findByTag(BookFieldType.YEAR_CREATION, 2005);

        LOGGER.info("Finish Main");
    }
}
