package demo.design.prototype.deepcopy.imp;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        //深复制
        Address address=new Address("河北省","石家庄");
        Programmer a=new Programmer("唐三",address);
        a.setAddress(new Address("江西省", "南昌市"));
        a.setName("赵三");
        Programmer b=(Programmer) a.clone();
        b.setName("张龙");
        b.getAddress().setProvince("江苏省");
        System.out.println(a.getName()+a.getAddress().getProvince());
        System.out.println(b.getName()+b.getAddress().getProvince());
    }
}
