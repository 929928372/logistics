package edu.scau.software.dao.Impl;

import edu.scau.software.bean.Admin;
import edu.scau.software.bean.Customer;
import edu.scau.software.dao.Interface.AdminDao;

import java.util.List;

public class AdminDaoImpl extends BaseDao implements AdminDao {
    @Override
    public int addAdmin(Admin admin) {
        if (admin == null) {
            System.out.println("出现空值");
            return -1;
        }
        String sql = "insert into t_admin values(?,?,?)";
        return update(sql, admin.getId(), admin.getAdmin_user(), admin.getAdmin_password());
    }

    @Override
    public int deleteAdminById(Integer id) {
        if (id == null) {
            System.out.println("出现空值");
            return -1;
        }
        String sql = "delete from t_admin where id=?";
        return update(sql, id);
    }

    @Override
    public int updateAdmin(Admin admin) {
        if (admin == null) {
            System.out.println("出现空值");
            return -1;
        }
        String sql = "update t_admin set admin_user=?,admin_password=? where id=?";
        return update(sql, admin.getAdmin_user(), admin.getAdmin_password(), admin.getId());
    }

    @Override
    public List<Admin> queryAdmins() {
        String sql = "select * from t_admin";
        return queryForList(Admin.class, sql);
    }

    @Override
    public Admin queryAdminById(Integer id) {
        if (id == null) {
            System.out.println("出现空值");
            return null;
        }
        String sql = "select * from t_admin where id=?";
        return queryForOne(Admin.class, sql, id);
    }

    @Override
    public Admin queryAdminByUsernameAndPassword(String admin_user, String admin_password) {
        if (admin_user == null || admin_password == null) {
            System.out.println("出现空值");
            return null;
        }
        String sql = "select * from t_admin where admin_user=? and admin_password=?";
        return queryForOne(Admin.class, sql, admin_user, admin_password);
    }
}
