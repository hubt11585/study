package demo.knowledgepoints.Lambda.imp;

import demo.knowledgepoints.Lambda.inf.MyLamda;

public class MyLamdaIml implements MyLamda {
    @Override
    public void test1(String y) {
        System.out.println("ss"+y);
    }

    public static void main(String[] args) {
        MyLamdaIml myLamdaIml = new MyLamdaIml();
        myLamdaIml.test1("s");
    }
}
