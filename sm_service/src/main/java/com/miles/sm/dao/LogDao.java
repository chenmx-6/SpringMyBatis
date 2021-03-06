package com.miles.sm.dao;

import com.miles.sm.entity.Log;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Miles
 * @date 2020/12/30 17:36
 */
@Repository("logDao")
public interface LogDao {
    @Insert("insert into log values(#{oprTime},#{type},#{operator},#{moudle},#{operation},#{result})")
    void insert(Log log);
    @Results(
            value = {
                    @Result(column = "opr_time",property = "oprTime"),
                    @Result(column="type",property = "type"),
                    @Result(column="operator",property = "operator"),
                    @Result(column="moudle",property = "moudle"),
                    @Result(column="operation",property = "operation"),
                    @Result(column="result",property = "result")
            }
    )
    @Select("select * from log where type=#{type} order by opr_time desc")
    List<Log> selectByType(String type);
}
