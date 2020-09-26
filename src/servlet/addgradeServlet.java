package servlet;

import execute.Admoperate;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import user.Student;

import java.io.IOException;
import java.io.PrintWriter;

public class addgradeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer stdNum;
        Double mathGrade;
        Double javaGrade;
        String stdinfo;
        Admoperate admoperate=new Admoperate();
        int result=0;
        PrintWriter out=null;
        response.setContentType("text/html;charset=UTF-8");

        //获取请求参数
        stdNum=Integer.parseInt(request.getParameter("stdNum"));
        mathGrade=Double.parseDouble(request.getParameter("mathGrade"));
        javaGrade=Double.parseDouble(request.getParameter("javaGrade"));
        stdinfo=request.getParameter("stdInfo");

        //调用addgrade方法进行处理
        result=admoperate.addgrade(stdNum,mathGrade,javaGrade,stdinfo);

        //将结果写入response
        out=response.getWriter();
        if(result!=0){
            out.print("<font style='font-size:40'>学生成绩添加成功</font>");
        }else{
            out.print("<font style='font-size:40'>学生成绩添加失败</font>");
        }

    }
}
