package demo.knowledgepoints.functionpointer;

import demo.knowledgepoints.functionpointer.inf.Function;

public class Remote {
    public void service(Function<String,String> str){
        str.apply("hello", "world...");
    }
}
