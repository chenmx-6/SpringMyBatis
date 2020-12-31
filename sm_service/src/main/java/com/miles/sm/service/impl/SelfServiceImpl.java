package com.miles.sm.service.impl;

import com.miles.sm.dao.SelfDao;
import com.miles.sm.dao.StaffDao;
import com.miles.sm.entity.Staff;
import com.miles.sm.service.SelfService;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Miles
 * @date 2020/12/30 10:38
 */
@Service("selfService")
public class SelfServiceImpl implements SelfService {
    @Autowired
    private SelfDao selfDao;
    @Autowired
    private StaffDao staffDao;
    public Staff login(String account, String password) {
        Staff staff = selfDao.selectByAccount(account);
        System.out.println(staff);
        if (staff!=null&&staff.getPassword().equals(password))return staff;
        return null;
    }

    public void changePassword(Integer id, String password) {
        Staff staff = staffDao.selectById(id);
        staff.setPassword(password);
        staffDao.update(staff);
    }
}
