package demo.design.template.imp;

/**
 * 大众车
 * @author liaowp
 */
import demo.design.template.abs.CarModel;

public class Wcar extends CarModel {

    @Override
    protected void start() {
        System.out.println("大众车启动 。。。。。。。。突突突");
    }

    @Override
    protected void stop() {
        System.out.println("大众车停车。。。。。。。。。");
    }
}
