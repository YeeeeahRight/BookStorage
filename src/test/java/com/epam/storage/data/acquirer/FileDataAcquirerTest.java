package com.epam.storage.data.acquirer;

import com.epam.storage.data.acquirer.impl.FileDataAcquirer;
import com.epam.storage.exceptions.InputDataException;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileDataAcquirerTest {
    private static final String DATA_FILE_EXIST = "src/test/resources/data.txt";
    private static final String DATA_FILE_NOT_EXIST = "src/test/resources/qwerty12345.txt";

    @Test
    public void testGetDataShouldGetFileWhenFileIsExist() throws InputDataException, IOException {
        //given
        FileDataAcquirer dataAcquirer = new FileDataAcquirer(DATA_FILE_EXIST);
        List<String> expectedLines = readFileLines();
        //when
        List<String> actual = dataAcquirer.getData();
        //then
        Assert.assertEquals(expectedLines, actual);
    }

    private List<String> readFileLines() throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader fileReader;
        fileReader = new BufferedReader(new FileReader(DATA_FILE_EXIST));
        String line;
        while ((line = fileReader.readLine()) != null) {
            lines.add(line);
        }
        return lines;
    }

    @Test(expected = InputDataException.class)//then
    public void testGetDataShouldThrowExceptionWhenFileIsNotFound() throws InputDataException {
        //when
        (new FileDataAcquirer(DATA_FILE_NOT_EXIST)).getData();
    }

}