package demo.knowledgepoints.section.imp;

import demo.knowledgepoints.section.inf.UserBean;

public class UserBeanImpl implements UserBean {

    private String user = null;

    public UserBeanImpl(String user)
    {
        this.user = user;
    }
    public String getUserName()
    {
        return user;
    }


    public void getUser()
    {
        System.out.println("this is getUser() method!");
    }

    public void setUser(String user)
    {
        this.user = user;
        System.out.println("this is setUser() method!");
    }
    public void addUser()
    {
        System.out.println("this is addUser() method!" +user);
    }

}
