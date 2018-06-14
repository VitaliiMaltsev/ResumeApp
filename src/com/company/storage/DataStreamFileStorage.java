package com.company.storage;

import com.company.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class DataStreamFileStorage extends FileStorage {

    private static final String NULL = "null" ;

    public DataStreamFileStorage(String path) {
        super(path);
    }

    protected void write(File file, Resume resume) {
        try (FileOutputStream fos = new FileOutputStream(file);
             DataOutputStream dos = new DataOutputStream(fos)) {
            writeString(dos, resume.getFullName());
            writeString(dos, resume.getLocation());
            writeString(dos, resume.getHomePage());
            Map<ContactType, String> contacts = resume.getContacts();
            writeCollection(dos, contacts.entrySet(), entry -> {
                dos.writeInt(entry.getKey().ordinal());
                writeString(dos,entry.getValue());
            });
            Map<SectionType,Section>sections = resume.getSections();
            dos.writeInt(sections.size());
            for (Map.Entry<SectionType, Section> entry : sections.entrySet()) {
                SectionType type = entry.getKey();
                Section section = entry.getValue();
                writeString(dos, type.name());
                switch (type) {
                    case OBJECTIVE:
                        writeString(dos, ((TextSection)section).getValue());
                        break;
                    case ARCHIEVEMENT:
                        writeCollection(dos, ((MultiTextSection) section).getValues(), value -> writeString(dos,value));
                        break;
                    case EDUCATION:
                        break;
                    case EXPIRIENCE:
                        break;
                    case QUALIFICATIONS:
                        writeCollection(dos, ((MultiTextSection) section).getValues(), value -> writeString(dos,value));
                        break;
//                        default:
//                            break;
                }
            }
//                writeString(dos, entry.getKey() + ":" + entry.getValue());
//            }
        } catch (IOException e) {
            throw new WebAppExeption("Couldn't write file" + file.getAbsolutePath(), resume, e);
        }
    }

    private <T> void writeCollection(DataOutputStream dos, Collection<T> collection, ElementWriter <T>writer)throws IOException {
        dos.writeInt(collection.size());
        for (T item : collection) {
            writer.write(item);
        }
    }

    private <T> List<T> readList(DataInputStream dis, ElementReader<T>reader)throws IOException {
        int size = dis.readInt();
        List<T>list = new ArrayList<>(size);
        for (int i = 0; i <size ; i++) {
            list.add(reader.read());
        }
        return list;
    }

    protected Resume read(File file) {
        Resume r = new Resume(file.getName());
        try (InputStream is = new FileInputStream(file); DataInputStream dis = new DataInputStream(is)) {
            r.setFullName(readString(dis));
            r.setLocation(readString(dis));
            r.setHomePage(readString(dis));
            int contactSize = dis.readInt();
            for (int i = 0; i < contactSize; i++) {
                r.addContact(ContactType.VALUES[dis.readInt()], readString(dis));
            }
            final int sectionSize = dis.readInt();
            for (int i = 0; i <sectionSize ; i++) {
                SectionType sectionType = SectionType.valueOf(readString(dis));
                switch (sectionType){
                    case OBJECTIVE:
                        r.addObjective(readString(dis));
                        break;
                    case ARCHIEVEMENT:
                        r.addSection(sectionType, new MultiTextSection(readList(dis, () -> readString(dis))));
                        break;
                    case QUALIFICATIONS:
                        r.addSection(sectionType, new MultiTextSection(readList(dis, () -> readString(dis))));
                        break;
                    case EDUCATION:
                    case EXPIRIENCE:
                        break;
                }

            }
        return r;
           // r.setUuid(file.getName());
        } catch (IOException e) {
            throw new WebAppExeption("Couldn't read file" + file.getAbsolutePath(), r, e);
        }
    }

    private void writeString(DataOutputStream dos, String str) throws IOException {
        dos.writeUTF(str==null?NULL:str);
    }

    private String readString(DataInputStream dis) throws IOException {
            String str = dis.readUTF();
            return str.equals (NULL)?null:str;
    }

    private interface ElementWriter<T>{
        void write(T t) throws IOException;
    }
    private interface ElementReader<T>{
        T read() throws IOException;
    }
}