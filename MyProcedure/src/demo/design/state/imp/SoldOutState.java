package demo.design.state.imp;

import demo.design.state.inf.State;

public class SoldOutState implements State{
    private CandyMachine mCandyMachine;
    public SoldOutState(CandyMachine mCandyMachine)
    {
        this.mCandyMachine=mCandyMachine;
    }

    @Override
    public void insertCoin() {
        // TODO Auto-generated method stub
        System.out.println("你不能投硬币，机器卖完了！");

    }

    @Override
    public void returnCoin() {
        // TODO Auto-generated method stub
        System.out.println("you can't return,you haven't inserted a coin yet!");

    }

    @Override
    public void turnCrank() {
        // TODO Auto-generated method stub
        System.out.println("你转过身来，但没有糖果！");

    }

    @Override
    public void dispense() {
        // TODO Auto-generated method stub

    }

    @Override
    public void printstate() {
        // TODO Auto-generated method stub
        System.out.println("***售出SoldOutState***");

    }
}
