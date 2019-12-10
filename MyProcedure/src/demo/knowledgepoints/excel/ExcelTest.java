package demo.knowledgepoints.excel;

import java.util.Map;

public class ExcelTest {

    public static void main(String[] args) {
//        List<UserData> list = new ArrayList<>();   //数据源
//        list.add(new UserData(1L,"张三","123","12345678889"));
//        list.add(new UserData(2L,"李四","456","987654321"));
//        ExcelUnitl excelUnitl= new ExcelUnitl();
//        String filePath = "src\\demo\\knowledgepoints\\excel\\";    //目标文件路径
//        excelUnitl.export(list,filePath);

        String filepath = "src\\demo\\knowledgepoints\\file\\test.xls";
        ExcelUnitl excelUnitl= new ExcelUnitl(filepath);
        Map<Integer, Map<Integer,Object>> map = excelUnitl.readExcelContent();
        for (int i = 1; i <= map.size(); i++) {
            System.out.println(map.get(i));
        }
    }
}
