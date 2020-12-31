package com.miles.sm.dao;

import com.miles.sm.entity.Department;
import com.miles.sm.entity.Staff;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Miles
 * @date 2020/12/29 11:43
 */
@Repository("staffDao")
public interface StaffDao {

    @Insert("insert into staff(account,password,status,did,name,sex,id_number,work_time,leave_time,born_date,info) values(#{account},#{password},#{status},#{did},#{name},#{sex},#{idNumber},#{workTime},#{leaveTime},#{bornDate},#{info})")
    void insert(Staff staff);

    @Delete("delete from staff where id=#{id}")
    void delete(Integer id);

    @Update(" update staff set account=#{account},password=#{password},status=#{status}, did=#{did},name=#{name},sex=#{sex},id_number=#{idNumber},work_time=#{workTime},leave_time=#{leaveTime},born_date=#{bornDate},info=#{info} where id=#{id}")
    void update(Staff staff);
    @Results(
            id = "staffDepartment",
            value = {
                    @Result(column = "id", property = "id", id = true),
                    @Result(column = "account", property = "account"),
                    @Result(column = "password", property = "password"),
                    @Result(column = "status", property = "status"),
                    @Result(column = "did", property = "did"),
                    @Result(column = "name", property = "name"),
                    @Result(column = "sex", property = "sex"),
                    @Result(column = "id_number", property = "idNumber"),
                    @Result(column = "work_time", property = "workTime"),
                    @Result(column = "leave_time", property = "leaveTime"),
                    @Result(column = "born_date", property = "bornDate"),
                    @Result(column = "info", property = "info"),
                    @Result(column = "did", property = "department",one = @One(select = "com.miles.sm.dao.DepartmentDao.selectById",fetchType = FetchType.DEFAULT)),
            }
    )
    @Select("select * from staff where id=#{id}")
    Staff selectById(Integer id);

    @ResultMap(value = "staffDepartment")
    @Select("select * from staff")
    List<Staff> selectAll();
}
