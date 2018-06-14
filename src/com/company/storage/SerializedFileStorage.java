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

    protected void write(File file, Resume r) {
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(r);
        } catch (IOException e) {
            throw new WebAppExeption("Couldn't write file" + file.getAbsolutePath(), r, e);
        }
    }

    protected Resume read(File file) {
        Resume r = new Resume();
        try (InputStream is = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(is)) {
            return (Resume) ois.readObject();
        } catch (IOException e) {
            throw new WebAppExeption("Couldn't read file" + file.getAbsolutePath(), r, e);
        } catch (ClassNotFoundException e) {
            throw new WebAppExeption("Error read resume");
        }
    }

}