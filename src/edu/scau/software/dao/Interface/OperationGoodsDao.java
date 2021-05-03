package edu.scau.software.dao.Interface;

import edu.scau.software.bean.OperationGoods;

import java.util.List;

public interface OperationGoodsDao {
    int addOperationGoods(OperationGoods operationGoods);

    int deleteOperationGoodsById(Integer id);

    int updateOperationGoods(OperationGoods operationGoods);

    List<OperationGoods> queryOperationGoods();

    OperationGoods queryOperationGoodById(Integer id);

    int queryGoodsCount();

    List<OperationGoods> queryForGoodPage(int begin, int pageSize);

    int queryUndoGoodsCount();

    List<OperationGoods> queryForUndoGoodPage(int begin, int pageSize);

    int queryHaveWriteGoodsCount();

    List<OperationGoods> queryForHaveWriteGoodPage(int begin, int pageSize);

    int queryHaveDoneGoodsCount();

    List<OperationGoods> queryForHaveDoneGoodPage(int begin, int pageSize);

    OperationGoods queryGoodByGoods_id(String goods_id);

    void deleteOperationGoodsByGoods_id(String goods_id);

    int queryGoodsCountByCustomer_id(Integer customer_id);

    List<OperationGoods> queryGoodPageByCustomer_id(Integer customer_id, int begin, int pageSize);

    void confirmGood(String goods_id);

    List<OperationGoods> queryGoodsByQueryWord(String queryWord);
}
