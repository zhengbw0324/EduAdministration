package servlet;

import execute.Stdoperate;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import user.Student;

import java.io.IOException;
import java.io.PrintWriter;

public class registerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer stdNum;
        String stdName;
        String password;
        Stdoperate stdoperate=new Stdoperate();
        int result=0;
        PrintWriter out=null;
        response.setContentType("text/html;charset=UTF-8");

        //获取请求参数
        stdNum=Integer.parseInt(request.getParameter("stdNum"));
        stdName=request.getParameter("stdName");
        password=request.getParameter("password");

        //调用add方法进行处理
        result=stdoperate.register(stdNum,stdName,password);

        //将结果写入response
        out=response.getWriter();
        if(result!=0){
            out.print("<font style='font-size:40'>注册成功</font>");
        }else{
            out.print("<font style='font-size:40'>注册失败</font>");
        }

    }
}
