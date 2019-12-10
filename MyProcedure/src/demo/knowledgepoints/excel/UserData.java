package demo.knowledgepoints.excel;

public class UserData {

    public UserData(Long id, String username, String password, String phone){
        this.id = id;
        this.password = password;
        this.phone = phone;
        this.username = username;
    }
    private Long id;
    private String username;
    private String password;
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
