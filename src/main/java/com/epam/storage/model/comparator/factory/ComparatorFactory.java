package com.epam.storage.model.comparator.factory;

import com.epam.storage.data.dao.enums.BookFieldType;
import com.epam.storage.exceptions.UnknownFieldTypeException;
import com.epam.storage.model.Book;
import com.epam.storage.model.comparator.*;

import java.util.Comparator;

public class ComparatorFactory {
    private static final String UNKNOWN_FIELD_TYPE = "Unknown book field type.";

    public Comparator<Book> create(BookFieldType field) throws UnknownFieldTypeException {
        switch (field) {
            case TITLE:
                return new TitleBookComparator();
            case AUTHOR:
                return new AuthorBookComparator();
            case PUBLISHER:
                return new PublisherBookComparator();
            case YEAR_CREATION:
                return new YearCreationBookComparator();
            case PAGES:
                return new PagesBookComparator();
            default:
                throw new UnknownFieldTypeException(UNKNOWN_FIELD_TYPE);
        }
    }

}
