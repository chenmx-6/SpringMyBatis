package com.miles.sm.dao;

import com.miles.sm.entity.Department;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Miles
 * @date 2020/12/27 13:41
 */
@Repository("departmentDao")
public interface DepartmentDao {
    @Insert("insert into department(name,address) values(#{name},#{address})")
    void insert(Department department);

    @Delete("delete from department where id=#{id}")
    void delete(Integer id);

    @Update("update department set name=#{name},address=#{address} where id=#{id}")
    void update(Department department);

    @Select("select * from department where id=#{id}")
    Department selectById(Integer id);

    @Select("select * from department")
    List<Department> selectAll();
}
