package com.company.storage;

import com.company.model.Contact;
import com.company.model.ContactType;
import com.company.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStorageTest {
    private static Resume R1, R2, R3;

    private ArrayStorage storage = new ArrayStorage();

    static {
        R1 = new Resume("Полное имя1", "Локация1");
        R1.addContact(new Contact(ContactType.SKYPE, "skype1"));
        R1.addContact(new Contact(ContactType.PHONE, "1111111"));
        R2 = new Resume("Полное имя2", "Локация2");
        R2.addContact(new Contact(ContactType.SKYPE, "skype2"));
        R2.addContact(new Contact(ContactType.PHONE, "2222222"));
        R3 = new Resume("Полное имя3", "Локация3");
        R3.addContact(new Contact(ContactType.SKYPE, "skype3"));
        R3.addContact(new Contact(ContactType.PHONE, "3333333"));
    }

    @BeforeClass
    public static void beforeClass() {
        // TODO то же самое, что и статический блок инициализации
    }

    @Before
    public void before(){
        storage.clear();
        storage.safe(R1);
        storage.safe(R2);
        storage.safe(R3);
    }


    @Test
    void clear() {
    }

    @Test
    void safe() {
    }

    @Test
    void update() {
    }

    @Test
    void load() {
    }

    @Test
    void delete() {
        storage.delete(R1.getUuid());
        Assert.assertEquals(2,storage.size());
        Assert.assertEquals(null,storage.load(R1.getUuid()));
    }

    @Test
    void getAllSorted() {

    }

    @Test
    void size() {
        Assert.assertEquals(3,storage.size());
    }
}