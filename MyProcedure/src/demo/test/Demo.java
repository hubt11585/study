package demo.test;

public final class Demo {
    public static void main(String[] args){
        People obj = new People();
        if(obj instanceof Object){
            System.out.println("����һ������");
        }
        if(obj instanceof People){
            System.out.println("����һ����");
        }
        if(obj instanceof Teacher){
            System.out.println("����һ����ʦ");
        }
        if(obj instanceof President){
            System.out.println("����һ��У��");
        }

        System.out.println(" --------------------------------------------- ");

        obj = new Teacher();
        if(obj instanceof Object){
            System.out.println("����һ������");
        }
        if(obj instanceof People){
            System.out.println("����һ����");
        }
        if(obj instanceof Teacher){
            System.out.println("����һ����ʦ");
        }
        if(obj instanceof President){
            System.out.println("����һ��У��");
        }
    }
}
