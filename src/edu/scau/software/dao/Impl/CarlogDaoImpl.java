package edu.scau.software.dao.Impl;

import edu.scau.software.bean.Carlog;
import edu.scau.software.dao.Interface.CarlogDao;

import java.util.List;

public class CarlogDaoImpl extends BaseDao implements CarlogDao {
    @Override
    public int addCarlog(Carlog carlog) {
        String sql = "insert into t_carlog values(?,?,?,?,?,?)";
        return update(sql, carlog.getId(), carlog.getGood_id(), carlog.getCar_id(), carlog.getStartTime(),
                carlog.getEndTime(), carlog.getDescriber());
    }

    @Override
    public int deleteCarlogById(Integer id) {
        String sql = "delete from t_carlog where id=?";
        return update(sql, id);
    }

    @Override
    public int updateCarlog(Carlog carlog) {
        String sql = "update t_carlog set good_id=?, " +
                "car_id=?, " +
                "startTime=?, " +
                "endTime=?, " +
                "describer=? " +
                "where id=?";
        return update(sql, carlog.getGood_id(), carlog.getCar_id(), carlog.getStartTime(),
                carlog.getEndTime(), carlog.getDescriber(), carlog.getId());
    }

    @Override
    public List<Carlog> queryCarlogs() {
        String sql = "select * from t_carlog";
        return queryForList(Carlog.class, sql);
    }

    @Override
    public Carlog queryCarlogById(Integer id) {
        if (id == null)
            return null;
        String sql = "select * from t_carlog where id=?";
        return queryForOne(Carlog.class, sql, id);
    }

    @Override
    public Carlog queryCarlogByGoods_id(String goods_id) {
        if (goods_id == null)
            return null;
        String sql = "select * from t_carlog where good_id=?";
        return queryForOne(Carlog.class, sql, goods_id);
    }

    @Override
    public void deleteCarlogByGoods_id(String goods_id) {
        if (goods_id == null)
            return;
        String sql = "delete from t_carlog where good_id=?";
        update(sql, goods_id);
    }
}
