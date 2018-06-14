package com.company.storage;

import com.company.model.ContactType;
import com.company.model.Resume;
import com.company.model.Section;
import com.company.model.SectionType;

import java.io.*;
import java.util.Map;

public class SerializedFileStorage extends FileStorage {

    public SerializedFileStorage(String path) {
        super(path);
    }

    @Override
    protected void write(OutputStream os, Resume r) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(r);
        }
    }

    @Override
    protected Resume read(InputStream is) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(is)) {
            return (Resume) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new WebAppExeption("Error read resume");
        }
    }


}