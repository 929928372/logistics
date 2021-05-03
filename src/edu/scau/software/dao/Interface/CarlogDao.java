package edu.scau.software.dao.Interface;

import edu.scau.software.bean.Carlog;

import java.util.List;

public interface CarlogDao {
    int addCarlog(Carlog carlog);

    int deleteCarlogById(Integer id);

    int updateCarlog(Carlog carlog);

    List<Carlog> queryCarlogs();

    Carlog queryCarlogById(Integer id);

    Carlog queryCarlogByGoods_id(String goods_id);

    void deleteCarlogByGoods_id(String goods_id);
}
