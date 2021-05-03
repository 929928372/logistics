package edu.scau.software.dao.Impl;

import edu.scau.software.bean.Customer;
import edu.scau.software.bean.OperationGoods;
import edu.scau.software.dao.Interface.OperationGoodsDao;

import java.util.List;

public class OperaionGoodsDaoImpl extends BaseDao implements OperationGoodsDao {
    @Override
    public int addOperationGoods(OperationGoods operationGoods) {
        /**
         * 添加发货单
         */
        String sql = "insert into t_operationgoods values(?,?,?,?,?,?,?,?)";
        return update(sql, operationGoods.getId(), operationGoods.getCar_id(), operationGoods.getCustomer_id(),
                operationGoods.getGoods_id(), operationGoods.getGoods_name(), operationGoods.getGoods_tel(),
                operationGoods.getGoods_address(), operationGoods.getGoods_sure());
    }

    @Override
    public int deleteOperationGoodsById(Integer id) {
        /**
         * 删除发货单
         */
        String sql = "delete from t_operationgoods where id=?";
        return update(sql, id);
    }

    @Override
    public int updateOperationGoods(OperationGoods operationGoods) {
        /**
         * 修改发货单
         */
        String sql = "update t_operationgoods set car_id=?, " +
                "customer_id=?, " +
                "goods_id=?, " +
                "goods_name=?, " +
                "goods_tel=?, " +
                "goods_address=?, " +
                "goods_sure=? " +
                "where id=?";
        return update(sql, operationGoods.getCar_id(), operationGoods.getCustomer_id(),
                operationGoods.getGoods_id(), operationGoods.getGoods_name(), operationGoods.getGoods_tel(),
                operationGoods.getGoods_address(), operationGoods.getGoods_sure(), operationGoods.getId());
    }

    @Override
    public List<OperationGoods> queryOperationGoods() {
        /**
         * 查询发货单
         */
        String sql = "select * from t_operationgoods";
        return queryForList(OperationGoods.class, sql);
    }

    @Override
    public OperationGoods queryOperationGoodById(Integer id) {
        /**
         * 根据发货单id查询指定发货单
         */
        String sql = "select * from t_operationgoods where id=?";
        return queryForOne(OperationGoods.class, sql, id);
    }

    @Override
    public int queryGoodsCount() {
        /**
         * 查询发货单总数
         */
        String sql = "select count(*) from t_operationgoods";
        return ((Long) queryForSingleValue(sql)).intValue();
    }

    @Override
    public List<OperationGoods> queryForGoodPage(int begin, int pageSize) {
        /**
         * 查询指定页面的发货单
         */
        String sql = "select * from t_operationgoods limit ?,?";
        List<OperationGoods> goods = queryForList(OperationGoods.class, sql, begin, pageSize);
        return goods;
    }

    @Override
    public int queryUndoGoodsCount() {
        /**
         * 查询未填写的发货单总数
         */
        String sql = "select count(*) from t_operationgoods where car_id is null";
        return ((Long) queryForSingleValue(sql)).intValue();
    }

    @Override
    public List<OperationGoods> queryForUndoGoodPage(int begin, int pageSize) {
        /**
         * 查询未填写的指定页面发货单
         */
        String sql = "select * from t_operationgoods where car_id is null limit ?,?";
        List<OperationGoods> goods = queryForList(OperationGoods.class, sql, begin, pageSize);
        return goods;
    }

    @Override
    public int queryHaveWriteGoodsCount() {
        /**
         * 查询已填写的发货单总数
         */
        String sql = "select count(*) from t_operationgoods where car_id is not null and goods_sure=0";
        return ((Long) queryForSingleValue(sql)).intValue();
    }

    @Override
    public List<OperationGoods> queryForHaveWriteGoodPage(int begin, int pageSize) {
        /**
         * 查询已填写的指定页面发货单
         */
        String sql = "select * from t_operationgoods where car_id is not null and goods_sure=0 limit ?,?";
        List<OperationGoods> goods = queryForList(OperationGoods.class, sql, begin, pageSize);
        return goods;
    }

    @Override
    public int queryHaveDoneGoodsCount() {
        /**
         * 查询已完成的发货单总数
         */
        String sql = "select count(*) from t_operationgoods where goods_sure=1";
        return ((Long) queryForSingleValue(sql)).intValue();
    }

    @Override
    public List<OperationGoods> queryForHaveDoneGoodPage(int begin, int pageSize) {
        /**
         * 查询已完成的指定页面发货单
         */
        String sql = "select * from t_operationgoods where goods_sure=1 limit ?,?";
        List<OperationGoods> goods = queryForList(OperationGoods.class, sql, begin, pageSize);
        return goods;
    }

    @Override
    public OperationGoods queryGoodByGoods_id(String goods_id) {
        if (goods_id == null)
            return null;
        String sql = "select * from t_operationgoods where goods_id=?";
        return queryForOne(OperationGoods.class, sql, goods_id);
    }

    @Override
    public void deleteOperationGoodsByGoods_id(String goods_id) {
        if (goods_id == null)
            return;
        String sql = "delete from t_operationgoods where goods_id=?";
        update(sql, goods_id);
    }

    @Override
    public int queryGoodsCountByCustomer_id(Integer customer_id) {
        if (customer_id == null)
            return 0;
        String sql = "select count(*) from t_operationgoods where customer_id=?";
        Number count = (Number) queryForSingleValue(sql, customer_id);
        return count.intValue();
    }

    @Override
    public List<OperationGoods> queryGoodPageByCustomer_id(Integer customer_id, int begin, int pageSize) {
        if (customer_id == null)
            return null;
        String sql = "select * from t_operationgoods where customer_id=? limit ?,?";
        List<OperationGoods> operationGoods = queryForList(OperationGoods.class, sql, customer_id, begin, pageSize);
        return operationGoods;
    }

    @Override
    public void confirmGood(String goods_id) {
        String sql = "update t_operationgoods set goods_sure=1 where goods_id=?";
        update(sql, goods_id);
    }

    @Override
    public List<OperationGoods> queryGoodsByQueryWord(String queryWord) {
        if (queryWord == null)
            return null;
        String sql = "select * from t_operationgoods where goods_id REGEXP ?";
        return queryForList(OperationGoods.class, sql, queryWord);
    }
}
