package com.miles.sm.service;

import com.miles.sm.entity.Department;
import com.miles.sm.entity.Staff;

import java.util.List;

/**
 * @author Miles
 * @date 2020/12/29 14:27
 */
public interface StaffService {
    void add(Staff staff);
    void remove(Integer id);
    void edit(Staff staff);
    Staff get(Integer id);
    List<Staff> getAll();
}
