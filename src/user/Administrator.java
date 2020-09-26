package user;
//管理员类
public class Administrator {
    private Integer Id;
    private String Name;
    private String password;

    public Administrator() {
    }

    public Administrator( Integer id, String name, String password) {
        Id = id;
        Name = name;
        this.password = password;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
