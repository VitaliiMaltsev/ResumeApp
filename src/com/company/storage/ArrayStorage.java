package com.company.storage;

import com.company.model.Resume;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArrayStorage implements ISStorage {
    private static final int LIMIT = 100;
    private static Logger LOGGER = Logger.getLogger(ArrayStorage.class.getName());
    private Resume[] array = new Resume[LIMIT];
    private int size = 0;

    @Override
    public void clear() {
        LOGGER.info("Delete all resumes");
        Arrays.fill(array, null);
        size = 0;
    }

    @Override
    public void safe(Resume r) {
        LOGGER.info("Save resume with uuid" + r.getUuid());
        int idx = getIndex(r.getUuid());
        if (idx != -1) {
            //TODO кусок кода , еслт наследуемся от Exeption
         /*   try {
                throw new WebAppExeption("Resume" +r.getUuid() +"already exist", r);
            } catch (WebAppExeption webAppExeption) {
                LOGGER.log(Level.SEVERE, webAppExeption.getMessage(), webAppExeption);
                throw new IllegalStateException(webAppExeption);
            }
        }*/
            throw new WebAppExeption("Resume" + r.getUuid() + "already exist", r);
            array[size++] = r;

        }
    }

    @Override
    public void update(Resume r) {
        LOGGER.info("Update resume with uuid" + r.getUuid());
        int idx = getIndex(r.getUuid());
        if (idx == -1) throw new WebAppExeption("Resume" + r.getUuid() + "not exist", r);
        array[idx] = r;
    }

    @Override
    public Resume load(String uuid) {
        LOGGER.info("Load resume with uuid" + uuid);
        int idx = getIndex(uuid);
        if (idx == -1) throw new WebAppExeption("Resume" + uuid + "not exist");
        return array[idx];
    }

    @Override
    public void delete(String uuid) {
        LOGGER.info("Delete resume with uuid " + uuid);
        int idx = getIndex(uuid);
        if (idx == -1) throw new WebAppExeption("Resume" + uuid + "not exist");
        int numMoved = size - idx - 1;
        if (numMoved > 0)
            System.arraycopy(array, idx + 1, array, idx, numMoved);
        array[--size] = null;
    }

    @Override
    public Collection<Resume> getAllSorted() {
        Arrays.sort(array, 0, size);
        return Arrays.asList(Arrays.copyOf(array, size));
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < LIMIT; i++) {
            if (array[i] != null) {
                if (array[i].getUuid().equals(uuid)) {
                    return i;
                }
            }

        }
        return -1;
    }
}

