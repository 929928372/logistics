package edu.scau.software.dao.Interface;

import edu.scau.software.bean.Admin;

import java.util.List;

public interface AdminDao {
    int addAdmin(Admin admin);

    int deleteAdminById(Integer id);

    int updateAdmin(Admin admin);

    Admin queryAdminById(Integer id);

    List<Admin> queryAdmins();

    Admin queryAdminByUsernameAndPassword(String admin_user, String admin_password);
}
