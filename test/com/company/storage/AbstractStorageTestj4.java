package com.company.storage;

import com.company.model.ContactType;
import com.company.model.Resume;
import com.company.model.SectionType;
import org.junit.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class AbstractStorageTestj4 {

    protected IStorage storage;
    private Resume R1, R2, R3;


    @Before
    public void setUp() throws Exception {
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
        R1.addMultiTextSection(SectionType.ARCHIEVEMENT, "Archievment1", "Archievment2");
        R1.addMultiTextSection(SectionType.QUALIFICATIONS, "Java", "SQL");
//        R1.addMultitextSection(SectionType.EDUCATION,"KPI", "DonNTU");
//        R1.addMultitextSection(SectionType.EXPIRIENCE, "Токарный завод", "Бинбанк");
        storage.save(R3);
        storage.save(R1);
        storage.save(R2);
    }

    @After
    public void tearDown() throws Exception {
        storage.clear();

    }

    @Test
    public void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void doClear() {

    }

    @Test
    public void getContext() {
    }

    @Test
    public void exist() {
    }

    @Test
    public void save() {
    }

    @Test
    public void doSave() {
    }

    @Test
    public void update() {
        R2.setFullName("New Name");
        storage.update(R2);
        assertEquals(R2, storage.load(R2.getUuid()));
    }

    @Test
    public void doUpdate() {
    }

    @Test
    public void load() {
        assertEquals(R1, storage.load(R1.getUuid()));
        assertEquals(R2, storage.load(R2.getUuid()));
        assertEquals(R3, storage.load(R3.getUuid()));
    }

    @Test
    public void doLoad() {
    }

    @Test
    public void delete() {
        storage.delete(R1.getUuid());
        Assert.assertEquals(2, storage.size());
    }

    @Test
    public void doDelete() {
    }

    @Test
    public void getAllSorted() {
        List<Resume> list = Arrays.asList(R1, R2, R3);
        Collections.sort(list, Comparator.comparing(Resume::getFullName));
        assertEquals(list, storage.getAllSorted());
    }

    @Test
    public void doGetAll() {
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }
}