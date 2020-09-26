package execute;

import user.Student;
import util.JDBCutil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Stdoperate {
    private JDBCutil jdbcutil = new JDBCutil();

    //学生登录
    public boolean stdlogin(Integer stdNum,String password) {
        String sql = "select * from stddata where stdNum=? and password=?";
        PreparedStatement preparedStatement = jdbcutil.getPs(sql);
        ResultSet rs=null;
        try {
            preparedStatement.setInt(1,stdNum);
            preparedStatement.setString(2,password);
            rs=preparedStatement.executeQuery();
            while (rs.next()){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbcutil.close();
        }
        return false;
    }

    //学生注册
    public int register(Integer stdNum,String stdName,String password){
        int result = 0;
        String sql = "insert into stddata(stdNum,stdName,password)" +
                "values(?,?,?)";
        PreparedStatement preparedStatement = jdbcutil.getPs(sql);
        try {
            preparedStatement.setInt(1,stdNum);
            preparedStatement.setString(2,stdName);
            preparedStatement.setString(3,password);
            result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            jdbcutil.close();
        }
        return result;
    }

    //学生密码修改
    public int stdmodify(Integer stdNum,String password,String newpassword){
        int result = 0;
        String sql = "UPDATE stddata " +
                "SET password = ?" +
                "WHERE (stdNum = ? and password=?)";
        PreparedStatement preparedStatement = jdbcutil.getPs(sql);
        try {
            preparedStatement.setString(1,newpassword);
            preparedStatement.setInt(2,stdNum);
            preparedStatement.setString(3,password);
            result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            jdbcutil.close();
        }
        return result;
    }

    //学生查找自身信息
    public Student find(Integer stdNum) {
        String sql = "select * from stddata where stdNum=?";
        PreparedStatement preparedStatement = jdbcutil.getPs(sql);
        ResultSet rs = null;
        Student student=null;

        try {
            preparedStatement.setInt(1,stdNum);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String stdName = rs.getString("stdName");
                String password = rs.getString("password");
                Double mathGrade = rs.getDouble("mathGrade");
                Double javaGrade = rs.getDouble("javaGrade");
                String stdinfo = rs.getString("stdInfo");
                student = new Student(stdNum, stdName, password, mathGrade, javaGrade, stdinfo);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            jdbcutil.close();
        }
        return student;
    }
}
