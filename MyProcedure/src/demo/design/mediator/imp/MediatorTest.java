package demo.design.mediator.imp;

public class MediatorTest {
    /**
     * @param args
     */
    // �н��ߣ�ColleagueA��ColleagueB
    public static void main(String[] args) {
        // �����н���
        ConcreteMediator mediator = new ConcreteMediator();
        // �������ͬ����
        ColleagueA colleagueA = new ColleagueA("����", mediator);
        ColleagueB colleagueB = new ColleagueB("����", mediator);
        // �н���֪��ÿһ�������Colleague��
        mediator.setCollA(colleagueA);
        mediator.setCollB(colleagueB);
        colleagueA.contact("����A����Ҫ��ͬ��B˵˵����������");
        colleagueB.contact("����B,��������ʱ��,����������");
    }
}
