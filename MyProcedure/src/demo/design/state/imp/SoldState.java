package demo.design.state.imp;

import demo.design.state.inf.State;

public class SoldState implements State {
    private CandyMachine mCandyMachine;
    public SoldState(CandyMachine mCandyMachine)
    {
        this.mCandyMachine=mCandyMachine;
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
        System.out.println("we are giving you a candy,turning another get nothing,!");

    }

    @Override
    public void dispense() {
        // TODO Auto-generated method stub

        mCandyMachine.releaseCandy();
        if (mCandyMachine.getCount() > 0) {
            mCandyMachine.setState(mCandyMachine.mOnReadyState);
        } else {
            System.out.println("哦，糖果用完了");
            mCandyMachine.setState(mCandyMachine.mSoldOutState);
        }



    }

    @Override
    public void printstate() {
        // TODO Auto-generated method stub
        System.out.println("***售卖SoldState***");

    }
}
