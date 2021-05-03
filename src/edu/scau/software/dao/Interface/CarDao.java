package edu.scau.software.dao.Interface;

import edu.scau.software.bean.Car;

import java.util.List;

public interface CarDao {
    int addCar(Car car);

    int deleteCarById(Integer id);

    int updateCar(Car car);

    List<Car> queryCars();

    Car queryCarById(Integer id);

    List<Car> queryCarByCar_road(String car_road);

    int queryCarsCount();

    List<Car> queryForCarsPage(int begin, int pageSize);

    Car queryCarByCar_number(String car_number);
}
