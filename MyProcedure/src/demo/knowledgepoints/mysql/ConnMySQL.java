package demo.knowledgepoints.mysql;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnMySQL {

    /**
     * java��MySQL������
     * @param args
     */
    Connection conn=null;
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");  //�������ݿ�����
            System.out.println("���ݿ��������سɹ�");
            String url="jdbc:mysql://localhost:3306/match?useSSL=false";
            //�������useSSL=false�ͻ��о��棬����jdbc��mysql�汾��ͬ����һ�����Ӱ�ȫ����

            String user="root";
            String passWord="hbt106887";
            conn=(Connection) DriverManager.getConnection(url,user,passWord); //��������
            System.out.println("�ѳɹ��������ݿ�MySQL�������ӣ���");
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    //��ʾ���ݿ��еı�
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
        System.out.println("���ݿ�company�����������ݱ�");
        try{
            while(rest.next()){
                System.out.println(rest.getString(1));

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
