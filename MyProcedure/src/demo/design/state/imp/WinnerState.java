package demo.design.state.imp;

import demo.design.state.inf.State;

public class WinnerState implements State {

    private CandyMachine mCandyMachine;

    public WinnerState(CandyMachine mCandyMachine) {
        this.mCandyMachine = mCandyMachine;
    }

    @Override
    public void insertCoin() {
        // TODO Auto-generated method stub
        System.out.println("please wait!we are giving you a candy!");

    }

    @Override
    public void returnCoin() {
        // TODO Auto-generated method stub
        System.out.println("you haven't inserted a coin yet!");

    }

    @Override
    public void turnCrank() {
        // TODO Auto-generated method stub
        System.out
                .println("we are giving you a candy,turning another get nothing,!");

    }

    @Override
    public void dispense() {
        // TODO Auto-generated method stub


        mCandyMachine.releaseCandy();
        if (mCandyMachine.getCount() == 0) {
            mCandyMachine.setState(mCandyMachine.mSoldOutState);
        } else {
            System.out.println("����Ӯ�ң�������һ���ǹ���");
            mCandyMachine.releaseCandy();
            if (mCandyMachine.getCount() > 0) {
                mCandyMachine.setState(mCandyMachine.mOnReadyState);
            } else {
                System.out.println("Ŷ���ǹ�������");
                mCandyMachine.setState(mCandyMachine.mSoldOutState);
            }
        }

    }

    @Override
    public void printstate() {
        // TODO Auto-generated method stub
        System.out.println("***Ӯ��WinnerState***");

    }
}
