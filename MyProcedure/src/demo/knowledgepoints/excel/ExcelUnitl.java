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
//        //�ղι���
//    }

    /**
     * ���캯����ʼ��wb
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
     * ��ȡExcel����ͷ������
     * @return String ��ͷ���ݵ�����
     * @author zengwendong
     */
    public String[] readExcelTitle() {
        if(wb==null){
            throw new RuntimeException("Excel����Ϊ��");
        }
        sheet = wb.getSheetAt(0);
        row = sheet.getRow(0);
        // ����������
        int colNum = row.getPhysicalNumberOfCells();
        System.out.println("colNum:" + colNum);
        String[] title = new String[colNum];
        for (int i = 0; i < colNum; i++) {
            title[i] = row.getCell(i).getCellFormula();
        }
        return title;
    }

    /**
     * ��ȡExcel��������
     * @return Map ������Ԫ���������ݵ�Map����
     * @author zengwendong
     */
    public Map<Integer, Map<Integer,Object>> readExcelContent() {
        if(wb==null){
            throw new RuntimeException("Workbook����Ϊ�գ�");
        }
        Map<Integer, Map<Integer,Object>> content = new HashMap<>();

        sheet = wb.getSheetAt(0);
        // �õ�������
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        // ��������Ӧ�ôӵڶ��п�ʼ,��һ��Ϊ��ͷ�ı���
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
     * ����Cell������������
     * @param cell
     * @return
     * @author zengwendong
     */
    private Object getCellFormatValue(Cell cell) {
        Object cellvalue = "";
        if (cell != null) {
            // �жϵ�ǰCell��Type
            switch (cell.getCellType()) {
                case NUMERIC:{
                    // �жϵ�ǰ��cell�Ƿ�ΪDate
                    if (DateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        cellvalue = date;
                    } else {// ����Ǵ�����
                        cellvalue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                case STRING:// �����ǰCell��TypeΪSTRING
                    cellvalue = cell.getRichStringCellValue().getString();
                    break;
                default:// Ĭ�ϵ�Cellֵ
                    cellvalue = "";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;
    }

    /**
     * ����Excel
     * @param sheetName sheet����
     * @param title ����
     * @param values ����
     * @param wb HSSFWorkbook����
     * @return
     */
//    public static HSSFWorkbook getHSSFWorkbook(String sheetName, String []title, String [][]values, HSSFWorkbook wb){
//        // ��һ��������һ��HSSFWorkbook����Ӧһ��Excel�ļ�
//        if(wb == null){
//            wb = new HSSFWorkbook();
//        }
//
//        // �ڶ�������workbook�����һ��sheet,��ӦExcel�ļ��е�sheet
//        HSSFSheet sheet = wb.createSheet(sheetName);
//
//        // ����������sheet����ӱ�ͷ��0��,ע���ϰ汾poi��Excel����������������
//        HSSFRow row = sheet.createRow(0);
//
//        // ���Ĳ���������Ԫ�񣬲�����ֵ��ͷ ���ñ�ͷ����
//        HSSFCellStyle style = wb.createCellStyle();
//        style.setAlignment(HorizontalAlignment.CENTER); // ����һ�����и�ʽ
//
//        //�����ж���
//        HSSFCell cell = null;
//
//        //��������
//        for(int i=0;i<title.length;i++){
//            cell = row.createCell(i);
//            cell.setCellValue(title[i]);
//            cell.setCellStyle(style);
//        }
//
//        //��������
//        for(int i=0;i<values.length;i++){
//            row = sheet.createRow(i + 1);
//            for(int j=0;j<values[i].length;j++){
//                //�����ݰ�˳�򸳸���Ӧ���ж���
//                row.createCell(j).setCellValue(values[i][j]);
//            }
//        }
//        return wb;
//    }
//
//    public void export(List<UserData> list,String filePath){
//        //excel����
//        String[] title = {"�û�ID", "�û�����", "�û�����", "�û��ֻ�"};
//
//        //excel�ļ���
//        String fileName = "�û���Ϣ��" + System.currentTimeMillis() + ".xls";
//
//        //sheet��
//        String sheetName = "�û���Ϣ��";
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
//        //����HSSFWorkbook
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
