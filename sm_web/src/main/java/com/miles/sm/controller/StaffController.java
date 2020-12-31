package com.miles.sm.controller;

import com.miles.sm.entity.Department;
import com.miles.sm.entity.Staff;
import com.miles.sm.service.DepartmentService;
import com.miles.sm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Miles
 * @date 2020/12/27 14:01
 */
@Controller("staffController")
public class StaffController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private DepartmentService departmentService;
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Staff> staffs = staffService.getAll();
        request.setAttribute("LIST",staffs);
        request.getRequestDispatcher("../staff_list.jsp").forward(request,response);
    }
    public void toAdd(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<Department> departments = departmentService.getAll();
        request.setAttribute("DLIST",departments);
        request.getRequestDispatcher("../staff_add.jsp").forward(request,response);
    }
    public void add(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String did = request.getParameter("did");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String idNumber = request.getParameter("idNumber");
        String bornDate = request.getParameter("bornDate");
        String info = request.getParameter("info");

        System.out.println("bornDate:"+bornDate);
//        System.out.println("did:"+did);
//        System.out.println("name:"+name);
//        System.out.println("sex:"+sex);
        Staff staff = new Staff();
        staff.setAccount(account);
        staff.setDid(Integer.parseInt(did));
        staff.setName(name);
        staff.setSex(sex);
        staff.setIdNumber(idNumber);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(bornDate);
            staff.setBornDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        staff.setInfo(info);

        staffService.add(staff);
        response.sendRedirect("list.do");
    }

    public void toEdit(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffService.get(id);
        request.setAttribute("stf",staff);
        List<Department> departments = departmentService.getAll();
        request.setAttribute("DLIST",departments);
        request.getRequestDispatcher("../staff_edit.jsp").forward(request,response);
    }

    public void edit(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String account = request.getParameter("account");
        String did = request.getParameter("did");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String idNumber = request.getParameter("idNumber");
        String bornDate = request.getParameter("bornDate");
        String info = request.getParameter("info");

        System.out.println("did:"+did);
        Staff staff = staffService.get(id);
        staff.setId(id);
        staff.setAccount(account);
        staff.setDid(Integer.parseInt(did));
        staff.setName(name);
        staff.setSex(sex);
        staff.setIdNumber(idNumber);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(bornDate);
            staff.setBornDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        staff.setInfo(info);
        staffService.edit(staff);
        response.sendRedirect("list.do");
    }
    public void remove(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        staffService.remove(id);
        response.sendRedirect("list.do");
    }

    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffService.get(id);
        request.setAttribute("OBJ",staff);
        request.getRequestDispatcher("../staff_detail.jsp").forward(request,response);
    }

}
