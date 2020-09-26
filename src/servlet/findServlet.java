package servlet;


import execute.Stdoperate;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import user.Student;

import java.io.IOException;
import java.io.PrintWriter;


public class findServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();

        //获取当前学生的学号
        HttpSession session=request.getSession();
        Integer stdNum = (Integer) session.getAttribute("stdNum");
        System.out.println();
        //调用find方法进行处理
        Stdoperate stdoperate=new Stdoperate();
        Student student=stdoperate.find(stdNum);

        //展示结果
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

