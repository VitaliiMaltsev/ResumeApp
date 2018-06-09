package com.company.storage;

import com.company.model.Contact;
import com.company.model.ContactType;
import com.company.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStorageTest {
    private ArrayStorage storage = new ArrayStorage();
    private Resume R1, R2, R3;

//    static {
//        R1 = new Resume("Полное имя1", "Локация1");
//        R1.addContact(new Contact(ContactType.SKYPE, "skype1"));
//        R1.addContact(new Contact(ContactType.PHONE, "1111111"));
//        R2 = new Resume("Полное имя2", "Локация2");
//        R2.addContact(new Contact(ContactType.SKYPE, "skype2"));
//        R2.addContact(new Contact(ContactType.PHONE, "2222222"));
//        R3 = new Resume("Полное имя3", "Локация3");
//        R3.addContact(new Contact(ContactType.SKYPE, "skype3"));
//        R3.addContact(new Contact(ContactType.PHONE, "3333333"));
//    }

    @BeforeClass
    public static void beforeClass() {
        // TODO то же самое, что и статический блок инициализации

    }

    @BeforeEach
    public void before() {
        R1 = new Resume("Полное имя1", "Локация1");
        R1.addContact(new Contact(ContactType.SKYPE, "skype1"));
        R1.addContact(new Contact(ContactType.PHONE, "1111111"));
        R2 = new Resume("Полное имя2", null);
        R2.addContact(new Contact(ContactType.SKYPE, "skype2"));
        R2.addContact(new Contact(ContactType.PHONE, "2222222"));
        R3 = new Resume("Полное имя3", null);
        R3.addContact(new Contact(ContactType.SKYPE, "skype3"));
        R3.addContact(new Contact(ContactType.PHONE, "3333333"));
        storage.clear();
        storage.save(R3);
        storage.save(R1);
        storage.save(R2);
    }


    @Test
    void clear() throws Exception {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    void save() {
    }

    @Test
    void update() throws Exception {
        R2.setFullName("New Name");
        storage.update(R2);
        assertEquals(R2, storage.load(R2.getUuid()));
    }

    @Test
    void load() throws Exception {
        assertEquals(R1, storage.load(R1.getUuid()));
        assertEquals(R2, storage.load(R2.getUuid()));
        assertEquals(R3, storage.load(R3.getUuid()));
    }

    @Test
    public void delete() throws Exception {
        storage.delete(R1.getUuid());
        Assert.assertEquals(2, storage.size());
        Assertions.assertThrows(WebAppExeption.class, () -> {
            storage.load(R1.getUuid());
        });
    }


    @Test
    void getAllSorted() throws Exception {
        Resume[] src = new Resume[]{R1, R2, R3};
        Arrays.sort(src);
        assertArrayEquals(src, storage.getAllSorted().toArray());
    }

    @Test
    void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }
}