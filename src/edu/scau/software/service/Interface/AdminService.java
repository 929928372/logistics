package edu.scau.software.service.Interface;

import edu.scau.software.bean.*;

import java.util.List;

public interface AdminService {
    //    修改密码
    void updatePassword(Admin admin);

    //    登录
    Admin login(Admin admin);


    //    ------------------------发货单管理-------------------------
    //    查询订单信息
    List<OperationGoods> queryGoods();

    //    查询单个订单
    OperationGoods queryGood(Integer id);

    //    通过订单表发起订单
    void doGoodByGoods(OperationGoods good);

    //    通过车源发起订单
    void doGoodByCars(OperationGoods good);

    //    新建订单
    void addGood(OperationGoods good);

    //    删除订单
    void deleteGoodById(Integer id);

    //    修改订单
    void updateGood(OperationGoods good);

    //    回执订单确认
    void confirmGood(String goods_id);


    //    ------------------------固定客户管理-------------------------
    //    查询顾客信息
    List<Customer> queryCustomers();
    Page<Customer> getCustomerPage(Integer pageNo, Integer pageSize);

    //    添加顾客
    void addCustomer(Customer customer);

    //    删除顾客
    void deleteCustomerById(Integer id);
    void deleteCustomerByUsername(String username);

    //    修改顾客
    void updateCustomer(Customer customer);


    //    ------------------------车源信息管理------------------------
    //    查询车源日志信息
    List<Carlog> queryCarlogs();

    //    查询车源
    List<Car> queryCars();

    //    添加车辆
    void addCar(Car car);

    //    删除车辆
    void deleteCarById(Integer id);

    //    修改车辆
    void updateCar(Car car);

    Page<OperationGoods> getGoodsPage(int pageNo, int pageSize);

    Page<OperationGoods> getUndoGoodsPage(int pageNo, int pageSize);

    Customer queryCustomerById(int customer_id);

    List<Car> queryAdaptCars(String customer_address, String goods_address);

    Page<OperationGoods> queryHaveWriteGoodsPage(int pageNo, int pageSize);

    Page<OperationGoods> queryHaveDoneGoodsPage(int pageNo, int pageSize);

    Page<Car> queryCarsPage(int pageNo, int pageSize);

    Car queryCarById(Integer car_id);

    Carlog queryCarLogByGoods_id(String goods_id);

    String queryCustomer_addressByUsername(String username);

    Customer queryCustomerByUsername(String username);

    Car queryCarByCar_number(String car_number);

    void addCarlog(Carlog carlog);

    int queryGoodsCount();

    OperationGoods queryGoodByGoods_id(String goods_id);

    void deleteGoodByGoods_id(String goods_id);

    void deleteCarlogByGoods_id(String goods_id);

    Page<OperationGoods> queryGoodsPageByCustomer_id(Integer customer_id, int pageNo, int pageSize);

    int queryCarCount();

    List<OperationGoods> queryGoodsByQueryWord(String queryWord);

    List<Customer> queryCustomersByQueryWord(String queryWord);
}

