package com.epam.storage.data.acquirer.factory.impl;

import com.epam.storage.data.acquirer.DataAcquirer;
import com.epam.storage.data.acquirer.impl.ConsoleDataAcquirer;
import com.epam.storage.data.acquirer.factory.DataAcquirerFactory;

public class ConsoleDataAcquirerFactory implements DataAcquirerFactory {
    @Override
    public DataAcquirer createAcquirer() {
        return new ConsoleDataAcquirer();
    }
}
