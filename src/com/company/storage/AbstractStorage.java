package com.company.storage;

import com.company.model.Resume;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage implements ISStorage {
    protected final Logger logger = Logger.getLogger(getClass().getName());

    @Override
    public void clear() {
        logger.info("Delete all resumes ");
        doClear();
    }

    protected abstract void doClear();

    @Override
    public void save(Resume r) {
        logger.info("Save resume with uuid" + r.getUuid());
        if (exist(r.getUuid())) {
            throw new WebAppExeption("Resume" + r.getUuid() + "already exist", r);
        }
        doSave(r);

    }

    protected abstract boolean exist(String uuid);

    protected abstract void doSave(Resume r);

    @Override
    public void update(Resume r) {
        logger.info("Update resume with uuid" + r.getUuid());
        if (!exist(r.getUuid())) {
            throw new WebAppExeption("Resume" + r.getUuid() + "not exist", r);
        }
        doUpdate(r);
    }

    protected abstract void doUpdate(Resume r);

    @Override
    public Resume load(String uuid) {
        logger.info("Load resume with uuid" + uuid);
        if (!exist(uuid)) {
            throw new WebAppExeption("Resume" + uuid + "not exist");
        }
        return doLoad(uuid);
    }

    protected abstract Resume doLoad(String uuid);

    @Override
    public void delete(String uuid){
        logger.info("Delete resume with uuid" + uuid);
        if (!exist(uuid)) {
            throw new WebAppExeption("Resume" + uuid + "not exist");
        }
        doDelete(uuid);
    }

    protected abstract void doDelete(String uuid);

    @Override
    public Collection<Resume>getAllSorted(){
        logger.info("Get All Sorted! ");
        List<Resume> list =doGetAll();
        Collections.sort(list);
        return list;
       // return Collections.singletonList(new Resume());
    }

    protected abstract List<Resume> doGetAll();

    public abstract int size();


}
