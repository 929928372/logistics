package edu.scau.software.bean;

public class Customer {
    private Integer customer_id=null;
    private String customer_user;
    private String customer_tel;
    private String customer_address;
    private String customer_password;

    public Customer() {
    }

    public Customer(Integer customer_id, String customer_user, String customer_tel, String customer_address, String customer_password) {
        this.customer_id = customer_id;
        this.customer_user = customer_user;
        this.customer_tel = customer_tel;
        this.customer_address = customer_address;
        this.customer_password = customer_password;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_user() {
        return customer_user;
    }

    public void setCustomer_user(String customer_user) {
        this.customer_user = customer_user;
    }

    public String getCustomer_tel() {
        return customer_tel;
    }

    public void setCustomer_tel(String customer_tel) {
        this.customer_tel = customer_tel;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomer_password() {
        return customer_password;
    }

    public void setCustomer_password(String customer_password) {
        this.customer_password = customer_password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", customer_user='" + customer_user + '\'' +
                ", customer_tel='" + customer_tel + '\'' +
                ", customer_address='" + customer_address + '\'' +
                ", customer_password='" + customer_password + '\'' +
                '}';
    }
}
