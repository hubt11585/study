package demo.knowledgepoints.jvm;

public class JvmTest3 {

    public static void main(String[] args) {
        new Thread(() -> {
            while(true){
                new AA();
            }

        }).start();

        new Thread(() -> {
            while(true) {
                new BB();
            }
        }).start();
    }
}

class AA{
    static {
        System.out.println("创建AA对象");
        new BB();
    }
}

class BB{
    static {
        System.out.println("创建BB对象");
        new AA();
    }
}
