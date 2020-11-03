package com.epam.storage.data.acquirer;

import com.epam.storage.exceptions.InputDataException;

import java.util.List;

public interface DataAcquirer {
    List<String> getData() throws InputDataException;
}
