package demo.knowledgepoints.section.imp;

import demo.knowledgepoints.section.inf.UserBean;

public class UserBeanImpl implements UserBean {

    private String user = null;

    //flag:0 无权限，1有权限。
    private String flag = null;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public UserBeanImpl(String user,String flag)
    {
        this.user = user;
        this.flag = flag;
    }
    public String getUserName()
    {
        return user;
    }

    public String getUser()
    {
        System.out.println("this is getUser() method!");
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
        System.out.println("this is setUser() method!");
    }
}
