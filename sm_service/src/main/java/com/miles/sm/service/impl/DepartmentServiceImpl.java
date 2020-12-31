package com.miles.sm.service.impl;

import com.miles.sm.dao.DepartmentDao;
import com.miles.sm.entity.Department;
import com.miles.sm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Miles
 * @date 2020/12/27 13:57
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    public void add(Department department) {

        departmentDao.insert(department);
    }

    public void remove(Integer id) {
        departmentDao.delete(id);
    }

    public void edit(Department department) {
        departmentDao.update(department);
    }

    public Department get(Integer id) {
        Department department = departmentDao.selectById(id);
        return department;
    }

    public List<Department> getAll() {
        List<Department> departments = departmentDao.selectAll();
        return departments;
    }
}
