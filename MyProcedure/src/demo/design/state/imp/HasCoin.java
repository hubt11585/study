package demo.design.state.imp;

import demo.design.state.inf.State;

import java.util.Random;

public class HasCoin implements State {

    private CandyMachine mCandyMachine;

    public HasCoin(CandyMachine mCandyMachine) {
        this.mCandyMachine = mCandyMachine;
    }

    @Override
    public void insertCoin() {
        // TODO Auto-generated method stub
        System.out.println("you can't insert another coin!");

    }

    @Override
    public void returnCoin() {
        // TODO Auto-generated method stub
        System.out.println("coin return!");
        mCandyMachine.setState(mCandyMachine.mOnReadyState);
    }

    @Override
    public void turnCrank() {
        // TODO Auto-generated method stub
        System.out.println("扭一扭...!");
        Random ranwinner=new Random();
        int winner=ranwinner.nextInt(2);
        System.out.println("结果是："+winner);
        if(winner==0){
            mCandyMachine.setState(mCandyMachine.mWinnerState);
        }else{
            mCandyMachine.setState(mCandyMachine.mSoldState);
        }

    }

    @Override
    public void dispense() {
    }

    @Override
    public void printstate() {
        // TODO Auto-generated method stub
        System.out.println("***插入硬币HasCoin***");

    }
}
