package demo.design.template.imp;

import demo.design.template.abs.CarModel;

public class TestTemplate {
    public static void main(String[] args) {
        CarModel wcar=new Wcar();//����ĵ�һ��������Ϊ�û������ǲ�����Ҫ��ע����ô������.���������Ϊ���ࡣ��̬
        wcar.excet();

        //ͻȻ������Ҫ�ڶ�������   �µ�     ����Ҳ����Ҫ��ע����ô����������
        CarModel ocar=new Ocar();
        ocar.excet();
    }
}
