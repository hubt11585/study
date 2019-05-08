package demo.design.prototype.deepcopy.imp;

import java.io.*;

public class Address implements Cloneable{

    private String province;//ʡ

    private String city;//��

    public Object clone(){

        Address address = null;
        try {
            address = (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return address;
    }
    public Address(String province,String city){
        this.province=province;
        this.city=city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    /* ��ƶ����Ƶ�д������Ҫ�����л�*/
//    public Object deepClone() throws IOException, ClassNotFoundException {
//
//        /* д�뵱ǰ����Ķ������� */
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        ObjectOutputStream oos = new ObjectOutputStream(bos);
//        oos.writeObject(this);
//
//        /* �������������������¶��� */
//        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
//        ObjectInputStream ois = new ObjectInputStream(bis);
//        return ois.readObject();
//    }
}
