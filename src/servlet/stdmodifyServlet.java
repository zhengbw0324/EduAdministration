package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import execute.Stdoperate;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class stdmodifyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer stdNum;
        String newpassword;
        String password;
        Stdoperate operate=new Stdoperate();
        int result=0;
        PrintWriter out=null;
        response.setContentType("text/html;charset=UTF-8");

        //获取请求参数
        stdNum=Integer.parseInt(request.getParameter("stdNum"));
        password=request.getParameter("password");
        newpassword=request.getParameter("newpassword");

        //调用add方法进行处理
        result=operate.stdmodify(stdNum,password,newpassword);

        //将结果写入response
        out=response.getWriter();
        if(result!=0){
            out.print("<font style='font-size:40'>修改成功</font>");
        }else{
            out.print("<font style='font-size:40'>修改失败</font>");
        }

    }
}
