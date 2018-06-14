package com.company.storage;

import static org.junit.jupiter.api.Assertions.*;

class JSonStorageTest extends AbstractStorageTest{
    {
        storage = new JSonStorage("./file_storage");
    }

}