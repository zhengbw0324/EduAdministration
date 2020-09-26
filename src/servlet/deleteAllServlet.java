package servlet;

import execute.Admoperate;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class deleteAllServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Admoperate admoperate=new Admoperate();
        int result=100;
        PrintWriter out=null;
        response.setContentType("text/html;charset=UTF-8");

        //调用add方法进行处理
        result=admoperate.deleteall();

        //将结果写入response
        out=response.getWriter();
        if(result==0){
            out.print("<font style='font-size:40'>学生信息删除成功</font>");
        }else{
            out.print("<font style='font-size:40'>学生信息删除失败</font>");
        }

    }

}

