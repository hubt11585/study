package demo.design.prototype.shallowcopy.imp;

public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {
        //ǳ����
        Address address=new Address("�ӱ�ʡ","ʯ��ׯ");
        Programmer a=new Programmer("����",address);
        a.setAddress(new Address("����ʡ", "�ϲ�"));
        a.setName("����");
        Programmer b=(Programmer) a.clone();
        b.setName("����");
        b.getAddress().setProvince("����ʡ");
        System.out.println(a.getName()+a.getAddress().getProvince());
        System.out.println(b.getName()+b.getAddress().getProvince());
    }
}
