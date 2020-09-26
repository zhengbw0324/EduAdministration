package servlet;

import execute.Admoperate;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class admloginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer admNum;
        String admpassword;
        Admoperate admoperate=new Admoperate();
        boolean result=false;

        request.setCharacterEncoding("utf-8");
        admNum=Integer.parseInt(request.getParameter("admNum"));
        admpassword=request.getParameter("admpassword");
        result=admoperate.admlogin(admNum,admpassword);
        if(result){
            response.sendRedirect("/EduAdministration_war_exploded/admface.html");
        }else{
            response.sendRedirect("/EduAdministration_war_exploded/admlogin_error.html");
        }
    }
}

