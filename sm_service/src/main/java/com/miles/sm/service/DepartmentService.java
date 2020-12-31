package com.miles.sm.service;

import com.miles.sm.entity.Department;

import java.util.List;

/**
 * @author Miles
 * @date 2020/12/27 13:55
 */
public interface DepartmentService {
    void add(Department department);
    void remove(Integer id);
    void edit(Department department);
    Department get(Integer id);
    List<Department> getAll();

}
