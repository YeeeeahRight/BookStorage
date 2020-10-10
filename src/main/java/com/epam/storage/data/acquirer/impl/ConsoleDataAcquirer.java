package com.epam.storage.data.acquirer.impl;

import com.epam.storage.data.acquirer.DataAcquirer;
import com.epam.storage.exceptions.InputDataException;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleDataAcquirer implements DataAcquirer {
    private static final String STOP_WORD = "STOP";
    private static final String INPUT_ERROR_MESSAGE = "Something wrong with your console input.";
    private static final Logger LOGGER = Logger.getLogger(ConsoleDataAcquirer.class);

    @Override
    public List<String> getData() throws InputDataException {
        BufferedReader consoleReader = null;
        List<String> booksLines = new ArrayList<>();
        String bookLine;
        System.out.println("Print '" + STOP_WORD + "' to stop entering books.");
        try {
            consoleReader = new BufferedReader(new InputStreamReader(System.in));
            while (!((bookLine = consoleReader.readLine()).equalsIgnoreCase(STOP_WORD))) {
                booksLines.add(bookLine);
            }
        } catch (IOException e) {
            throw new InputDataException(INPUT_ERROR_MESSAGE, e);
        } finally {
            if (consoleReader != null) {
                try {
                    consoleReader.close();
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
        return booksLines;
    }
}
