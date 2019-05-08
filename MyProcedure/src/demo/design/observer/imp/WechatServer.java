package demo.design.observer.imp;

import demo.design.observer.inf.Observer;
import demo.design.observer.inf.Observerable;

import java.util.ArrayList;
import java.util.List;

/**
 * ���۲��ߣ�Ҳ����΢�Ź��ںŷ���
 * ʵ����Observerable�ӿڣ���Observerable�ӿڵ��������������˾���ʵ��
 * @author jstao
 *
 */
public class WechatServer implements Observerable {
    //ע�⵽���List���ϵķ��Ͳ���ΪObserver�ӿڣ����ԭ������ӿڱ�̶���������ʵ�ֱ��
    private List<Observer> list;
    private String message;

    public WechatServer() {
        list = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {

        list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if(!list.isEmpty())
            list.remove(o);
    }

    //����
    @Override
    public void notifyObserver() {
        for(int i = 0; i < list.size(); i++) {
            Observer oserver = list.get(i);
            oserver.update(message);
        }
    }

    public void setInfomation(String s) {
        this.message = s;
        System.out.println("΢�ŷ��������Ϣ�� " + s);
        //��Ϣ���£�֪ͨ���й۲���
        notifyObserver();
    }
}
