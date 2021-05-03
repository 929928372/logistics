package edu.scau.software.bean;

public class Car {
    private Integer id;
    private String username;
    private String user_number;
    private String car_number;
    private String tel;
    private String address;
    private String car_road;
    private String car_content;

    public Car() {
    }

    public Car(String username, String user_number, String car_number, String tel, String address, String car_road, String car_content) {
        this.username = username;
        this.user_number = user_number;
        this.car_number = car_number;
        this.tel = tel;
        this.address = address;
        this.car_road = car_road;
        this.car_content = car_content;
    }

    public Car(Integer id, String username, String user_number, String car_number, String tel, String address, String car_road, String car_content) {
        this.id = id;
        this.username = username;
        this.user_number = user_number;
        this.car_number = car_number;
        this.tel = tel;
        this.address = address;
        this.car_road = car_road;
        this.car_content = car_content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUser_number() {
        return user_number;
    }

    public void setUser_number(String user_number) {
        this.user_number = user_number;
    }

    public String getCar_number() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCar_road() {
        return car_road;
    }

    public void setCar_road(String car_road) {
        this.car_road = car_road;
    }

    public String getCar_content() {
        return car_content;
    }

    public void setCar_content(String car_content) {
        this.car_content = car_content;
    }

    @Override
    public String toString() {
        return "car{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", user_number='" + user_number + '\'' +
                ", car_number='" + car_number + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", car_road='" + car_road + '\'' +
                ", car_content='" + car_content + '\'' +
                '}';
    }
}
