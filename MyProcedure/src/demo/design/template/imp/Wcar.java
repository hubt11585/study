package demo.design.template.imp;

/**
 * ���ڳ�
 * @author liaowp
 */
import demo.design.template.abs.CarModel;

public class Wcar extends CarModel {

    @Override
    protected void start() {
        System.out.println("���ڳ����� ����������������ͻͻͻ");
    }

    @Override
    protected void stop() {
        System.out.println("���ڳ�ͣ��������������������");
    }
}
