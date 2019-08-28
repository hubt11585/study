package demo.test;

import java.util.ArrayList;
import java.util.List;

public class PublicTest {
    public static void main(String[] args) {
        int i = 3;
        switch (i) {
            case 1:
                System.out.println("正常");
                break;
            case 2:
                System.out.println("正常");
                break;
            case 5:
                System.out.println("正常");
                break;
            default:
                assert false:"i的值无效";       //如果i的值不是你想要的，程序就警告退出
        }
        System.out.println("如果断言正常，我就被打印");
    }
}
