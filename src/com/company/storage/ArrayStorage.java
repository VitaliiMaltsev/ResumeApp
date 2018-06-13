package com.company.storage;

import com.company.model.Resume;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ArrayStorage extends AbstractStorage<Integer> {
    private static final int LIMIT = 100;
    private Resume[] array = new Resume[LIMIT];
    private int size = 0;
//    private int idx;

    @Override
    protected boolean exist(Integer idx) {
        return idx!=-1;
    }

    @Override
    protected void doClear() {
        Arrays.fill(array, null);
        size = 0;
    }

    @Override
    protected void doSave(Integer ctx, Resume r) {
          array[size++] = r;
    }

    @Override
    protected void doUpdate(Integer idx, Resume r) {
        array[idx] = r;
    }

    @Override
    protected Resume doLoad(Integer idx) {
        return array[idx];
    }

    @Override
    protected void doDelete(Integer idx) {
        int numMoved = size - idx - 1;
        if (numMoved > 0)
            System.arraycopy(array, idx + 1, array, idx, numMoved);
        array[--size] = null;
    }

    @Override
    protected List<Resume> doGetAll() {
        return Arrays.asList(Arrays.copyOf(array, size));
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    protected Integer getContext(String uuid) {
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

