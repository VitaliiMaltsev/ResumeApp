package com.company.storage;

import com.company.model.Resume;

import java.util.Collection;

public interface ISStorage {

    void clear();

    void save(Resume r);

    void update(Resume r);

    Resume load(String uuid);

    void delete(String uuid);

    Collection<Resume> getAllSorted();

    int size();
}
