package servlet;

import execute.Admoperate;
import execute.Stdoperate;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class admAddServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer admNum;
        String admName;
        String admpassword;
        Admoperate admoperate=new Admoperate();
        int result=0;
        PrintWriter out=null;
        response.setContentType("text/html;charset=UTF-8");

        //获取请求参数
        admNum=Integer.parseInt(request.getParameter("admNum"));
        admName=request.getParameter("admName");
        admpassword=request.getParameter("admpassword");

        //调用add方法进行处理
        result=admoperate.admadd(admNum,admName,admpassword);

        //将结果写入response
        out=response.getWriter();
        if(result!=0){
            out.print("<font style='font-size:40'>注册成功</font>");
        }else{
            out.print("<font style='font-size:40'>注册失败</font>");
        }
    }
}
