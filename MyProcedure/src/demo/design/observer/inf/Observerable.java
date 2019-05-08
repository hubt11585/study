package demo.design.observer.inf;

import demo.design.observer.inf.Observer;

/***
 * ���󱻹۲��߽ӿ�
 * ��������ӡ�ɾ����֪ͨ�۲��߷���
 * @author jstao
 *
 */
public interface Observerable {

    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver();

}