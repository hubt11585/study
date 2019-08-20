package demo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Demo {
    public static void main(String[] args) {
        List<TAImport> dataList = new ArrayList<TAImport>();
        dataList.add(new TAImport("1","00001"));
        dataList.add(new TAImport("2","00001"));
        dataList.add(new TAImport("3","00003"));
        dataList.add(new TAImport("4","00003"));
        dataList.add(new TAImport("5","00005"));

        Map<String, List<TAImport>> fundTaMap = dataList.stream()
                .collect(Collectors.groupingBy(TAImport::getFund_code));

        System.out.println(fundTaMap);
    }
}