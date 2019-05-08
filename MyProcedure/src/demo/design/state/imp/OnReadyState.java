package demo.design.state.imp;

import demo.design.state.inf.State;

public class OnReadyState implements State {

    private CandyMachine mCandyMachine;
    public OnReadyState(CandyMachine mCandyMachine)
    {
        this.mCandyMachine=mCandyMachine;
    }

    @Override
    public void insertCoin() {
        // TODO Auto-generated method stub
        System.out.println("���Ѿ�����һöӲ�ң���һ������ת��������");
        mCandyMachine.setState(mCandyMachine.mHasCoin);
    }

    @Override
    public void returnCoin() {
        // TODO Auto-generated method stub
        System.out.println("you haven't inserted a coin yet!");

    }

    @Override
    public void turnCrank() {
        // TODO Auto-generated method stub
        System.out.println("you turned,but you haven't inserted a coin!");

    }

    @Override
    public void dispense() {
        // TODO Auto-generated method stub

    }

    @Override
    public void printstate() {
        // TODO Auto-generated method stub
        System.out.println("***׼��״̬��OnReadyState***");

    }
}
