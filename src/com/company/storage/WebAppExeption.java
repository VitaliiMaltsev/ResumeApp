package com.company.storage;

import com.company.model.Resume;

public class WebAppExeption extends RuntimeException {
    private Resume resume = null;
    private String uuid = null;

    public WebAppExeption(String message) {
        super(message);
    }

    public WebAppExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public WebAppExeption(String message, Resume resume) {
        super(message);
        this.resume = resume;
    }

    public WebAppExeption(String message, String uuid) {
        super(message);
        this.uuid = uuid;
    }

    public WebAppExeption(String message, Resume resume, String uuid) {
        super(message);
        this.resume = resume;
        this.uuid = uuid;
    }

    public Resume getResume() {
        return resume;
    }

    public String getUuid() {
        return uuid;
    }
}
