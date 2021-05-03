package edu.scau.software.bean;

public class OperationGoods {
    private Integer id;
    private Integer car_id;
    private Integer customer_id;
    private String goods_id;
    private String goods_name;
    private String goods_tel;
    private String goods_address;
    private Integer goods_sure=0;

    public OperationGoods() {
    }

    public OperationGoods(Integer id, Integer car_id, Integer customer_id, String goods_id, String goods_name, String goods_tel, String goods_address, Integer goods_sure) {
        this.id = id;
        this.car_id = car_id;
        this.customer_id = customer_id;
        this.goods_id = goods_id;
        this.goods_name = goods_name;
        this.goods_tel = goods_tel;
        this.goods_address = goods_address;
        this.goods_sure = goods_sure;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCar_id() {
        return car_id;
    }

    public void setCar_id(Integer car_id) {
        this.car_id = car_id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_tel() {
        return goods_tel;
    }

    public void setGoods_tel(String goods_tel) {
        this.goods_tel = goods_tel;
    }

    public String getGoods_address() {
        return goods_address;
    }

    public void setGoods_address(String goods_address) {
        this.goods_address = goods_address;
    }

    public Integer getGoods_sure() {
        return goods_sure;
    }

    public void setGoods_sure(Integer goods_sure) {
        this.goods_sure = goods_sure;
    }

    @Override
    public String toString() {
        return "OperationGoods{" +
                "id=" + id +
                ", car_id=" + car_id +
                ", customer_id=" + customer_id +
                ", goods_id='" + goods_id + '\'' +
                ", goods_name='" + goods_name + '\'' +
                ", goods_tel='" + goods_tel + '\'' +
                ", goods_address='" + goods_address + '\'' +
                ", goods_sure=" + goods_sure +
                '}';
    }
}
