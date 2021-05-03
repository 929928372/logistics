package edu.scau.software.dao.Impl;

import edu.scau.software.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class BaseDao {
    private QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());

    public int update(String sql, Object... args) {
        try {
            return queryRunner.update(sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public <T> T queryForOne(Class<T> type, String sql, Object... args) {
        try {
            return queryRunner.query(sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> List<T> queryForList(Class<T> type,String sql,Object...args){
        try {
            return queryRunner.query(sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object queryForSingleValue(String sql,Object...args){
        try {
            return queryRunner.query(sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
