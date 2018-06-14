package com.company.storage;

import com.company.model.Contact;
import com.company.model.ContactType;
import com.company.model.Resume;
import com.company.model.SectionType;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

abstract public class AbstractStorageTest {
    protected ISStorage storage;
    private Resume R1, R2, R3;


    @BeforeClass
    public static void beforeClass() {
        // TODO то же самое, что и статический блок инициализации

    }

    @BeforeEach
    public void before() {
        storage.clear();
        R1 = new Resume("Полное имя1", "Локация1");
        R1.addContact(ContactType.SKYPE, "skype1");
        R1.addContact(ContactType.PHONE, "1111111");
        R2 = new Resume("Полное имя2", null);
        R2.addContact(ContactType.SKYPE, "skype2");
        R2.addContact(ContactType.PHONE, "2222222");
        R3 = new Resume("Полное имя3", null);
        R3.addContact(ContactType.SKYPE, "skype3");
        R3.addContact(ContactType.PHONE, "3333333");
        R1.addObjective("Objective1");
        R1.addMultitextSection(SectionType.ARCHIEVEMENT, "Archievment1", "Archievment2");
        R1.addMultitextSection(SectionType.QUALIFICATIONS, "Java", "SQL");
        R1.addMultitextSection(SectionType.EDUCATION,"KPI", "DonNTU");
        R1.addMultitextSection(SectionType.EXPIRIENCE, "Токарный завод", "Бинбанк");
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
        List<Resume> list = Arrays.asList(R1, R2, R3);
        Collections.sort(list, Comparator.comparing(Resume::getFullName));
        assertEquals(list, storage.getAllSorted());
    }

    @Test
    void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }
}