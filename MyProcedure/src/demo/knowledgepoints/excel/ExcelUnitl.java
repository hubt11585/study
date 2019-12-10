package demo.knowledgepoints.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ExcelUnitl {

    private static Workbook wb =null;
    private static Sheet sheet =null;
    private static Row row =null;

//    public ExcelUnitl(){
//        //空参构造
//    }

    /**
     * 构造函数初始化wb
     * @param filepath
     */
    public ExcelUnitl(String filepath){
        if(filepath==null){
            return;
        }
        String ext = filepath.substring(filepath.lastIndexOf("."));
        try {
            InputStream is = new FileInputStream(filepath);
            if(".xls".equals(ext)){
                wb = new HSSFWorkbook(is);
            }else if(".xlsx".equals(ext)){
                wb = new XSSFWorkbook(is);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取Excel表格表头的内容
     * @return String 表头内容的数组
     * @author zengwendong
     */
    public String[] readExcelTitle() {
        if(wb==null){
            throw new RuntimeException("Excel对象为空");
        }
        sheet = wb.getSheetAt(0);
        row = sheet.getRow(0);
        // 标题总列数
        int colNum = row.getPhysicalNumberOfCells();
        System.out.println("colNum:" + colNum);
        String[] title = new String[colNum];
        for (int i = 0; i < colNum; i++) {
            title[i] = row.getCell(i).getCellFormula();
        }
        return title;
    }

    /**
     * 读取Excel数据内容
     * @return Map 包含单元格数据内容的Map对象
     * @author zengwendong
     */
    public Map<Integer, Map<Integer,Object>> readExcelContent() {
        if(wb==null){
            throw new RuntimeException("Workbook对象为空！");
        }
        Map<Integer, Map<Integer,Object>> content = new HashMap<>();

        sheet = wb.getSheetAt(0);
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        // 正文内容应该从第二行开始,第一行为表头的标题
        for (int i = 1; i <= rowNum; i++) {
            row = sheet.getRow(i);
            int j = 0;
            Map<Integer,Object> cellValue = new HashMap<>();
            while (j < colNum) {
                Object obj = getCellFormatValue(row.getCell(j));
                cellValue.put(j, obj);
                j++;
            }
            content.put(i, cellValue);
        }
        return content;
    }

    /**
     * 根据Cell类型设置数据
     * @param cell
     * @return
     * @author zengwendong
     */
    private Object getCellFormatValue(Cell cell) {
        Object cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
                case NUMERIC:{
                    // 判断当前的cell是否为Date
                    if (DateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        cellvalue = date;
                    } else {// 如果是纯数字
                        cellvalue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                case STRING:// 如果当前Cell的Type为STRING
                    cellvalue = cell.getRichStringCellValue().getString();
                    break;
                default:// 默认的Cell值
                    cellvalue = "";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;
    }

    /**
     * 导出Excel
     * @param sheetName sheet名称
     * @param title 标题
     * @param values 内容
     * @param wb HSSFWorkbook对象
     * @return
     */
//    public static HSSFWorkbook getHSSFWorkbook(String sheetName, String []title, String [][]values, HSSFWorkbook wb){
//        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
//        if(wb == null){
//            wb = new HSSFWorkbook();
//        }
//
//        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
//        HSSFSheet sheet = wb.createSheet(sheetName);
//
//        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
//        HSSFRow row = sheet.createRow(0);
//
//        // 第四步，创建单元格，并设置值表头 设置表头居中
//        HSSFCellStyle style = wb.createCellStyle();
//        style.setAlignment(HorizontalAlignment.CENTER); // 创建一个居中格式
//
//        //声明列对象
//        HSSFCell cell = null;
//
//        //创建标题
//        for(int i=0;i<title.length;i++){
//            cell = row.createCell(i);
//            cell.setCellValue(title[i]);
//            cell.setCellStyle(style);
//        }
//
//        //创建内容
//        for(int i=0;i<values.length;i++){
//            row = sheet.createRow(i + 1);
//            for(int j=0;j<values[i].length;j++){
//                //将内容按顺序赋给对应的列对象
//                row.createCell(j).setCellValue(values[i][j]);
//            }
//        }
//        return wb;
//    }
//
//    public void export(List<UserData> list,String filePath){
//        //excel标题
//        String[] title = {"用户ID", "用户名称", "用户密码", "用户手机"};
//
//        //excel文件名
//        String fileName = "用户信息表" + System.currentTimeMillis() + ".xls";
//
//        //sheet名
//        String sheetName = "用户信息表";
//
//        String [][] content = new String[list.size()][title.length];
//
//        for (int i = 0; i < list.size(); i++) {
//            content[i] = new String[title.length];
//            UserData obj = list.get(i);
//            content[i][0] = obj.getId().toString();
//            content[i][1] = obj.getUsername();
//            content[i][2] = obj.getPassword();
//            content[i][3] = obj.getPhone();
//        }
//
//        //创建HSSFWorkbook
//        HSSFWorkbook wb = getHSSFWorkbook(sheetName, title, content, null);
//        OutputStream os = null;
//        try {
//            os = new FileOutputStream(new File(filePath+fileName));
//            wb.write(os);
//            os.flush();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                if(os != null){
//                    os.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
