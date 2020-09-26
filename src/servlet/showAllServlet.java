package servlet;

import execute.Admoperate;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import user.Student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class showAllServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        //调用showall方法进行处理
        Admoperate admoperate=new Admoperate();
        ArrayList<Student> stdList=admoperate.showall();

        //展示结果
        out.print("<table border=\"2\" align=\"center\">" +
                "    <tr>" +
                "        <td>学号</td>" +
                "        <td>学生姓名</td>" +
                "        <td>密码</td>" +
                "        <td>数学成绩</td>" +
                "        <td>java成绩</td>" +
                "        <td>简介</td>" +
                "    </tr>");
        for(Student student:stdList){
            out.print("<tr>" +
                    "<td>"+student.getStdNum()+"</td>" +
                    "<td>"+student.getStdName()+"</td>" +
                    "<td>********</td>" +
                    "<td>"+student.getMathGrade()+"</td>" +
                    "<td>"+student.getJavaGrade()+"</td>" +
                    "<td>"+student.getStdinfo()+"</td>" +
                    "</tr>");
        }

        out.print("</table>");

    }
}

