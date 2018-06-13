package com.company.storage;

import com.company.model.ContactType;
import com.company.model.Resume;
import com.company.model.Section;
import com.company.model.SectionType;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FileStorage extends AbstractStorage<File> {
    private File dir;

    public FileStorage(String path) {
        this.dir = new File(path);
        if (!dir.isDirectory() || !dir.canWrite()) {
            throw new IllegalArgumentException(" " + path + "is not directory or is not writable");
        }
    }

    @Override
    protected void doClear() {
        File[] files = dir.listFiles();
        if (files == null) return;
        for (File file : files) {
            doDelete(file);
        }
    }

    @Override
    protected File getContext(String fileName) {
        return new File(fileName);
    }

    @Override
    protected boolean exist(File file) {
        return file.exists();
    }


    @Override
    protected void doSave(File file, Resume r) {
        try {
            file.createNewFile();
            write(file, r);
        } catch (IOException e) {
            throw new WebAppExeption("Couldn't create new file" + file.getAbsolutePath(), r, e);
        }

    }

    protected void write(File file, Resume r) {
        try (FileOutputStream fos = new FileOutputStream(file);
             DataOutputStream dos = new DataOutputStream(fos)) {
            dos.writeUTF(r.getFullName());
            dos.writeUTF(r.getLocation());
            dos.writeUTF(r.getHomePage());
            for (Map.Entry<ContactType, String> entry : r.getContacts().entrySet()) {
                dos.writeUTF(entry.getKey() + " " + entry.getValue());
            }
            for (Map.Entry<SectionType, Section> entry : r.getSections().entrySet()) {
                dos.writeUTF(entry.getKey() + ":" + entry.getValue());
            }
        } catch (IOException e) {
            throw new WebAppExeption("Couldn't write file" + file.getAbsolutePath(), r, e);
        }
    }

    protected Resume read(File file){
        Resume r = new Resume();
        try(InputStream is = new FileInputStream(file); DataInputStream dis = new DataInputStream(is)){
            r.setFullName(dis.readUTF());
            r.setLocation(dis.readUTF());
            r.setHomePage(dis.readUTF());
            int contactSize = dis.readInt();
            for (int i = 0; i < contactSize; i++) {
                r.addContact(ContactType.VALUES[dis.readInt()],dis.readUTF());
            }
        } catch (IOException e) {
            throw new WebAppExeption("Couldn't read file" + file.getAbsolutePath(), r, e);
        }
        return null;
    }

    @Override
    protected void doUpdate(File file, Resume r) {
        write(file, r);

    }

    @Override
    protected Resume doLoad(File file) {
        return read(file);
    }

    @Override
    protected void doDelete(File file) {
        if (!file.delete()) throw new WebAppExeption("File" + file.getAbsolutePath() + "can not be deleted");
    }

    @Override
    protected List<Resume> doGetAll() {
        return null;
    }

    @Override
    public int size() {
        return Objects.requireNonNull(dir.list()).length;
    }
}
