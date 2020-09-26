package servlet;

import execute.Stdoperate;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class stdloginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer stdNum;
        String password;
        Stdoperate stdoperate=new Stdoperate();
        boolean result=false;

        request.setCharacterEncoding("utf-8");
        stdNum=Integer.parseInt(request.getParameter("stdNum"));
        password=request.getParameter("password");
        result=stdoperate.stdlogin(stdNum,password);
        if(result){
            //将该学生stdNum存入session,用于查询个人信息
            HttpSession session=request.getSession();
            session.setAttribute("stdNum", stdNum);

            response.sendRedirect("/EduAdministration_war_exploded/stdface.html");
        }else{
            response.sendRedirect("/EduAdministration_war_exploded/stdlogin_error.html");
        }
    }

}
