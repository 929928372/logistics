package edu.scau.software.dao.Interface;

import edu.scau.software.bean.Car;
import edu.scau.software.bean.Customer;
import edu.scau.software.bean.OperationGoods;

import java.util.List;

public interface CustomerDao {
    int addCustomer(Customer customer);

    int deleteCustomerById(Integer id);

    int deleteCustomerByUsername(String username);

    int updateCustomer(Customer customer);

    List<Customer> queryCustomers();

    int queryCustomersCount();

    Customer queryCustomerById(Integer id);

    Customer queryCustomerByUsernameAndPassword(String username, String password);

    Customer queryExistUsername(String username);

    // 用户查询发货单总数
    int queryForTotalCountById(Integer id);

    // 用户查询指定页面的发货单
    List<OperationGoods> queryForPageItemsById(Integer id, Integer begin, Integer pageSize);

    // 添加发货单
    void addGood(OperationGoods good);

    List<Customer> queryForCustomerPage(int begin,int pageSize);

    String queryCustomer_addressByUsername(String username);

    Customer queryCustomerByUsername(String username);

    List<Customer> queryCustomersByQueryWord(String queryWord);
}
