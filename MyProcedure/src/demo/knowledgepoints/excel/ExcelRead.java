package demo.knowledgepoints.excel;

import java.util.Map;

public class ExcelRead {

    public static void main(String[] args) {
        try {
            String filepath = "src\\demo\\knowledgepoints\\file\\test.xlsx";
            ExcelUnitl excelUnitl= new ExcelUnitl(filepath);
            /*** �Զ�ȡExcel������ݲ���***/
            Map<Integer, Map<Integer,Object>> map = excelUnitl.readExcelContent();
            System.out.println("���Excel��������:");
            for (int i = 1; i <= map.size(); i++) {
                System.out.println(map.get(i));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
