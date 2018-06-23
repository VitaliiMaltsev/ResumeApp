package com.company.storage;

import com.company.model.Resume;
import com.company.sql.ConnectionFactory;
import com.company.sql.Sql;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.*;
import java.util.Collection;
import java.util.Properties;

public class SqlStorage implements IStorage {
    public Sql sql;
    String login;
    String host;
    String password;


    public SqlStorage() {

        Properties property = new Properties();
        try {
            property.load(new FileInputStream("sql.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.host = property.getProperty("db.url");
        this.login = property.getProperty("db.user");
        this.password = property.getProperty("db.password");
        this.sql = new Sql(() -> DriverManager.getConnection(host, login, password));

    }


    public SqlStorage(String host, String login, String password) {

        sql = new Sql(() -> DriverManager.getConnection(host, login, password));

    }

    @Override
    public void clear() {
        sql.execute("DELETE FROM resume");
    }

    @Override
    public void save(final Resume r) throws WebAppExeption {
        sql.execute("INSERT INTO resume (uuid, full_name, location, home_page) VALUES(?,?,?,?)", st -> {

            st.setString(1, r.getUuid());
            st.setString(2, r.getFullName());
            st.setString(3, r.getLocation());
            st.setString(4, r.getHomePage());
            st.execute();
            return null;
        });
    }


    @Override
    public void update(Resume r) {
        sql.execute("UPDATE resume SET full_name=?, location=?, home_page=? WHERE uuid=?",st ->{
            st.setString(1, r.getFullName());
            st.setString(2, r.getLocation());
            st.setString(3, r.getHomePage());
            st.setString(4, r.getUuid());
            if (st.executeUpdate() == 0) {
                throw new WebAppExeption("Resume not found", r);
            }
            return null;
            });
        }


    @Override
    public Resume load(final String uuid) {
        return sql.execute("" +
                        "SELECT *\n" +
                        "  FROM resume r\n" +
                        "  LEFT JOIN contact c ON c.resume_uuid=r.uuid\n" +
                        " WHERE r.uuid = ?",
                st -> {
                    st.setString(1, uuid);
                    ResultSet rs = st.executeQuery();
                    if (!rs.next()) {
                        throw new WebAppExeption("Resume " + uuid + " is not exist");
                    }
                    Resume r = new Resume(uuid, rs.getString("full_name"), rs.getString("location"), rs.getString("home_page"));
//                    addContact(rs, r);
//                    while (rs.next()) {
//                        addContact(rs, r);
//                    }
                    return r;
                });
    }

    @Override
    public void delete(String uuid) {
        sql.execute("DELETE FROM resume WHERE uuid=?", ps -> {
            ps.setString(1, uuid);
            if (ps.executeUpdate() == 0) {
                throw new WebAppExeption("Resume " + uuid + "not exist", uuid);
            }
            return null;
        });
    }

    @Override
    public Collection<Resume> getAllSorted() {
        return null;
    }

    @Override
    public int size() {
        return sql.execute("SELECT count(*) FROM resume", st -> {
            ResultSet rs = st.executeQuery();
            rs.next();
            return rs.getInt(1);
        });
    }

    @Override
    public boolean IsSectionSupported() {
        return false;
    }
}
