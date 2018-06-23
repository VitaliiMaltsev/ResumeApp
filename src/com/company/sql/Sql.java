package com.company.sql;

import com.company.storage.WebAppExeption;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Sql {
    private final ConnectionFactory connectionFactory;

    public Sql(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public void execute(String sql) {
        execute(sql, ps -> {
            ps.execute();
            return null;
        });
    }

    public <T> T execute(String sql, SqlExecutor<T> executor ) {
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            return executor.execute(ps);
        } catch (SQLException e) {
            throw new WebAppExeption("SQL failed", e);
        }
    }
}
