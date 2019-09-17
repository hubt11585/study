package demo.practice;

import java.util.ArrayList;
import java.util.List;


/**
 * �ж�һ��9x9 �������Ƿ���Ч��ֻ��Ҫ�������¹�����֤�Ѿ�����������Ƿ���Ч���ɡ�
 * ����1-9��ÿһ��ֻ�ܳ���һ�Ρ�
 * ����1-9��ÿһ��ֻ�ܳ���һ�Ρ�
 * ����1-9��ÿһ���Դ�ʵ�߷ָ���3x3����ֻ�ܳ���һ�Ρ�
 */
public class Subject83 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}};
        System.out.println( new Subject83().isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        //У����
        for (int i = 0; i < 9; i++) {
            List<Character> list= new ArrayList<Character>();
            List<Character> list0= new ArrayList<Character>();
            for (int j = 0; j < 9; j++) {
                char c = board[j][i];
                if(c != '.'){
                    if(list.contains(c)){
                        return false;
                    } else {
                        list.add(c);
                    }
                }
                c = board[i][j];
                if(c != '.'){
                    if(list0.contains(c)){
                        return false;
                    } else {
                        list0.add(c);
                    }
                }
            }
        }
        //У��С��
        List<char[]> list = new ArrayList<>();
        list.add(new char[]{0,1,2});
        list.add(new char[]{3,4,5});
        list.add(new char[]{6,7,8});
        for (int i = 0; i < list.size(); i++) {
            char[] arr1 = list.get(i);
            for (int j = 0; j < list.size(); j++) {
                char[] arr2 = list.get(j);
                List<Character> list1= new ArrayList<Character>();
                for (int k = 0; k < arr1.length; k++) {
                    for (int l = 0; l < arr2.length; l++) {
                        char c = board[arr1[k]][arr2[l]];
                        if(c != '.'){
                            if(list1.contains(c)){
                                return false;
                            } else {
                                list1.add(c);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
