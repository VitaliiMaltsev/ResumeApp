package com.company.storage;

import com.company.model.Resume;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrencyMapStorage extends AbstractStorage<String> {
    private Map<String,Resume> map = new ConcurrentHashMap<>();

    @Override
    protected void doClear() {
        map.clear();
    }

    @Override
    protected String getContext(String uuid) {
        return uuid;
    }

    @Override
    protected boolean exist(String uuid) {
        return map.containsKey(uuid);
    }

    @Override
    protected void doSave(String uuid, Resume r) {
        map.put(uuid,r);
    }

    @Override
    protected void doUpdate(String uuid, Resume r) {
        map.put(uuid,r);
    }

    @Override
    protected Resume doLoad(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected void doDelete(String uuid) {
        map.remove(uuid);
    }

    @Override
    protected List<Resume> doGetAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean IsSectionSupported() {
        return true;
    }
}