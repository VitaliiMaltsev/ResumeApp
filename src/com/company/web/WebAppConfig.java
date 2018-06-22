package com.company.web;

import com.company.storage.IStorage;
import com.company.storage.SerializedFileStorage;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.LogManager;


public class WebAppConfig {
    public static final WebAppConfig INSTANCE = new WebAppConfig();

    public IStorage storage;

    public static WebAppConfig get() {
        return INSTANCE;
    }

    public IStorage getStorage() {
        return storage;
    }

    public WebAppConfig() {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("logging.properties");
             InputStream webAppIs = getClass().getClassLoader().getResourceAsStream("webapp.properties")
        ) {
            LogManager.getLogManager().readConfiguration(is);

            Properties appProps = new Properties();
            appProps.load(webAppIs);
            storage = new SerializedFileStorage(appProps.getProperty("storage"));
//            storage = new SqlStorage(
//                    appProps.getProperty("db.url"),
//                    appProps.getProperty("db.user"),
//                    appProps.getProperty("db.password")
//            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}