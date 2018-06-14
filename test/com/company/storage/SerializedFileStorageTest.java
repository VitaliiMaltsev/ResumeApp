package com.company.storage;

public class SerializedFileStorageTest extends AbstractStorageTest {
    {
        storage = new SerializedFileStorage("./file_storage");
    }
}
