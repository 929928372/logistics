package edu.scau.software.test.dao;

import edu.scau.software.bean.Customer;
import edu.scau.software.bean.OperationGoods;
import edu.scau.software.dao.Impl.CustomerDaoImpl;
import edu.scau.software.dao.Interface.CustomerDao;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CustomerDaoImplTest {
    private CustomerDao customerDao = new CustomerDaoImpl();

    @Test
    public void addCustomer() {
        customerDao.addCustomer(new Customer(null, "陈警官", "110", "五山派出所", "123456"));
        customerDao.addCustomer(new Customer(null, "李警官", "110", "岗顶派出所", "123456"));
    }

    @Test
    public void deleteCustomerById() {
        Integer id = 1;
        customerDao.deleteCustomerById(id);
    }

    @Test
    public void updateCustomer() {
        customerDao.updateCustomer(new Customer(6, "黄警官", "110", "天河派出所", "123456"));
    }

    @Test
    public void queryCustomers() {
        List<Customer> customers = customerDao.queryCustomers();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    @Test
    public void queryCustomerById() {
        Integer id = 1;
        Customer customer = customerDao.queryCustomerById(id);
        System.out.println(customer);
    }

    @Test
    public void queryCustomerByUsernameAndPassword() {
        String username = "黄警官", password = "123456";
        System.out.println(customerDao.queryCustomerByUsernameAndPassword(username, password));
    }

    @Test
    public void queryExistUsername() {
        String username = "黄警官";
        System.out.println(customerDao.queryExistUsername(username));
    }

    @Test
    public void queryForTotalCountById() {
        Integer id = 1;
        System.out.println(customerDao.queryForTotalCountById(id));
    }

    @Test
    public void queryForPageItemsById() {
        Integer id = 1, begin = 0, pageSize = 2;
        List<OperationGoods> operationGoods = customerDao.queryForPageItemsById(id, begin, pageSize);
        for (OperationGoods operationGood : operationGoods) {
            System.out.println(operationGood);
        }
    }
}