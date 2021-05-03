package edu.scau.software.service.Interface;

import edu.scau.software.bean.Carlog;
import edu.scau.software.bean.Customer;
import edu.scau.software.bean.OperationGoods;
import edu.scau.software.bean.Page;

import java.util.List;

public interface CustomerService {
    List<OperationGoods> queryGoodsById(Integer id);

    Customer login(Customer customer);

    int register(Customer customer);

    boolean existsUsername(String username);

    // 查看发货单
    Page<OperationGoods> getPage(Integer id, Integer pageNo, Integer pageSize);

    // 添加发货单
    void addGood(OperationGoods good);

    void updateCustomerInfo(Customer customer);

    Carlog queryCarlogByGoods_id(String goods_id);

    int queryGoodsCountByCustomer_id(Integer customer_id);

    void addCarlog(Carlog carlog);

    Customer queryCustomerByUsername(String username);
}
