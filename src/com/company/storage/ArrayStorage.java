package com.company.storage;

import com.company.model.Resume;

import java.util.Collection;

public class ArrayStorage implements ISStorage {
    private static final int SIZE = 100;
    private Resume[] array = new Resume[SIZE];

    @Override
    public void clear() {
    }

    @Override
    public void safe(Resume r) {
    }

    @Override
    public void update(Resume r) {
    }

    @Override
    public Resume load(String uuid) {
        return null;
    }

    @Override
    public void delete(String uuid) {
    }

    @Override
    public Collection<Resume> getAllSorted() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
