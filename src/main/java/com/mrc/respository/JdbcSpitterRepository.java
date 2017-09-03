package com.mrc.respository;

import com.mrc.controller.SpitterController;
import com.mrc.domain.Spitter;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017-09-03.
 * Spring提供的JDBC框架负责管理资源和异常处理，从而可以简化开发者的JDBC代码。
 * 只需要编写写入和读取数据库相关的代码即可
 */
@Repository
public class JdbcSpitterRepository implements SpitterRepository {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(JdbcSpitterRepository.class);
    @Autowired
    private JdbcOperations jdbcOperations;
    /**
     * 查询sql by id
     */
    private static final String SQL_SELECT_SPITTER =
            "select id, username from spitter where id = :id";
    private static final String SQL_SELECT_SPITTER_BY_NAME =
            "select id, username,password from spitter where username = ?";
    /**
     * 插入Spitter
     * 若使用命名参数，不能使用jdctemplate ,要使用 namedparameterJdbcTemplate
     * 防止sql发生变法导致参数的顺序与之前的不一致
     */
    private static final String SQL_INSERT_SPITTER =
            // "insert into spitter (username, password) values (:username, :password)";
            "insert into spitter (username, password) values (?, ?)";

    /**
     * 使用JdbcTemplate实现的addSpitter()
     *
     * @param spitter
     */
    public void addSpitter(Spitter spitter) {
        logger.info("新增Spitter" + spitter.getPassword() + "  " + spitter.getUsername());
        jdbcOperations.update(SQL_INSERT_SPITTER,
                spitter.getUsername(), spitter.getPassword()
                // spitter
        );
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Spitter save(Spitter spitter) {

        return null;
    }

    @Override
    public Spitter findOne(long id) {
        return jdbcOperations.queryForObject(
                SQL_SELECT_SPITTER,
                new SpitterRowMapper(),
                id);
    }

    private static final class SpitterRowMapper implements RowMapper<Spitter> {
        public Spitter mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Spitter(
                    resultSet.getLong("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"));
        }
    }

    @Override
    public Spitter findByUsername(String username) {
        return jdbcOperations.queryForObject(
                SQL_SELECT_SPITTER_BY_NAME,
                new SpitterRowMapper(),
                username);
    }

    @Override
    public List<Spitter> findAll() {
        return null;
    }
}
