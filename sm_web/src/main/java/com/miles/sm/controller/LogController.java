package com.miles.sm.controller;

import com.miles.sm.entity.Log;
import com.miles.sm.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Miles
 * @date 2020/12/30 17:56
 */
@Controller("logController")
public class LogController {
    @Autowired
    private LogService logService;
    public void operationLog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Log> operationLogs = logService.getOperationLog();
        for (Log operationLog : operationLogs) {
            System.out.println(operationLog.getOprTime());
        }
        request.setAttribute("TYPE","操作");
        request.setAttribute("LIST",operationLogs);
        request.getRequestDispatcher("../log_list.jsp").forward(request,response);
    }
    public void loginLog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Log> operationLogs = logService.getLoginLog();
        request.setAttribute("TYPE","登录");
        request.setAttribute("LIST",operationLogs);
        request.getRequestDispatcher("../log_list.jsp").forward(request,response);
    }
    public void systemLog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Log> operationLogs = logService.getSystemLog();
        request.setAttribute("TYPE","系统");
        request.setAttribute("LIST",operationLogs);
        request.getRequestDispatcher("../log_list.jsp").forward(request,response);
    }

}
