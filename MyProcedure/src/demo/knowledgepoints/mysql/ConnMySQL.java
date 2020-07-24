package demo.knowledgepoints.mysql;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnMySQL {

    /**
     * java与MySQL的连接
     * @param args
     */
    Connection conn=null;
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");  //加载数据库驱动
            System.out.println("数据库驱动加载成功");
            String url="jdbc:mysql://localhost:3306/match?useSSL=false";
            //如果不加useSSL=false就会有警告，由于jdbc和mysql版本不同，有一个连接安全问题

            String user="root";
            String passWord="hbt106887";
            conn=(Connection) DriverManager.getConnection(url,user,passWord); //创建连接
            System.out.println("已成功的与数据库MySQL建立连接！！");
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    //显示数据库中的表
    public ResultSet listDB(){
        String sql="show tables;";
        try{
            conn=getConnection();
            Statement stmt=(Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=stmt.executeQuery(sql);
            return rs;
        }catch(SQLException ex){
            //ex.printStackTrace();
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        ConnMySQL mysql= new ConnMySQL();

        mysql.getConnection();
        ResultSet rest=mysql.listDB();
        System.out.println("数据库company中有下列数据表：");
        try{
            while(rest.next()){
                System.out.println(rest.getString(1));

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
