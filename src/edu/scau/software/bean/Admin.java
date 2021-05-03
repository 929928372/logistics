package edu.scau.software.bean;

public class Admin {
    private Integer id = null;
    private String admin_user;
    private String admin_password;

    public Admin() {
    }

    public Admin(String admin_user, String admin_password) {
        this.admin_user = admin_user;
        this.admin_password = admin_password;
    }

    public Admin(Integer id, String admin_user, String admin_password) {
        this.id = id;
        this.admin_user = admin_user;
        this.admin_password = admin_password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdmin_user() {
        return admin_user;
    }

    public void setAdmin_user(String admin_user) {
        this.admin_user = admin_user;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    @Override
    public String toString() {
        return "admin{" +
                "id=" + id +
                ", admin_user='" + admin_user + '\'' +
                ", admin_password='" + admin_password + '\'' +
                '}';
    }
}
