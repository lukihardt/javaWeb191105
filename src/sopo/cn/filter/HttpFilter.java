package sopo.cn.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HttpFilter implements Filter{
    private FilterConfig filterConfig;

    public FilterConfig getFilterConfig(){
        return filterConfig;
    }

    public void destory(){
    }

    // public abstract void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException;

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // doFilter((HttpServletRequest) request, (HttpServletResponse) response, chain);
        System.out.println("doFilter方法");
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("Pragma", "no-cache");
        resp.setDateHeader("Expires", -1);
        chain.doFilter(request, resp);
    }

    public void init(FilterConfig filterConfig){
        this.filterConfig = filterConfig;
        init();
    }

    protected void init(){
    }
}
