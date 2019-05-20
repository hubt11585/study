package demo.knowledgepoints.reflect;

public class Demo1 {
    //创建一个自己本身的公共变量
    public static demo.knowledgepoints.reflect.Demo1 demo1;

    private static final boolean flag = true ;

    //将其私有化，保证不能通过New的方式创建。
    private Demo1(){

    }

    //创建get方法，用于告知使用者，不能被new，不能被获取。
    public static Demo1 getDemo1() throws Exception{
        if(flag){
            throw new Exception("抱歉,该类不通过new 的方式创建！");
        }
        return demo1;
    }

    public void print(){
        System.out.println("恭喜成功获取Demo1！");
    }

    //通过静态代码块创建实体类。
    static {
        demo1 = new Demo1();
    }
}
