package demo.design.template.abs;

/**
 * ����ģ��
 * ģ��ģʽ
 * @author liaowp
 */
public abstract class CarModel {
    /**
     * ��������
     */
    protected abstract void start();

    /**
     * ͣ��
     */
    protected abstract void stop();

    /**
     * �û�������Ҫ��ע��ĳ���ô��������ͣ�����ģ����Կ�����ͣ�Ϳ�����
     */
    final public void excet(){
        this.start();
        this.stop();
    }
}
