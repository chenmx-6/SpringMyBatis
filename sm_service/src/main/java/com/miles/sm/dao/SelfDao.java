package com.miles.sm.dao;

import com.miles.sm.entity.Staff;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

/**
 * @author Miles
 * @date 2020/12/30 10:30
 */
@Repository("selfDao")
public interface SelfDao {
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
    @Select("select * from staff where account=#{account}")
    Staff selectByAccount(String Account);
}
