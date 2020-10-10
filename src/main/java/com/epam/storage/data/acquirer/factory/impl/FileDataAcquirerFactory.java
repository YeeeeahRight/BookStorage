package com.epam.storage.data.acquirer.factory.impl;

import com.epam.storage.data.acquirer.DataAcquirer;
import com.epam.storage.data.acquirer.impl.FileDataAcquirer;
import com.epam.storage.data.acquirer.factory.DataAcquirerFactory;

public class FileDataAcquirerFactory implements DataAcquirerFactory {
    private static final String FILE_PATH = "books.txt";

    @Override
    public DataAcquirer createAcquirer() {
        return new FileDataAcquirer(FILE_PATH);
    }
}
