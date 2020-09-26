package servlet;

import execute.Admoperate;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import user.Student;

import java.io.IOException;
import java.io.PrintWriter;

public class findbyStdNumServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Admoperate admoperate=new Admoperate();
        Student student=null;
        Integer stdNum=null;
        PrintWriter out=null;
        response.setContentType("text/html;charset=UTF-8");

        //获取要删除学生的学号
        stdNum=Integer.parseInt(request.getParameter("stdNum"));

        //调用findbyStdNum方法进行处理
        student=admoperate.findbyStdNum(stdNum);

        //将结果写入response
        out=response.getWriter();

        out.print("<table border=2 align=center>" +
                "<tr>" +
                "<td>学号</td>" +
                "<td>学生姓名</td>" +
                "<td>密码</td>" +
                "<td>数学成绩</td>" +
                "<td>java成绩</td>" +
                "<td>简介</td>" +
                "</tr>"+
                "<tr>" +
                "<td>"+student.getStdNum()+"</td>" +
                "<td>"+student.getStdName()+"</td>" +
                "<td>********</td>" +
                "<td>"+student.getMathGrade()+"</td>" +
                "<td>"+student.getJavaGrade()+"</td>" +
                "<td>"+student.getStdinfo()+"</td>" +
                "</tr>");
        out.print("</table>");

    }
}

