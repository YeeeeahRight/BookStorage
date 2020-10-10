package com.epam.storage.data.acquirer.impl;

import com.epam.storage.data.acquirer.DataAcquirer;
import com.epam.storage.exceptions.InputDataException;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataAcquirer implements DataAcquirer {
    private static final String INPUT_ERROR_MESSAGE = "Something wrong with file input.";
    private static final Logger LOGGER = Logger.getLogger(FileDataAcquirer.class);
    private final String fileName;

    public FileDataAcquirer(String fileName) {
        this.fileName = fileName;
    }

    public List<String> getData() throws InputDataException {
        BufferedReader fileReader = null;
        List<String> booksLines = new ArrayList<>();
        try {
            fileReader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = fileReader.readLine()) != null) {
                booksLines.add(line);
            }
        } catch (IOException e) {
            throw new InputDataException(INPUT_ERROR_MESSAGE, e);
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
        return booksLines;
    }
}
