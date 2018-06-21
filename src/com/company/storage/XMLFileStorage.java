package com.company.storage;

import com.company.model.*;
import com.company.util.XMLParser;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class XMLFileStorage extends FileStorage {
    private XMLParser xmlParser;

    public XMLFileStorage(String path) {
        super(path);
        xmlParser = new XMLParser(Resume.class, Organization.class, Link.class,
                OrganisationSection.class, TextSection.class, MultiTextSection.class, Organization.Period.class);
    }

    @Override
    protected void write(OutputStream os, Resume r) throws IOException {
        try (Writer w = new OutputStreamWriter(os, StandardCharsets.UTF_8)) {
            xmlParser.marshall(r, w);
        }
    }

    @Override
    protected Resume read(InputStream is) throws IOException {
        try (Reader r = new InputStreamReader(is, StandardCharsets.UTF_8)) {
            return xmlParser.unmarshall(r);
        }
    }

    @Override
    public boolean IsSectionSupported() {
        return true;
    }
}
