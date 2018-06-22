package com.company.storage;

import com.company.model.Resume;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;

public class CoccurrencyTest {

    static {
        try {
            FileInputStream logprops = new FileInputStream(new File("logging.properties"));
            LogManager.getLogManager().readConfiguration(logprops);
        } catch (IOException e) {
            throw new WebAppExeption(" Couldn't find log file", e);
        }
    }

    @Test
    public void testArrayStorage() {
        run(new ArrayStorage());

    }

    @Test
    public void testMapStorage() {
        run(new ConcurrencyMapStorage());

    }

    @Test
    public void testSerializedFileStorage(){
        run(new SerializedFileStorage(AbstractStorageTest.FILE_STORAGE ));

    }
//    @Test
//    public void testArrayStorage(){
//        run(new ArrayStorage());
//
//    }
//    @Test
//    public void testArrayStorage(){
//        run(new ArrayStorage());
//
//    }


    private void run(IStorage storage) {
        for (int i = 0; i < 5000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Resume r = new Resume("Resume name", "LOCATION");
                    storage.save(r);
                    storage.load(r.getUuid());
                    storage.delete(r.getUuid());
                    storage.getAllSorted();

                }
            }).start();


        }
    }
}
