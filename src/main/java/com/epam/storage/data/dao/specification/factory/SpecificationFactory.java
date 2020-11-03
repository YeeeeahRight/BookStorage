package com.epam.storage.data.dao.specification.factory;

import com.epam.storage.data.dao.enums.BookFieldType;
import com.epam.storage.data.dao.specification.AbstractSpecification;
import com.epam.storage.data.dao.specification.impl.*;
import com.epam.storage.exceptions.UnknownFieldTypeException;

public class SpecificationFactory {
    private static final String UNKNOWN_FIELD_TYPE = "Unknown book field type.";

    public AbstractSpecification create(BookFieldType field) throws UnknownFieldTypeException {
        switch (field) {
            case TITLE:
                return new TitleSpecification();
            case AUTHOR:
                return new AuthorSpecification();
            case PUBLISHER:
                return new PublisherSpecification();
            case YEAR_CREATION:
                return new YearCreationSpecification();
            case PAGES:
                return new PagesSpecification();
            default:
                throw new UnknownFieldTypeException(UNKNOWN_FIELD_TYPE);
        }
    }
}
