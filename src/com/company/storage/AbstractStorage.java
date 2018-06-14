package com.company.storage;

import com.company.model.Resume;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<C> implements ISStorage {
    protected final Logger logger = Logger.getLogger(getClass().getName());

    @Override
    public void clear() {
        logger.info("Delete all resumes ");
        doClear();
    }

    protected abstract void doClear();
    protected abstract C getContext(String uuid);
    protected abstract boolean exist(C ctx);


    @Override
    public void save(Resume r) {
        logger.info("Save resume with uuid " + r.getUuid());
        C ctx = getContext(r);
        if (exist(ctx)) {
            throw new WebAppExeption("Resume" + r.getUuid() + "already exist", r);
        }
        doSave(ctx, r);

    }


    protected abstract void doSave(C ctx, Resume r);

    @Override
    public void update(Resume r) {
        logger.info("Update resume with uuid " + r.getUuid());
        C ctx = getContext(r);
        if (!exist(ctx)) {
            throw new WebAppExeption("Resume" + r.getUuid() + "not exist", r);
        }
        doUpdate(ctx, r);
    }

    protected abstract void doUpdate(C ctx, Resume r);

    @Override
    public Resume load(String uuid) {
        logger.info("Load resume with uuid " + uuid);
        C ctx = getContext(uuid);
        if (!exist(ctx)) {
            throw new WebAppExeption("Resume" + uuid + "not exist");
        }
        return doLoad(ctx);
    }

    protected abstract Resume doLoad(C ctx);

    @Override
    public void delete(String uuid){
        logger.info("Delete resume with uuid " + uuid);
        C ctx = getContext(uuid);
        if (!exist(ctx)) {
            throw new WebAppExeption("Resume" + uuid + "not exist");
        }
        doDelete(ctx);
    }

    protected abstract void doDelete(C ctx);

    @Override
    public Collection<Resume>getAllSorted(){
        logger.info("Get All Sorted! ");
        List<Resume> list =doGetAll();
        Collections.sort(list,(o1,o2)-> {
            int cmp =o1.getFullName().compareTo(o2.getFullName());
            if(cmp!=0)return cmp;
            return o1.getUuid().compareTo(o2.getUuid());
        });
        return list;
       // return Collections.singletonList(new Resume());
    }

    protected abstract List<Resume> doGetAll();

    public abstract int size();
    private C getContext(Resume r){
        return getContext(r.getUuid());
    }


}
