package demo.design.single.hungry;

/********
 * 该方式实现单例。
 * 优点：代码简单，容易理解。
 * 缺点：因为静态，则一开始就占内存。
 */
public class SingletonHungary {
    private static SingletonHungary singletonHungary = new SingletonHungary();

    private SingletonHungary(){

    }

    public static SingletonHungary getInstance() {
        return singletonHungary;
    }
}
