package demo.knowledgepoints.Lambda.imp;

import demo.knowledgepoints.Lambda.inf.MyLamda;

public class LambdaTest {
    public static void main(String[] args) {
        MyLamda m = (y) ->{ System.out.println("ss"+y);};
        m.test1("s");
    }
}
