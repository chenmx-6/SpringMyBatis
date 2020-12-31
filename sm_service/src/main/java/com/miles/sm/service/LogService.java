package com.miles.sm.service;

import com.miles.sm.entity.Log;

import java.util.List;

/**
 * @author Miles
 * @date 2020/12/30 17:45
 */
public interface LogService {
    void addSystemLog(Log log);
    void addLoginLog(Log log);
    void addOperationLog(Log log);

    List<Log> getSystemLog();
    List<Log> getLoginLog();
    List<Log> getOperationLog();
}
