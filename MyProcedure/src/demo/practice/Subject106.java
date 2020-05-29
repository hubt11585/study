package demo.practice;

/**
 * ����һ�������� n������һ������ 1 �� n2 ����Ԫ�أ���Ԫ�ذ�˳ʱ��˳���������е������ξ���
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
        int ward = 1;  //���з��� 0 ���ң�1 �ϵ��£�2 �ҵ���3 �µ��ϡ�
        int distance = n;  //����
        int remainDistance = n;  //ʣ�����
        int a = 0,b = 0;  //�յ�
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
