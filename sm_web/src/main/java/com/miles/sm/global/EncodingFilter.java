package com.miles.sm.global;

import javax.servlet.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.LogRecord;

/**
 * @author Miles
 * @date 2020/12/26 22:55
 */
public class EncodingFilter implements Filter {

    private String encoding="UTF-8";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        if (filterConfig.getInitParameter("ENCODING")!=null)
            encoding=filterConfig.getInitParameter("ENCODING");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(encoding);
        servletResponse.setCharacterEncoding(encoding);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        encoding=null;
    }
}
