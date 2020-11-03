package com.epam.storage.data.acquirer.factory;

import com.epam.storage.data.acquirer.DataAcquirer;

public interface DataAcquirerFactory {
    DataAcquirer createAcquirer();
}
