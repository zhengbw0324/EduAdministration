package execute;

import user.Student;
import util.JDBCutil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Admoperate {
    private JDBCutil jdbcutil = new JDBCutil();


    //管理员登录
    public boolean admlogin(Integer admNum,String admpassword) {
        String sql = "select * from admdata where admNum=? and admpassword=?";
        PreparedStatement preparedStatement = jdbcutil.getPs(sql);
        ResultSet rs=null;
        try {
            preparedStatement.setInt(1,admNum);
            preparedStatement.setString(2,admpassword);
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


    //管理员添加学生成绩
    public int addgrade(Integer stdNum,Double mathGrade,Double javaGrade,String stdInfo) {
        int result = 0;
        String sql = "UPDATE stddata " +
                "SET mathGrade = ?, javaGrade = ?, stdInfo = ? " +
                "WHERE stdNum = ?";
        PreparedStatement preparedStatement = jdbcutil.getPs(sql);
        try {
            preparedStatement.setDouble(1,mathGrade);
            preparedStatement.setDouble(2,javaGrade);
            preparedStatement.setString(3,stdInfo);
            preparedStatement.setInt(4,stdNum);
            result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            jdbcutil.close();
        }
        return result;
    }


    //管理员查询全部学生信息
    public ArrayList showall() {
        String sql = "select * from stddata";
        PreparedStatement preparedStatement = jdbcutil.getPs(sql);
        ResultSet rs = null;
        ArrayList stdList = new ArrayList<Student>();
        try {
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer stdNum = rs.getInt("stdNum");
                String stdName = rs.getString("stdName");
                String password = rs.getString("password");
                Double mathGrade = rs.getDouble("mathGrade");
                Double javaGrade = rs.getDouble("javaGrade");
                String stdinfo = rs.getString("stdInfo");
                Student student = new Student(stdNum, stdName, password, mathGrade, javaGrade, stdinfo);
                stdList.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            jdbcutil.close();
        }
        return stdList;
    }

    //通过学号查询学生信息
    public Student findbyStdNum(Integer stdNum){
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


    //删除全部学生信息
    public int deleteall(){
        int result=100;
        String sql = "TRUNCATE stddata";//这个语句执行成功返回值为零！！！！
        PreparedStatement preparedStatement = jdbcutil.getPs(sql);
        try {
            result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            jdbcutil.close();
        }
        return result;
    }

    //通过学号删除信息
    public int deletebyStdNum(Integer stdNum){
        String sql = "delete from stddata where stdNum=?";
        PreparedStatement preparedStatement = jdbcutil.getPs(sql);
        int result=0;

        try {
            preparedStatement.setInt(1,stdNum);
            result=preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            jdbcutil.close();
        }
        return result;
    }

    //管理员注册
    public int admadd(Integer admNum,String admName,String admpassword){
        int result = 0;
        String sql = "insert into admdata(admNum,admName,admpassword)" +
                "values(?,?,?)";
        PreparedStatement preparedStatement = jdbcutil.getPs(sql);
        try {
            preparedStatement.setInt(1,admNum);
            preparedStatement.setString(2,admName);
            preparedStatement.setString(3,admpassword);
            result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            jdbcutil.close();
        }
        return result;
    }
}
