package demo.knowledgepoints.excel;

import java.util.Map;

public class ExcelRead {

    public static void main(String[] args) {
        try {
            String filepath = "src\\demo\\knowledgepoints\\file\\test.xlsx";
            ExcelUnitl excelUnitl= new ExcelUnitl(filepath);
            /*** 对读取Excel表格内容测试***/
            Map<Integer, Map<Integer,Object>> map = excelUnitl.readExcelContent();
            System.out.println("获得Excel表格的内容:");
            for (int i = 1; i <= map.size(); i++) {
                System.out.println(map.get(i));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
