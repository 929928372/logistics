package edu.scau.software.test.dao;

import edu.scau.software.bean.Car;
import edu.scau.software.dao.Impl.CarDaoImpl;
import edu.scau.software.dao.Interface.CarDao;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CarDaoImplTest {
    private CarDao carDao = new CarDaoImpl();

    @Test
    public void addCar() {
        carDao.addCar(new Car(null, "李大叔", "430302...", "粤A3S201",
                "13543706213", "广州天河区五山", "广州->北京", "无"));
        carDao.addCar(new Car(null, "王大哥", "432321...", "粤S6A305",
                "13632156651", "广州天河区石牌桥", "广州->上海", "无"));
    }

    @Test
    public void deleteCarById() {
        Integer id = 7;
        carDao.deleteCarById(id);
    }

    @Test
    public void updateCar() {
        carDao.updateCar(new Car(7, "王大妈", "432321...", "粤S6A305",
                "13632156651", "广州天河区石牌桥", "广州->上海", "无"));
    }

    @Test
    public void queryCars() {
        List<Car> cars = carDao.queryCars();
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    @Test
    public void queryCarById() {
        Integer id=7;
        Car car = carDao.queryCarById(id);
        System.out.println(car);
    }
}