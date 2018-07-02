package com.sjb.chapter10.db.jdbc;


import com.sjb.chapter10.domain.Spitter;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by simjunbo on 2018-07-02.
 */
public class OldJdbc {
    private static final String SQL_INSERT_SPITTER = "insert into spitter (username, password, fullname) values (?, ?, ?)";
    private DataSource dataSource;

    public void addSpitter(Spitter spitter) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = dataSource.getConnection(); // 커넥션 얻기
            stmt = conn.prepareStatement(SQL_INSERT_SPITTER);
            stmt.setString(1, spitter.getUsername());
            stmt.setString(2, spitter.getPassword());
            stmt.setString(3, spitter.getFullName());
            stmt.execute();
        } catch (SQLException e) {

        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {

            }
        }
    }
}
