package com.miles.sm.service.impl;

import com.miles.sm.dao.StaffDao;
import com.miles.sm.entity.Department;
import com.miles.sm.entity.Staff;
import com.miles.sm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Miles
 * @date 2020/12/29 14:29
 */
@Service("staffService")
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;
    public void add(Staff staff) {
        staff.setPassword("123456");
        staff.setWorkTime(new Date());
        staff.setStatus("正常");
        staffDao.insert(staff);
    }

    public void remove(Integer id) {
        staffDao.delete(id);
    }

    public void edit(Staff staff) {
        staffDao.update(staff);
    }

    public Staff get(Integer id) {
        Staff staff = staffDao.selectById(id);
        return staff;
    }

    public List<Staff> getAll() {
        List<Staff> staffs = staffDao.selectAll();
        return staffs;
    }
}
