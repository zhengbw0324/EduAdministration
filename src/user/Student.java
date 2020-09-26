package user;
//学生类
public class Student {
    private Integer stdNum;
    private String stdName;
    private String password;
    private Double mathGrade;
    private Double javaGrade;
    private String stdinfo;

    public Student() {
    }

    public Student(Integer stdNum, String stdName, String password, Double mathGrade, Double javaGrade, String stdinfo) {
        this.stdNum = stdNum;
        this.stdName = stdName;
        this.password = password;
        this.mathGrade = mathGrade;
        this.javaGrade = javaGrade;
        this.stdinfo = stdinfo;
    }

    public Integer getStdNum() {
        return stdNum;
    }

    public void setStdNum(Integer stdNum) {
        this.stdNum = stdNum;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(Double mathGrade) {
        this.mathGrade = mathGrade;
    }

    public Double getJavaGrade() {
        return javaGrade;
    }

    public void setJavaGrade(Double javaGrade) {
        this.javaGrade = javaGrade;
    }

    public String getStdinfo() {
        return stdinfo;
    }

    public void setStdinfo(String stdinfo) {
        this.stdinfo = stdinfo;
    }
}
