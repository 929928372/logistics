package edu.scau.software.test.dao;

import edu.scau.software.bean.Admin;
import edu.scau.software.dao.Impl.AdminDaoImpl;
import edu.scau.software.dao.Interface.AdminDao;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AdminDaoImplTest {
    AdminDao adminDao=new AdminDaoImpl();
    @Test
    public void addAdmin() {
        Admin admin=new Admin("root","root");
        Admin admin2=new Admin("h111","222");
        adminDao.addAdmin(admin);
        adminDao.addAdmin(admin2);
    }

    @Test
    public void deleteAdminById() {
        Integer id=11;
        adminDao.deleteAdminById(id);
    }

    @Test
    public void updateAdmin() {
        adminDao.updateAdmin(new Admin(11,"h111","333"));
    }

    @Test
    public void queryAdmins() {
        List<Admin> admins = adminDao.queryAdmins();
        for (Admin admin : admins) {
            System.out.println(admin);
        }
    }

    @Test
    public void queryAdminById() {
        Admin admin = adminDao.queryAdminById(11);
        System.out.println(admin);
    }
}