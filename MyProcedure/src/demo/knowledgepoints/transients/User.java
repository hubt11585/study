package demo.knowledgepoints.transients;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 8294180014912103005L;

    private String username;

    /**
     * passwd字段加上了transient关键字，我们就可以看到效果
     */
    private transient String passwd;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}
