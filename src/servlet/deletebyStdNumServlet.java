package servlet;

import execute.Admoperate;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class deletebyStdNumServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Admoperate admoperate=new Admoperate();
        int result=0;
        Integer stdNum=null;
        PrintWriter out=null;
        response.setContentType("text/html;charset=UTF-8");

        //获取要删除学生的学号
        stdNum=Integer.parseInt(request.getParameter("stdNum"));

        //调用deletebyStdNum方法进行处理
        result=admoperate.deletebyStdNum(stdNum);

        //将结果写入response
        out=response.getWriter();

        if(result!=0){
            out.print("<font style='font-size:40'>删除成功</font>");
        }else{
            out.print("<font style='font-size:40'>学生信息删除失败</font>");
        }
    }
}
