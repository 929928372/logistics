package edu.scau.software.service.Impl;

import edu.scau.software.bean.Carlog;
import edu.scau.software.bean.Customer;
import edu.scau.software.bean.OperationGoods;
import edu.scau.software.bean.Page;
import edu.scau.software.dao.Impl.CarlogDaoImpl;
import edu.scau.software.dao.Impl.CustomerDaoImpl;
import edu.scau.software.dao.Impl.OperaionGoodsDaoImpl;
import edu.scau.software.dao.Interface.CarlogDao;
import edu.scau.software.dao.Interface.CustomerDao;
import edu.scau.software.dao.Interface.OperationGoodsDao;
import edu.scau.software.service.Interface.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao = new CustomerDaoImpl();
    private CarlogDao carlogDao=new CarlogDaoImpl();
    private OperationGoodsDao goodsDao=new OperaionGoodsDaoImpl();

    @Override
    public List<OperationGoods> queryGoodsById(Integer id) {
        return null;
    }

    @Override
    public Customer login(Customer customer) {
        return customerDao.queryCustomerByUsernameAndPassword(customer.getCustomer_user(), customer.getCustomer_password());
    }

    @Override
    public int register(Customer customer) {
        return customerDao.addCustomer(customer);
    }

    @Override
    public boolean existsUsername(String username) {
        if (customerDao.queryExistUsername(username) != null)
            return true;
        return false;
    }

    @Override
    public Page<OperationGoods> getPage(Integer id, Integer pageNo, Integer pageSize) {
        Page<OperationGoods> page = new Page<>();

        page.setPageNo(pageNo);

        page.setPageSize(pageSize);

        int totalCount = customerDao.queryForTotalCountById(id);
        page.setTotalCount(totalCount);

        int pageTotal = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);

        int begin = (page.getPageNo() - 1) * pageSize;
        if (begin < 0){
            page.setItems(null);
        }else {
            List<OperationGoods> operationGoods = customerDao.queryForPageItemsById(id, begin, pageSize);
            page.setItems(operationGoods);
        }

        return page;
    }

    @Override
    public void addGood(OperationGoods good) {
        customerDao.addGood(good);
    }

    @Override
    public void updateCustomerInfo(Customer customer) {
        customerDao.updateCustomer(customer);
    }

    @Override
    public Carlog queryCarlogByGoods_id(String goods_id) {
        return carlogDao.queryCarlogByGoods_id(goods_id);
    }

    @Override
    public int queryGoodsCountByCustomer_id(Integer customer_id) {
        return goodsDao.queryGoodsCountByCustomer_id(customer_id);
    }

    @Override
    public void addCarlog(Carlog carlog) {
        carlogDao.addCarlog(carlog);
    }

    @Override
    public Customer queryCustomerByUsername(String username) {
        return customerDao.queryCustomerByUsername(username);
    }
}
