package demo.design.observer.inf;

/***
 * ����۲���
 * ������һ��update()�����������۲��ߵ���notifyObservers()����ʱ���۲��ߵ�update()�����ᱻ�ص���
 * @author jstao
 *
 */
public interface Observer {
    public void update(String message);
}
