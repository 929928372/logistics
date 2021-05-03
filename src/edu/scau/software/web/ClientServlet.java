package edu.scau.software.web;

import com.google.gson.Gson;
import edu.scau.software.bean.Carlog;
import edu.scau.software.bean.Customer;
import edu.scau.software.bean.OperationGoods;
import edu.scau.software.bean.Page;
import edu.scau.software.service.Impl.AdminServiceImpl;
import edu.scau.software.service.Impl.CustomerServiceImpl;
import edu.scau.software.service.Interface.AdminService;
import edu.scau.software.service.Interface.CustomerService;
import edu.scau.software.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

@WebServlet(name = "ClientServlet", urlPatterns = "/clientServlet")
public class ClientServlet extends BaseServlet {
    private CustomerService customerService = new CustomerServiceImpl();
    private AdminService adminService = new AdminServiceImpl();

    //    登录
    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String username = WebUtils.toUTF8(req.getParameter("username"));
        String password = req.getParameter("password");
        String identity = req.getParameter("identity");

        if (identity.equals("manager")) {
            req.getRequestDispatcher("/adminServlet?action=login").forward(req, resp);
        } else {
            // 保存用户名
            req.getSession().setAttribute("clientName", username);

            Customer customer = customerService.login(new Customer(null, username, null, null, password));

            if (customer != null) {
                System.out.println("登陆成功");
                // 保存用户信息
                req.getSession().setAttribute("customer", customer);
                req.getRequestDispatcher("/pages/user/main.jsp").forward(req, resp);
//                resp.sendRedirect(req.getContextPath() + "/pages/user/main.jsp");
            } else {
                System.out.println("用户名或密码不存在");
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        }
    }

    // Ajax注册
    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取真实验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        // 立即删除，防止表单重复提交
        req.getSession().setAttribute(KAPTCHA_SESSION_KEY, null);

        // Ajax方式发送数据不存在乱码问题，因此不需要转码
        String username = req.getParameter("customer_user");
        String password = req.getParameter("customer_password");
        String tel = req.getParameter("customer_tel");
        String address = req.getParameter("customer_address");
        String code = req.getParameter("code");

        Map<String, String> map = new HashMap<>();
        if (token != null && code.equalsIgnoreCase(token)) {
            if (!customerService.existsUsername(username)) {
                System.out.println(username + password);
                customerService.register(new Customer(null, username, tel, address, password));
                req.getSession().setAttribute("customer", customerService.queryCustomerByUsername(username));
                System.out.println("注册成功");
//                resp.sendRedirect(req.getContextPath() + "/clientServlet?action=page");
                map.put("msg",req.getContextPath() + "/clientServlet?action=page");
//                req.getRequestDispatcher("clientServlet?action=page").forward(req, resp);
            }
        } else {
            System.out.println("验证码错误");

            map.put("msg", "codeError");
        }
        Gson gson = new Gson();
        resp.getWriter().write(gson.toJson(map));
    }

    // Ajax判断用户名是否可用
    public void newUsernameIsOK(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("判断用户名是否可用");
        String username = req.getParameter("username");
        boolean isOK = customerService.existsUsername(username);

        Map<String, String> map = new HashMap<>();
        if (isOK) {
            map.put("msg", WebUtils.toISO("用户名已存在"));
        } else {
            map.put("msg", "");
        }

        Gson gson = new Gson();
        String json = gson.toJson(map);
        System.out.println(json);

        resp.getWriter().write(json);
    }

    //    注销
    public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("注销");
        req.getSession().invalidate();
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    //    用户查看发货单
    public void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Customer customer = (Customer) req.getSession().getAttribute("customer");
        req.getSession().setAttribute("pageSize", pageSize);

        Page<OperationGoods> page = customerService.getPage(customer.getCustomer_id(), pageNo, pageSize);
        page.setUrl(req.getContextPath() + "/clientServlet?action=page");
        System.out.println(page);

        List<Carlog> carlogs = new ArrayList<>();

        if (page.getItems() != null) {
            for (OperationGoods item : page.getItems()) {
                String goods_id = item.getGoods_id();
                carlogs.add(customerService.queryCarlogByGoods_id(goods_id));
            }
        }

        req.setAttribute("page", page);
        req.setAttribute("carlogs", carlogs);

        req.getRequestDispatcher("/pages/user/query.jsp").forward(req, resp);
    }

    //    用户添加发货单
    public void addGood(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("用户添加发货单");
        OperationGoods good = WebUtils.copyParamToBean(req.getParameterMap(), new OperationGoods());
        String goods_name = WebUtils.toUTF8(req.getParameter("goods_name"));
        String goods_address = WebUtils.toUTF8(req.getParameter("goods_address"));
        String describer = WebUtils.toUTF8(req.getParameter("describer"));
        good.setGoods_name(goods_name);
        good.setGoods_address(goods_address);

        Customer customer = (Customer) req.getSession().getAttribute("customer");
//        System.out.println(customer);

        // 添加用户id
        good.setCustomer_id(customer.getCustomer_id());

        // 随机产生订单号
        String goods_id = WebUtils.getRandomString(15);
        good.setGoods_id(goods_id);

        Carlog carlog = new Carlog();
        carlog.setGood_id(goods_id);
        carlog.setDescriber(describer);

        System.out.println(good);

        customerService.addGood(good);
        customerService.addCarlog(carlog);

        int pageNo = 1;
        if (customer != null) {
            int count = customerService.queryGoodsCountByCustomer_id(customer.getCustomer_id());
            int pageSize = (int) req.getSession().getAttribute("pageSize");
            pageNo = count / pageSize;
            if (count % pageSize > 0) {
                pageNo += 1;
            }
        }

        resp.sendRedirect(req.getContextPath() + "/clientServlet?action=page&pageNo=" + pageNo);
    }

    //    个人信息修改
    public void updatePersonInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Customer new_customer = WebUtils.copyParamToBean(req.getParameterMap(), new Customer());
        Customer old_customer = (Customer) req.getSession().getAttribute("customer");

        new_customer.setCustomer_id(old_customer.getCustomer_id());

        customerService.updateCustomerInfo(new_customer);

        resp.sendRedirect(req.getContextPath() + "/clientServlet?action=page");
    }
}
