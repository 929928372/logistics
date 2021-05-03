package edu.scau.software.test.dao;

import edu.scau.software.bean.Carlog;
import edu.scau.software.dao.Impl.CarlogDaoImpl;
import edu.scau.software.dao.Interface.CarlogDao;
import org.junit.Test;

import java.util.List;

public class CarlogImplTest {
    CarlogDao carlogDao=new CarlogDaoImpl();

    @Test
    public void addCarlog() {
        carlogDao.addCarlog(new Carlog(null,"1233211234569",6,"2021/4/21",
                "2021/4/24","无"));
        carlogDao.addCarlog(new Carlog(null,"1233211234510",5,"2021/4/22",
                "2021/4/25","无"));
    }

    @Test
    public void deleteCarlogById() {
        carlogDao.deleteCarlogById(2);
    }

    @Test
    public void updateCarlog() {
        carlogDao.updateCarlog(new Carlog(2,"1233211234568",6,"2021/4/21",
                "2021/4/24","修改了Carlog"));
    }

    @Test
    public void queryCarlogs() {
        List<Carlog> carlogs = carlogDao.queryCarlogs();
        for (Carlog carlog : carlogs) {
            System.out.println(carlog);
        }
    }

    @Test
    public void queryCarlogById() {
        Carlog carlog = carlogDao.queryCarlogById(2);
        System.out.println(carlog);
    }
}