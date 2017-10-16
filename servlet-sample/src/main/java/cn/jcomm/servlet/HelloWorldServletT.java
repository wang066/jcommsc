package cn.jcomm.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jowang on 2016/12/11 0011.
 */

@WebServlet(urlPatterns = "/helloWorld.html")
public class HelloWorldServletT extends HttpServlet {

    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        PrintWriter out=resp.getWriter();
        out.print("hello servlet  cn.jcomm.servlet.HelloWorldServletT ");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);

        resp.setContentType("text/html;");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("content-type","text/html;charset=UTF-8");

        System.out.println("Servlet 执行了。");
        resp.getWriter().println("Servlet生命周期案例。<br> Servlet 执行了！");
    }

//    @Override
//    public Enumeration<String> getInitParameterNames() {
//        return super.getInitParameterNames();
//    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("Servlet 被卸载了！");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Servlet 初始化了！\t（初始化只有一次，Servlet是单例的。）ps:不信可再次访问。");
    }
}
