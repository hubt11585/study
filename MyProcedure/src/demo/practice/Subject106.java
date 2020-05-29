package demo.practice;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 */
public class Subject106 {

    public static void main(String[] args) {
        int[][] arr = new Subject106().generateMatrix(5);
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("\n");
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int ward = 1;  //运行方向， 0 左到右；1 上到下；2 右到左；3 下到上。
        int distance = n;  //距离
        int remainDistance = n;  //剩余距离
        int a = 0,b = 0;  //拐点
        for (int i = 1; i <= n*n; i++) {
            if(ward%4 == 1){
                arr[a][b++] = i;
                remainDistance = remainDistance -1;
                if(remainDistance <= 0){
                    ward++;
                    distance--;
                    remainDistance = distance;
                    b = b-1;
                    a = a+1;
                }
            }else if(ward%4 == 2){
                arr[a++][b] = i;
                remainDistance = remainDistance -1;
                if(remainDistance <= 0){
                    ward++;
                    remainDistance = distance;
                    a = a-1;
                    b = b-1;
                }
            }else if(ward%4 == 3){
                arr[a][b--] = i;
                remainDistance = remainDistance -1;
                if(remainDistance <= 0){
                    ward++;
                    distance--;
                    remainDistance = distance;
                    b = b+1;
                    a = a-1;
                }
            }else{
                arr[a--][b] = i;
                remainDistance = remainDistance -1;
                if(remainDistance <= 0){
                    remainDistance = distance;
                    ward++;
                    a = a+1;
                    b = b+1;
                }
            }
        }
        return arr;
    }
}
