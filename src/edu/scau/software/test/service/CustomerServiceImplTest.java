package edu.scau.software.test.service;

import edu.scau.software.bean.OperationGoods;
import edu.scau.software.bean.Page;
import edu.scau.software.service.Impl.CustomerServiceImpl;
import edu.scau.software.service.Interface.CustomerService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CustomerServiceImplTest {
    private CustomerService customerService = new CustomerServiceImpl();

    @Test
    public void existsUsername() {

    }

    @Test
    public void getPage() {
        Integer id = 1, pageNo = 0, pageSize = 3;
        Page<OperationGoods> page = customerService.getPage(id, pageNo, pageSize);
        List<OperationGoods> items = page.getItems();
        System.out.println(page);
        for (OperationGoods item : items) {
            System.out.println(item);
        }
    }

    @Test
    public void addGood() {
        OperationGoods good=new OperationGoods(null,null,1,"15613131","小笨","7758258","北京天安门",0);
        customerService.addGood(good);
    }
}