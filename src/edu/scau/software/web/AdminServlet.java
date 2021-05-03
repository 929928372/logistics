package edu.scau.software.web;

import com.google.gson.Gson;
import edu.scau.software.bean.*;
import edu.scau.software.service.Impl.AdminServiceImpl;
import edu.scau.software.service.Interface.AdminService;
import edu.scau.software.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(name = "AdminServlet", urlPatterns = "/adminServlet")
public class AdminServlet extends BaseServlet {
    private AdminService adminService = new AdminServiceImpl();

    //    登录
    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String username = WebUtils.toUTF8(req.getParameter("username"));
        String password = req.getParameter("password");

        req.getSession().setAttribute("adminName", username);

        Admin admin = adminService.login(new Admin(null, username, password));
        System.out.println(admin);

        if (admin != null) {
            System.out.println("登陆成功");
            req.getSession().setAttribute("admin", admin);
//            req.getRequestDispatcher("/adminServlet?action=queryGoods").forward(req, resp);
            resp.sendRedirect(req.getContextPath() + "/adminServlet?action=queryGoods");
        } else {
            System.out.println("用户名或密码不存在");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }

    //    注销
    public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("注销");
        req.getSession().invalidate();
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    // Ajax修改管理员密码
    public void updatePassword(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String new_password = req.getParameter("newPassword");
        System.out.println(new_password);
        Admin admin = (Admin) req.getSession().getAttribute("admin");
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", WebUtils.toISO("密码修改成功！"));

        Gson gson = new Gson();
        String json = gson.toJson(map);

        admin.setAdmin_password(new_password);

        adminService.updatePassword(admin);
        resp.getWriter().write(json);

        //resp.sendRedirect(req.getContextPath() + "/adminServlet?action=queryGoods");
    }


    //    -------------------固定客户管理-------------------
    // 固定客户查询
    public void queryCustomers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
//        List<Customer> customers = adminService.queryCustomers();
        Page<Customer> customerPage = adminService.getCustomerPage(pageNo, pageSize);

        req.setAttribute("page", customerPage);
        req.getRequestDispatcher("/pages/admin/admin.jsp").forward(req, resp);
    }

    // 固定客户删除
    public void deleteCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        adminService.deleteCustomerByUsername(username);
        resp.sendRedirect(req.getContextPath() + "/");
    }

    // 固定客户添加(未实现)
    public void addCustomer(HttpServletRequest req, HttpServletResponse resp) {

    }

    // 固定客户修改(未实现)
    public void updateCustomer(HttpServletRequest req, HttpServletResponse resp) {

    }


    //    ------------------- 发货单管理 -------------------
    // 查询所有发货单
    public void queryGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), 2);
        req.getSession().setAttribute("pageSize", pageSize);
        req.getSession().removeAttribute("cars");

        // 不属于关键词查询的情况时删除关键词
        if (req.getParameter("search") == null)
            req.getSession().removeAttribute("keyWord");

        Page<OperationGoods> goodsPage = null;
        if (req.getAttribute("page") == null) {
            goodsPage = adminService.getGoodsPage(pageNo, pageSize);
            goodsPage.setUrl(req.getContextPath() + "/adminServlet?action=queryGoods");
        } else {
            goodsPage = (Page<OperationGoods>) req.getAttribute("page");
        }
//        System.out.println(goodsPage);

        // 加工发货单需要显示的信息(优化:可分离出来)
        List<OperationGoods> items = goodsPage.getItems();
        List<Car> cars = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();
        List<Carlog> carlogs = new ArrayList<>();
        System.out.println(goodsPage);

        if (items != null) {
            for (OperationGoods item : items) {
                cars.add(adminService.queryCarById(item.getCar_id()));

                carlogs.add(adminService.queryCarLogByGoods_id(item.getGoods_id()));

                customers.add(adminService.queryCustomerById(item.getCustomer_id()));
            }
        }


        req.setAttribute("page", goodsPage);
//        System.out.println("page长度" + goodsPage.getItems().size());
        req.setAttribute("cars", cars);
        req.setAttribute("carlogs", carlogs);
        req.setAttribute("customers", customers);
        req.getRequestDispatcher("/pages/admin/query.jsp").forward(req, resp);
    }

    // 发货单删除
    public void deleteGoods(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String goods_id = req.getParameter("goods_id");

        adminService.deleteGoodByGoods_id(goods_id);
        adminService.deleteCarlogByGoods_id(goods_id);

        resp.sendRedirect(req.getContextPath() + "/adminServlet?action=queryGoods");
    }

    //  查询未填写的发货单(管理员登录后显示)
    public void queryForUndoGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("查询未发货的发货单");
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), 2);

        Page<OperationGoods> undoGoodsPage = adminService.getUndoGoodsPage(pageNo, pageSize);
        undoGoodsPage.setUrl(req.getContextPath() + "/adminServlet?action=queryForUndoGoods");
        System.out.println(undoGoodsPage);
        req.setAttribute("page", undoGoodsPage);

        req.getRequestDispatcher("/adminServlet?action=queryGoods&pageSize=" + pageSize).forward(req, resp);
    }

    // 获取新增的发货单
    public void getNewGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("goods_id"));
        if (req.getParameter("goods_id") != null) {
            req.getSession().setAttribute("goods_id", req.getParameter("goods_id"));
        } else {
            if (req.getSession().getAttribute("goods_id") == null ||
                    adminService.queryGoodByGoods_id((String) req.getSession().getAttribute("goods_id")) != null)
                req.getSession().setAttribute("goods_id", WebUtils.getRandomString(15));
            // 获取新的发货单编号
        }
        req.getRequestDispatcher("/pages/admin/add_form.jsp").forward(req, resp);
    }

    // Ajax动态获取合适的车辆
    public void updateCars(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----------------------获取合适车辆------------------------");
        String username = req.getParameter("customer_user");
        String recAddr = req.getParameter("goods_address");
        System.out.println(username);
        System.out.println(recAddr);

        String userAddr = adminService.queryCustomer_addressByUsername(username);

        List<Car> cars = adminService.queryAdaptCars(userAddr, recAddr);
        System.out.println(cars);

        for (Car car : cars) {
            car.setCar_number(WebUtils.toISO(car.getCar_number()));
        }
//        req.getSession().setAttribute("cars", cars);

        Gson gson = new Gson();
        resp.getWriter().write(gson.toJson(cars));
//        req.getRequestDispatcher("/pages/admin/add_form.jsp").forward(req, resp);
    }

    // 处理新的发货单
    public void dealNewGood(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        OperationGoods good = WebUtils.copyParamToBean(req.getParameterMap(), new OperationGoods());
        // 设置收货人姓名
        good.setGoods_name(WebUtils.toUTF8(req.getParameter("goods_name")));
        // 设置收货地址
        good.setGoods_address(WebUtils.toUTF8(req.getParameter("goods_address")));

        // 设置发货单号
        String goods_id = (String) req.getSession().getAttribute("goods_id");
        good.setGoods_id(goods_id);

        // 获取用户id
        String username = req.getParameter("customer_user");
        Customer customer = adminService.queryCustomerByUsername(username);
        Integer customer_id = customer.getCustomer_id();

        // 获取car_id
        String car_number = WebUtils.toUTF8(req.getParameter("car_number"));
        Car car = adminService.queryCarByCar_number(car_number);
        Integer car_id = car.getId();

        good.setCustomer_id(customer_id);
        good.setCar_id(car_id);
//        System.out.println(good);

        Carlog carlog = WebUtils.copyParamToBean(req.getParameterMap(), new Carlog());
        carlog.setDescriber(WebUtils.toUTF8(req.getParameter("describer")));
        carlog.setGood_id((String) req.getSession().getAttribute("goods_id"));
        carlog.setCar_id(car_id);

        if (req.getParameter("startTime").equals("")) {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String startTime = sdf.format(date);
            carlog.setStartTime(startTime);
        }

//        System.out.println(carlog);
        req.getSession().removeAttribute("goods_id");
        req.getSession().removeAttribute("cars");

        // 未设置事务的操作
        adminService.deleteGoodByGoods_id(goods_id);
        adminService.deleteCarlogByGoods_id(goods_id);
        adminService.addCarlog(carlog);
        adminService.addGood(good);

        int goodsCount = adminService.queryGoodsCount();
        int pageSize = (int) req.getSession().getAttribute("pageSize");
        int pageNo = goodsCount / pageSize;
        if (goodsCount % pageSize > 0) {
            pageNo += 1;
        }

        req.setAttribute("page", null);
        resp.sendRedirect(req.getContextPath() + "/adminServlet?action=queryGoods&pageNo=" + pageNo);
    }

    // 获取未处理发货单界面
    public void getUndoGoods(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String goods_id = req.getParameter("goods_id");
//        req.getSession().setAttribute("goods_id", goods_id);

        OperationGoods good = adminService.queryGoodByGoods_id(goods_id);
        Carlog carlog = adminService.queryCarLogByGoods_id(goods_id);

        String goods_name = good.getGoods_name();
        String goods_tel = good.getGoods_tel();
        String goods_address = good.getGoods_address();
        Integer customer_id = good.getCustomer_id();

        Customer customer = adminService.queryCustomerById(customer_id);
        String customer_user = customer.getCustomer_user();
        String customer_address = customer.getCustomer_address();
        List<Car> cars = adminService.queryAdaptCars(customer_address, goods_address);

        String describer = carlog.getDescriber();

        req.getSession().setAttribute("cars", cars);

        String url = req.getContextPath() + "/adminServlet?action=getNewGoods&goods_name=" + WebUtils.toISO(goods_name) +
                "&goods_tel=" + goods_tel + "&goods_address=" + WebUtils.toISO(goods_address) +
                "&customer_user=" + WebUtils.toISO(customer_user) + "&goods_id=" + goods_id +
                "&describer=" + WebUtils.toISO(describer);
//        System.out.println(url);

        resp.sendRedirect(url);
    }

    // 填写发货单(跳转到发货单填写界面，提交后转到未确认界面) 已弃用
    public void dealUndoGoods(HttpServletRequest req, HttpServletResponse resp) {
        // 获取发货单相关信息
        int customer_id = WebUtils.parseInt(req.getParameter("customer_id"), 1);
        String goods_address = req.getParameter("goods_address");

        // 获取用户信息
        Customer customer = adminService.queryCustomerById(customer_id);

        // 根据用户地址和收货人地址查询合适的车辆
        List<Car> cars = adminService.queryAdaptCars(customer.getCustomer_address(), goods_address);
        req.setAttribute("cars", cars);

        // 请求转发
        req.getRequestDispatcher("/");
    }

    // 查询未确认的发货单
    public void queryUnConfirmGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("查询未确认的页面");
        // 获取相关参数
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), 2);

        // 获取已填写的发货单页面
        Page<OperationGoods> page = adminService.queryHaveWriteGoodsPage(pageNo, pageSize);
        page.setUrl(req.getContextPath() + "/adminServlet?action=queryUnConfirmGoods");
        System.out.println(page);
        req.setAttribute("page", page);

        // 请求转发
        req.getRequestDispatcher("/adminServlet?action=queryGoods&pageSize=" + pageSize).forward(req, resp);
    }

    // 获取回执发货单确认界面
    public void getConfirmGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String goods_id = req.getParameter("goods_id");

        OperationGoods good = adminService.queryGoodByGoods_id(goods_id);

        Carlog carlog = adminService.queryCarLogByGoods_id(goods_id);

        Customer customer = new Customer();
        if (good != null) {
            customer = adminService.queryCustomerById(good.getCustomer_id());
        }

        Car car = new Car();
        if (carlog != null) {
            car = adminService.queryCarById(carlog.getCar_id());
        }

        req.setAttribute("good", good);
        req.setAttribute("carlog", carlog);
        req.setAttribute("customer", customer);
        req.setAttribute("car", car);

        req.getRequestDispatcher("/pages/admin/formConfirm.jsp").forward(req, resp);
    }

    // 回执发货单确认(跳转到发货单确认界面，提交后转到已完成界面)
    public void confirmGoods(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String goods_id = req.getParameter("goods_id");

        adminService.confirmGood(goods_id);

        System.out.println("回执发货单确认成功！！！");

        resp.sendRedirect(req.getContextPath() + "/adminServlet?action=queryGoods");
    }

    // 查询已完成的发货单
    public void queryHaveDoneGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("查询已完成的页面");
        // 获取相关参数
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), 2);

        // 获取已完成的发货单页面
        Page<OperationGoods> page = adminService.queryHaveDoneGoodsPage(pageNo, pageSize);
        page.setUrl(req.getContextPath() + "/adminServlet?action=queryHaveDoneGoods");
        System.out.println(page);
        req.setAttribute("page", page);

        // 请求转发
        req.getRequestDispatcher("/adminServlet?action=queryGoods&pageSize=" + pageSize).forward(req, resp);
    }

    // 根据关键词查询发货单
    public void queryGoodsByKeyWord(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("根据关键字查询页面");
        // 获取查询页面
        Page<OperationGoods> page = getKeyWordPage(req);

        page.setUrl(req.getContextPath() + "/adminServlet?action=queryGoodsByKeyWord");
        System.out.println(page);
        req.setAttribute("page", page);

        req.getRequestDispatcher("/adminServlet?action=queryGoods" + "&search=" + "0").forward(req, resp);
    }

    // 根据关键词得到查询页面
    public Page<OperationGoods> getKeyWordPage(HttpServletRequest req) throws UnsupportedEncodingException {
        String keyWord = WebUtils.toUTF8(req.getParameter("keyWord"));
        Page<OperationGoods> page = new Page<>();

        System.out.println("查询的关键词：" + keyWord);

        // 保存关键词
        if (keyWord != null)
            req.getSession().setAttribute("keyWord", keyWord);
        else
            keyWord = (String) req.getSession().getAttribute("keyWord");

        // 关键词为订单编号
        OperationGoods good = adminService.queryGoodByGoods_id(keyWord);
        if (good != null) {
            List<OperationGoods> goods = new ArrayList<>();
            goods.add(good);
            page.setItems(goods);
            return page;
        }

        // 关键词为用户名
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), 2);
        Customer customer = adminService.queryCustomerByUsername(keyWord);
        if (customer != null)
            page = adminService.queryGoodsPageByCustomer_id(customer.getCustomer_id(), pageNo, pageSize);

        return page;
    }

    // 模糊查询
    public void fuzzyQuery(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println(" 》》》模糊搜索中 》》》");
        String queryWord = req.getParameter("queryWord");
        System.out.println("搜索关键词： " + queryWord);

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        if (!queryWord.trim().isEmpty()) {
            list = searchAll();     // 前端匹配
//            list = searchMatch(queryWord);    // 后端匹配
        }
        System.out.println("搜索结果：" + list);

        map.put("name", list);

        Gson gson = new Gson();
        resp.getWriter().write(gson.toJson(map));
    }

    // 模糊查询中获取所有项(返回所有结果，采用前端匹配)
    public ArrayList<String> searchAll() throws UnsupportedEncodingException {
        // 查询发货单号
        List<OperationGoods> goods = adminService.queryGoods();
        // 查询用户名
        List<Customer> customers = adminService.queryCustomers();

        ArrayList<String> arrayList = new ArrayList<>();

        for (OperationGoods good : goods) {
            arrayList.add("good" + good.getGoods_id());
        }

        for (Customer customer : customers) {
            arrayList.add("user" + WebUtils.toISO(customer.getCustomer_user()));
        }
        return arrayList;
    }

    // 模糊查询中获取匹配项(返回匹配结果，采用后端匹配)
    public ArrayList<String> searchMatch(String queryWord) {
        // 查询发货单号
        List<OperationGoods> goods = adminService.queryGoodsByQueryWord(queryWord);
        // 查询用户名
        List<Customer> customers = adminService.queryCustomersByQueryWord(queryWord);

        ArrayList<String> arrayList = new ArrayList<>();

        for (OperationGoods good : goods) {
            arrayList.add("good" + good.getGoods_id());
        }

        for (Customer customer : customers) {
            arrayList.add("user" + customer.getCustomer_user());
        }
        return arrayList;
    }


    //    -------------------车源信息管理-------------------
    // 车源的查询
    public void queryCars(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("查询车辆");
        // 获取相关参数
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), 3);
        req.getSession().setAttribute("carPageSize", pageSize);

        // 获取车源页面
        Page<Car> page = adminService.queryCarsPage(pageNo, pageSize);

        page.setUrl(req.getContextPath() + "/adminServlet?action=queryCars");
        System.out.println(page);
        req.setAttribute("page", page);

        // 请求转发
        req.getRequestDispatcher("/pages/admin/queryCar.jsp").forward(req, resp);
    }

    // 车源的删除
    public void deleteCar(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 1);

        adminService.deleteCarById(id);

        resp.sendRedirect(req.getContextPath() + "/adminServlet?action=queryCars");
    }

    // 获取修改车源的界面
    public void getUpdateCar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 1);

        Car car = adminService.queryCarById(id);
        System.out.println(car);
        req.setAttribute("car", car);
        req.setAttribute("id", id);

        req.getRequestDispatcher("/pages/admin/updateCar.jsp").forward(req, resp);
    }

    // 车源的修改
    public void updateCar(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Car car = WebUtils.copyParamToBean(req.getParameterMap(), new Car());
        String username = WebUtils.toUTF8(req.getParameter("username"));
        String car_number = WebUtils.toUTF8(req.getParameter("car_number"));
        String address = WebUtils.toUTF8(req.getParameter("address"));
        String car_road = WebUtils.toUTF8(req.getParameter("car_road"));
        String car_content = WebUtils.toUTF8(req.getParameter("car_content"));

        car.setUsername(username);
        car.setCar_number(car_number);
        car.setAddress(address);
        car.setCar_road(car_road);
        car.setCar_content(car_content);

        adminService.updateCar(car);

        resp.sendRedirect(req.getContextPath() + "/adminServlet?action=queryCars");
    }

    // 车源的添加
    public void addCar(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("添加车源");
        Car car = WebUtils.copyParamToBean(req.getParameterMap(), new Car());
        String username = WebUtils.toUTF8(req.getParameter("username"));
        String car_number = WebUtils.toUTF8(req.getParameter("car_number"));
        String address = WebUtils.toUTF8(req.getParameter("address"));
        String car_road = WebUtils.toUTF8(req.getParameter("car_road"));
        String car_content = WebUtils.toUTF8(req.getParameter("car_content"));

        car.setUsername(username);
        car.setCar_number(car_number);
        car.setAddress(address);
        car.setCar_road(car_road);
        car.setCar_content(car_content);

        System.out.println(car);

        adminService.addCar(car);
        int pageNo = 1;
        int count = adminService.queryCarCount();
        int pageSize = (int) req.getSession().getAttribute("carPageSize");
        pageNo = count / pageSize;
        if (count % pageSize > 0) {
            pageNo += 1;
        }

        resp.sendRedirect(req.getContextPath() + "/adminServlet?action=queryCars&pageNo=" + pageNo);
    }
}
