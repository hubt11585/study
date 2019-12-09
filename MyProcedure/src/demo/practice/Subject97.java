package demo.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [?2^31, 2^31 ? 1] 。
 */
public class Subject97 {

    public static void main(String[] args) {
        double dou = new Subject97().myPow(1.13183,-2147483648);
        System.out.println(dou);
    }

    Map<Integer,Double> map = new HashMap<>();

    public double myPow(double x, int n) {
        double dou = 1.0;

        if(n > 0){
            if(n < 10){
                for (int i =0 ;i < n; i++){
                    dou = dou*x ;
                }
            }else{
                map.put(1,x);
                map.put(2,x*x);
                map.put(4,x*x*x*x);
                map.put(8,x*x*x*x*x*x*x*x);

                int index = 8;
                while(index <= n/2 && index < 1073741824){
                    int tmp = index;
                    index = index*2;
                    map.put(index,map.get(tmp)* map.get(tmp));
                }

                dou = map.get(index);
                int surplus = n - index;
                while(surplus > 0){
                    index = index/2;
                    if(surplus >= index){
                        dou = dou*map.get(index);
                    }else{
                        continue;
                    }
                    surplus = surplus - index;
                    if(index == 1){
                        break;
                    }
                }
            }

        }else if(n == 0){
            return 1;
        }else{
            if(n > -10){
                for (int i =0 ;i < -n; i++){
                    dou = dou*(1.0/x) ;
                }
            }else{
                map.put(-1,1.0/x);
                map.put(-2,(1.0/x)*(1.0/x));
                map.put(-4,(1.0/x)*(1.0/x)*(1.0/x)*(1.0/x));
                map.put(-8,(1.0/x)*(1.0/x)*(1.0/x)*(1.0/x)*(1.0/x)*(1.0/x)*(1.0/x)*(1.0/x));

                int index = -8;
                while(index >= n/2 ){
                    int tmp = index;
                    index = index*2;
                    map.put(index,map.get(tmp)* map.get(tmp));
                }

                dou = map.get(index);
                int surplus = n - index;
                while(surplus < 0){
                    index = index/2;
                    if(surplus <= index){
                        dou = dou*map.get(index);
                    }else{
                        continue;
                    }
                    surplus = surplus - index;
                    if(index == -1){
                        break;
                    }
                }
            }
        }
        return dou;
    }
}
