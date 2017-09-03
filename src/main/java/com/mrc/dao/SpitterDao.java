package com.mrc.dao;

import com.mrc.domain.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017-09-03.
 */
@Component
public class SpitterDao {
    private static final String SQL_INSERT_SPITTER =
            "insert into spitter (username, password) values (?, ?)";

    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    /**
     * 使用原生的jdbc，不推荐使用该种方式，太多模板类的代码
     *
     * @param spitter
     */
    public void addSpitter(Spitter spitter) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_SPITTER);
            stmt.setString(1, spitter.getUsername());
            stmt.setString(2, spitter.getPassword());
            stmt.execute();
        } catch (SQLException e) {
            //do something...not sure what, though
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                //I'm even less sure about what to do here
            }
        }
    }
}