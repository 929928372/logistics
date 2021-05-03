package edu.scau.software.test.service;

import edu.scau.software.bean.Car;
import edu.scau.software.bean.OperationGoods;
import edu.scau.software.bean.Page;
import edu.scau.software.service.Impl.AdminServiceImpl;
import edu.scau.software.service.Interface.AdminService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AdminServiceImplTest {
    private AdminService adminService = new AdminServiceImpl();

    @Test
    public void queryAdaptCars() {
        String customer_address = "广州", goods_address = "北京";
        List<Car> cars = adminService.queryAdaptCars(customer_address, goods_address);
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    @Test
    public void queryHaveWriteGoodsPage() {
        int pageNo = 0, pageSize = 3;
        Page<OperationGoods> page = adminService.queryHaveWriteGoodsPage(pageNo, pageSize);
        System.out.println(page);
        for (OperationGoods item : page.getItems()) {
            System.out.println(item);
        }
    }

    @Test
    public void queryHaveDoneGoodsPage() {
        int pageNo = 0, pageSize = 3;
        Page<OperationGoods> page = adminService.queryHaveDoneGoodsPage(pageNo, pageSize);
        System.out.println(page);
        for (OperationGoods item : page.getItems()) {
            System.out.println(item);
        }
    }

    @Test
    public void queryCarsPage() {
        int pageNo = 1, pageSize = 3;
        Page<Car> carPage = adminService.queryCarsPage(pageNo, pageSize);
        System.out.println(carPage);
        for (Car item : carPage.getItems()) {
            System.out.println(item);
        }
    }
}