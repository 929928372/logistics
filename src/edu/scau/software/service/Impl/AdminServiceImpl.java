package edu.scau.software.service.Impl;

import edu.scau.software.bean.*;
import edu.scau.software.dao.Impl.*;
import edu.scau.software.dao.Interface.*;
import edu.scau.software.service.Interface.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao = new AdminDaoImpl();
    private OperationGoodsDao goodsDao = new OperaionGoodsDaoImpl();
    private CustomerDao customerDao = new CustomerDaoImpl();
    private CarDao carDao = new CarDaoImpl();
    private CarlogDao carlogDao = new CarlogDaoImpl();

    // 修改密码
    @Override
    public void updatePassword(Admin admin) {
        adminDao.updateAdmin(admin);
    }

    // 登录
    @Override
    public Admin login(Admin admin) {
        return adminDao.queryAdminByUsernameAndPassword(admin.getAdmin_user(), admin.getAdmin_password());
    }

    //    ------------------------发货单管理-------------------------
    @Override
    public List<OperationGoods> queryGoods() {
        return goodsDao.queryOperationGoods();
    }

    @Override
    public Page<OperationGoods> getGoodsPage(int pageNo, int pageSize) {
        Page<OperationGoods> page = new Page<>();

        page.setPageNo(pageNo);

        page.setPageSize(pageSize);

        int totalCount = goodsDao.queryGoodsCount();
        page.setTotalCount(totalCount);

        int pageTotal = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);

        int begin = (page.getPageNo() - 1) * pageSize;
        if (begin < 0) {
            page.setItems(null);
        } else {
            List<OperationGoods> goods = goodsDao.queryForGoodPage(begin, pageSize);
            page.setItems(goods);
        }

        return page;
    }

    @Override
    public Page<OperationGoods> getUndoGoodsPage(int pageNo, int pageSize) {
        Page<OperationGoods> page = new Page<>();

        page.setPageNo(pageNo);

        page.setPageSize(pageSize);

        int totalCount = goodsDao.queryUndoGoodsCount();
        page.setTotalCount(totalCount);

        int pageTotal = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);

        int begin = (page.getPageNo() - 1) * pageSize;
        // 总数为0(查询不到数据)
        if (begin < 0) {
            page.setItems(null);
        } else {
            List<OperationGoods> goods = goodsDao.queryForUndoGoodPage(begin, pageSize);
            page.setItems(goods);
        }

        return page;
    }

    @Override
    public Page<OperationGoods> queryHaveWriteGoodsPage(int pageNo, int pageSize) {
        Page<OperationGoods> page = new Page<>();

        page.setPageNo(pageNo);

        page.setPageSize(pageSize);

        int totalCount = goodsDao.queryHaveWriteGoodsCount();
        page.setTotalCount(totalCount);

        int pageTotal = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);

        int begin = (page.getPageNo() - 1) * pageSize;
        if (begin < 0) {
            page.setItems(null);
        } else {
            List<OperationGoods> goods = goodsDao.queryForHaveWriteGoodPage(begin, pageSize);
            page.setItems(goods);
        }
        return page;
    }

    @Override
    public OperationGoods queryGood(Integer id) {
        return goodsDao.queryOperationGoodById(id);
    }

    //通过订单界面发起订单
    @Override
    public void doGoodByGoods(OperationGoods good) {
        goodsDao.updateOperationGoods(good);
    }

    //通过车源界面发起订单
    @Override
    public void doGoodByCars(OperationGoods good) {
        goodsDao.updateOperationGoods(good);
    }

    @Override
    public void addGood(OperationGoods good) {
        goodsDao.addOperationGoods(good);
    }

    @Override
    public void deleteGoodById(Integer id) {
        goodsDao.deleteOperationGoodsById(id);
    }

    @Override
    public void deleteGoodByGoods_id(String goods_id) {
        goodsDao.deleteOperationGoodsByGoods_id(goods_id);
    }

    @Override
    public void updateGood(OperationGoods good) {
        goodsDao.updateOperationGoods(good);
    }

    //确定回馈订单
    @Override
    public void confirmGood(String goods_id) {
        goodsDao.confirmGood(goods_id);
    }

    @Override
    public Page<OperationGoods> queryHaveDoneGoodsPage(int pageNo, int pageSize) {
        Page<OperationGoods> page = new Page<>();

        page.setPageNo(pageNo);

        page.setPageSize(pageSize);

        int totalCount = goodsDao.queryHaveDoneGoodsCount();
        page.setTotalCount(totalCount);

        int pageTotal = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);

        int begin = (page.getPageNo() - 1) * pageSize;
        if (begin < 0) {
            page.setItems(null);
        } else {
            List<OperationGoods> goods = goodsDao.queryForHaveDoneGoodPage(begin, pageSize);
            page.setItems(goods);
        }

        return page;
    }

    @Override
    public int queryGoodsCount() {
        return goodsDao.queryGoodsCount();
    }

    @Override
    public OperationGoods queryGoodByGoods_id(String goods_id) {
        return goodsDao.queryGoodByGoods_id(goods_id);
    }

    @Override
    public Page<OperationGoods> queryGoodsPageByCustomer_id(Integer customer_id, int pageNo, int pageSize) {
        Page<OperationGoods> page = new Page<>();

        page.setPageNo(pageNo);

        page.setPageSize(pageSize);

        int totalCount = goodsDao.queryGoodsCountByCustomer_id(customer_id);
        page.setTotalCount(totalCount);

        int pageTotal = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);

        int begin = (page.getPageNo() - 1) * pageSize;
        if (begin < 0) {
            page.setItems(null);
        } else {
            List<OperationGoods> goods = goodsDao.queryGoodPageByCustomer_id(customer_id, begin, pageSize);
            page.setItems(goods);
        }

        return page;
    }

    @Override
    public List<OperationGoods> queryGoodsByQueryWord(String queryWord) {
        return goodsDao.queryGoodsByQueryWord(queryWord);
    }

    //    ------------------------固定客户管理-------------------------
    //    返回所有客户
    @Override
    public List<Customer> queryCustomers() {
        return customerDao.queryCustomers();
    }

    //    返回指定页面客户
    @Override
    public Page<Customer> getCustomerPage(Integer pageNo, Integer pageSize) {
        Page<Customer> page = new Page<>();

        page.setPageNo(pageNo);

        page.setPageSize(pageSize);

        int totalCount = customerDao.queryCustomersCount();
        page.setTotalCount(totalCount);

        int pageTotal = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);

        int begin = (page.getPageNo() - 1) * pageSize;
        if (begin < 0) {
            page.setItems(null);
        } else {
            List<Customer> customers = customerDao.queryForCustomerPage(begin, pageSize);
            page.setItems(customers);
        }

        return page;
    }

    @Override
    public Customer queryCustomerById(int customer_id) {
        return customerDao.queryCustomerById(customer_id);
    }

    @Override
    public String queryCustomer_addressByUsername(String username) {
        return customerDao.queryCustomer_addressByUsername(username);
    }

    @Override
    public List<Customer> queryCustomersByQueryWord(String queryWord) {
        return customerDao.queryCustomersByQueryWord(queryWord);
    }

    @Override
    public Customer queryCustomerByUsername(String username) {
        return customerDao.queryCustomerByUsername(username);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }

    @Override
    public void deleteCustomerById(Integer id) {
        customerDao.deleteCustomerById(id);
    }

    @Override
    public void deleteCustomerByUsername(String username) {

    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }

    //    ------------------------车源信息管理------------------------
    @Override
    public List<Carlog> queryCarlogs() {
        return carlogDao.queryCarlogs();
    }

    @Override
    public List<Car> queryCars() {
        return carDao.queryCars();
    }

    @Override
    public void addCar(Car car) {
        carDao.addCar(car);
    }

    @Override
    public void deleteCarById(Integer id) {
        carDao.deleteCarById(id);
    }

    @Override
    public void updateCar(Car car) {
        carDao.updateCar(car);
    }

    @Override
    public List<Car> queryAdaptCars(String customer_address, String goods_address) {
        String car_road = customer_address + "->" + goods_address;
        List<Car> cars = carDao.queryCarByCar_road(car_road);
        return cars;
    }

    @Override
    public Page<Car> queryCarsPage(int pageNo, int pageSize) {
        Page<Car> page = new Page<>();

        page.setPageNo(pageNo);

        page.setPageSize(pageSize);

        int totalCount = carDao.queryCarsCount();
        page.setTotalCount(totalCount);

        int pageTotal = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);

        int begin = (page.getPageNo() - 1) * pageSize;
        if (begin < 0) {
            page.setItems(null);
        } else {
            List<Car> cars = carDao.queryForCarsPage(begin, pageSize);
            page.setItems(cars);
        }

        return page;
    }

    @Override
    public Car queryCarById(Integer car_id) {
        return carDao.queryCarById(car_id);
    }

    @Override
    public Car queryCarByCar_number(String car_number) {
        return carDao.queryCarByCar_number(car_number);
    }

    @Override
    public int queryCarCount() {
        return carDao.queryCarsCount();
    }

    //    ------------------------车源日志管理------------------------

    @Override
    public Carlog queryCarLogByGoods_id(String goods_id) {
        return carlogDao.queryCarlogByGoods_id(goods_id);
    }

    @Override
    public void addCarlog(Carlog carlog) {
        carlogDao.addCarlog(carlog);
    }

    @Override
    public void deleteCarlogByGoods_id(String goods_id) {
        carlogDao.deleteCarlogByGoods_id(goods_id);
    }
}
