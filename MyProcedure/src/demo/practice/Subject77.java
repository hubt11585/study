package demo.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * ����һ���ַ���s��һЩ������ͬ�ĵ���words���ҳ� s ��ǡ�ÿ�����words �����е��ʴ����γɵ��Ӵ�����ʼλ�á�
 * ע���Ӵ�Ҫ��words �еĵ�����ȫƥ�䣬�м䲻���������ַ���������Ҫ����words�е��ʴ�����˳��
 */
public class Subject77 {
    public static void main(String[] args) {
        String s = "ababaabababababababababababababababababababababababbababababab";
        String[] words = new String[]{"ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba"};
        System.out.println(words.length);
        List<Integer> list = new Subject77().findSubstring(s,words);
        System.out.println(list);
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int wordNum = words.length;
        if (wordNum == 0) {
            return res;
        }
        int wordLen = words[0].length();
        HashMap<String, Integer> allWords = new HashMap<String, Integer>();
        for (String w : words) {
            int value = allWords.getOrDefault(w, 0);
            allWords.put(w, value + 1);
        }
        //�������ƶ��ֳ� wordLen �����
        for (int j = 0; j < wordLen; j++) {
            HashMap<String, Integer> hasWords = new HashMap<String, Integer>();
            int num = 0; //��¼��ǰ HashMap2������� hasWords ���������ж��ٸ�����
            //ÿ���ƶ�һ�����ʳ���
            for (int i = j; i < s.length() - wordNum * wordLen + 1; i = i + wordLen) {
                boolean hasRemoved = false; //��ֹ������Ƴ������һ�����Ƴ�
                while (num < wordNum) {
                    String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                    if (allWords.containsKey(word)) {
                        int value = hasWords.getOrDefault(word, 0);
                        hasWords.put(word, value + 1);
                        //����������������˷��ϵĵ��ʣ����Ǵ�������
                        if (hasWords.get(word) > allWords.get(word)) {
                            // hasWords.put(word, value);
                            hasRemoved = true;
                            int removeNum = 0;
                            //һֱ�Ƴ����ʣ�ֱ������������
                            while (hasWords.get(word) > allWords.get(word)) {
                                String firstWord = s.substring(i + removeNum * wordLen, i + (removeNum + 1) * wordLen);
                                int v = hasWords.get(firstWord);
                                hasWords.put(firstWord, v - 1);
                                removeNum++;
                            }
                            num = num - removeNum + 1; //�� 1 ����Ϊ���ǰѵ�ǰ���ʼ��뵽�� HashMap 2 ��
                            i = i + (removeNum - 1) * wordLen; //���������ǿ��ǵ��������� for ѭ������������Ľ���
                            break;
                        }
                        //����������������˲�ƥ��ĵ��ʣ�ֱ�ӽ� i �ƶ����õ��ʵĺ�ߣ�����ʵ����
                        //ֻ���ƶ����˳������ⵥ�ʵĵط�����Ϊ������� for ѭ���� i �����ƶ�һ������
                        //Ȼ��պþ��ƶ����˵��ʺ�ߣ�
                    } else {
                        hasWords.clear();
                        i = i + num * wordLen;
                        num = 0;
                        break;
                    }
                    num++;
                }
                if (num == wordNum) {
                    res.add(i);

                }
                //�������һ���Ӵ���ȫƥ�䣬���ǽ���һ���Ӵ��ĵ�һ�����ʴ� HashMap2 ���Ƴ�
                if (num > 0 && !hasRemoved) {
                    String firstWord = s.substring(i, i + wordLen);
                    int v = hasWords.get(firstWord);
                    hasWords.put(firstWord, v - 1);
                    num = num - 1;
                }
            }
        }
        return res;
    }
}
