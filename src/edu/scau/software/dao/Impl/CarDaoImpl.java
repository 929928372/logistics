package edu.scau.software.dao.Impl;

import edu.scau.software.bean.Car;
import edu.scau.software.bean.OperationGoods;
import edu.scau.software.dao.Interface.CarDao;

import java.util.List;

public class CarDaoImpl extends BaseDao implements CarDao {
    @Override
    public int addCar(Car car) {
        String sql = "insert into t_car values(?,?,?,?,?,?,?,?)";
        return update(sql, car.getId(), car.getUsername(), car.getUser_number(), car.getCar_number(),
                car.getTel(), car.getAddress(), car.getCar_road(), car.getCar_content());
    }

    @Override
    public int deleteCarById(Integer id) {
        String sql = "delete from t_car where id=?";
        return update(sql, id);
    }

    @Override
    public int updateCar(Car car) {
        String sql = "update t_car set username=?," +
                "user_number=?, " +
                "car_number=?, " +
                "tel=?, " +
                "address=?, " +
                "car_road=?, " +
                "car_content=? " +
                "where id=?";
        return update(sql, car.getUsername(), car.getUser_number(), car.getCar_number(), car.getTel(),
                car.getAddress(), car.getCar_road(), car.getCar_content(), car.getId());
    }

    @Override
    public List<Car> queryCars() {
        String sql = "select * from t_car";
        return queryForList(Car.class, sql);
    }

    @Override
    public Car queryCarById(Integer id) {
        if(id==null){
            System.out.println("出现空值");
            return null;
        }
        String sql = "select * from t_car where id=?";
        return queryForOne(Car.class, sql, id);
    }

    @Override
    public List<Car> queryCarByCar_road(String car_road) {
        if (car_road==null)
            return null;
        String sql="select * from t_car where car_road=?";
        return queryForList(Car.class,sql,car_road);
    }

    @Override
    public int queryCarsCount() {
        String sql = "select count(*) from t_car";
        return ((Long) queryForSingleValue(sql)).intValue();
    }

    @Override
    public List<Car> queryForCarsPage(int begin, int pageSize) {
        String sql = "select * from t_car limit ?,?";
        List<Car> cars = queryForList(Car.class, sql, begin, pageSize);
        return cars;
    }

    @Override
    public Car queryCarByCar_number(String car_number) {
        if (car_number==null)
            return null;
        String sql="select * from t_car where car_number=?";
        return queryForOne(Car.class,sql,car_number);
    }
}
