package demo.test;

public final class Demo {
    public static void main(String[] args){
        People obj = new People();
        if(obj instanceof Object){
            System.out.println("我是一个对象");
        }
        if(obj instanceof People){
            System.out.println("我是一个人");
        }
        if(obj instanceof Teacher){
            System.out.println("我是一名教师");
        }
        if(obj instanceof President){
            System.out.println("我是一名校长");
        }

        System.out.println(" --------------------------------------------- ");

        obj = new Teacher();
        if(obj instanceof Object){
            System.out.println("我是一个对象");
        }
        if(obj instanceof People){
            System.out.println("我是一个人");
        }
        if(obj instanceof Teacher){
            System.out.println("我是一名教师");
        }
        if(obj instanceof President){
            System.out.println("我是一名校长");
        }
    }
}
