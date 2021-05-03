package edu.scau.software.dao.Impl;

import edu.scau.software.bean.Car;
import edu.scau.software.bean.Customer;
import edu.scau.software.bean.OperationGoods;
import edu.scau.software.dao.Interface.CustomerDao;
import edu.scau.software.dao.Interface.OperationGoodsDao;

import java.util.List;

public class CustomerDaoImpl extends BaseDao implements CustomerDao {
    private OperationGoodsDao operationGoodsDao = new OperaionGoodsDaoImpl();

    @Override
    public int addCustomer(Customer customer) {
        String sql = "insert into t_customer values(?,?,?,?,?)";
        return update(sql, customer.getCustomer_id(), customer.getCustomer_user(),
                customer.getCustomer_tel(), customer.getCustomer_address(), customer.getCustomer_password());
    }

    @Override
    public int deleteCustomerById(Integer id) {
        String sql = "delete from t_customer where customer_id=?";
        return update(sql, id);
    }

    @Override
    public int deleteCustomerByUsername(String username) {
        String sql = "delete from t_customer where customer_user=?";
        return update(sql, username);
    }

    @Override
    public int updateCustomer(Customer customer) {
        String sql = "update t_customer set customer_user=?, " +
                "customer_tel=?, " +
                "customer_address=?, " +
                "customer_password=? " +
                "where customer_id=?";
        return update(sql, customer.getCustomer_user(), customer.getCustomer_tel(),
                customer.getCustomer_address(), customer.getCustomer_password(), customer.getCustomer_id());
    }

    @Override
    public List<Customer> queryCustomers() {
        String sql = "select * from t_customer";
        return queryForList(Customer.class, sql);
    }

    @Override
    public int queryCustomersCount() {
        String sql = "select count(*) from t_customer";
        return (int) queryForSingleValue(sql);
    }

    @Override
    public Customer queryCustomerById(Integer id) {
        if (id == null) {
            System.out.println("出现空值");
            return null;
        }
        String sql = "select * from t_customer where customer_id=?";
        return queryForOne(Customer.class, sql, id);
    }

    @Override
    public Customer queryCustomerByUsernameAndPassword(String username, String password) {
        String sql = "select * from t_customer where customer_user=? and customer_password=?";
        return queryForOne(Customer.class, sql, username, password);
    }

    @Override
    public Customer queryExistUsername(String username) {
        if (username == null)
            return null;
        String sql = "select * from t_customer where customer_user=?";
        return queryForOne(Customer.class, sql, username);
    }

    @Override
    public int queryForTotalCountById(Integer id) {
        String sql = "select count(*) from t_operationgoods where customer_id=?";
        Number count = (Number) queryForSingleValue(sql, id);
        return count.intValue();
    }

    @Override
    public List<OperationGoods> queryForPageItemsById(Integer id, Integer begin, Integer pageSize) {
        String sql = "select * from t_operationgoods where customer_id=? limit ?,?";
        List<OperationGoods> operationGoods = queryForList(OperationGoods.class, sql, id, begin, pageSize);
        return operationGoods;
    }

    @Override
    public void addGood(OperationGoods good) {
        operationGoodsDao.addOperationGoods(good);
    }

    @Override
    public List<Customer> queryForCustomerPage(int begin, int pageSize) {
        String sql = "select * from t_customer limit ?,?";
        List<Customer> customers = queryForList(Customer.class, sql, begin, pageSize);
        return customers;
    }

    @Override
    public String queryCustomer_addressByUsername(String username) {
        if (username == null)
            return null;
        String sql = "select customer_address from t_customer where customer_user=?";
        return (String) queryForSingleValue(sql, username);
    }

    @Override
    public Customer queryCustomerByUsername(String username) {
        if (username == null)
            return null;
        String sql = "select * from t_customer where customer_user=?";
        return queryForOne(Customer.class, sql, username);
    }

    @Override
    public List<Customer> queryCustomersByQueryWord(String queryWord) {
        if (queryWord == null)
            return null;
        String sql = "select * from t_customer where customer_user REGEXP ?";
        return queryForList(Customer.class, sql, queryWord);
    }
}
