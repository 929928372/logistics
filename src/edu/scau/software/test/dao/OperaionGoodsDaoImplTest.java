package edu.scau.software.test.dao;

import edu.scau.software.bean.OperationGoods;
import edu.scau.software.dao.Impl.OperaionGoodsDaoImpl;
import edu.scau.software.dao.Interface.OperationGoodsDao;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OperaionGoodsDaoImplTest {
    private OperationGoodsDao operationGoodsDao = new OperaionGoodsDaoImpl();

    @Test
    public void addOperationGoods() {
        operationGoodsDao.addOperationGoods(new OperationGoods(null, 1, 1, "123155225",
                "老王", "7758258", "北京王府井", 0));
        operationGoodsDao.addOperationGoods(new OperationGoods(null, 2, 9, "124124364",
                "隔壁老王", "77582588", "上海浦东新区", 0));
    }

    @Test
    public void deleteOperationGoodsById() {
        Integer id = 2;
        operationGoodsDao.deleteOperationGoodsById(id);
    }

    @Test
    public void updateOperationGoods() {
        operationGoodsDao.updateOperationGoods(new OperationGoods(2, 2, 3, "124124124",
                "隔壁老王", "77582588", "上海浦东新区", 1));
    }

    @Test
    public void queryOperationGoods() {
        List<OperationGoods> operationGoods = operationGoodsDao.queryOperationGoods();
        for (OperationGoods operationGood : operationGoods) {
            System.out.println(operationGood);
        }
    }

    @Test
    public void queryOperationGoodById() {
        Integer id=2;
        OperationGoods operationGoods = operationGoodsDao.queryOperationGoodById(id);
        System.out.println(operationGoods);
    }
}