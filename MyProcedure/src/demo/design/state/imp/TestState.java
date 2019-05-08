package demo.design.state.imp;

public class TestState {
    public static void main(String[] args) {
        CandyMachine mCandyMachine = new CandyMachine(6);

        mCandyMachine.printstate();
        for (int i = 0; i < 10 ; i++) {
            // ²åÈëÓ²±Ò
            mCandyMachine.insertCoin();
            mCandyMachine.printstate();

            mCandyMachine.turnCrank();

            mCandyMachine.printstate();
        }
    }
}
