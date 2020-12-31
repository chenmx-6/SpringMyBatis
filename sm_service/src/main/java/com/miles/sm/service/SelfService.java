package com.miles.sm.service;

import com.miles.sm.entity.Staff;

/**
 * @author Miles
 * @date 2020/12/30 10:36
 */
public interface SelfService {
    Staff login(String account ,String password);
    void changePassword(Integer id,String password);
}
